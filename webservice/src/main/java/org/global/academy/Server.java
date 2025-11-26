package org.global.academy;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.options;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import static spark.Spark.threadPool;

public class Server {
    public static void main(String[] args) {
        port(8080);

        // ⚡ Faster server thread pool
        threadPool(40, 5, 30000);

        // ⚡ Cache static files for 1 day
        staticFiles.location("/public");
        staticFiles.expireTime(3600 * 24 * 1);

        // Allow GZIP
        after((req, res) -> res.header("Content-Encoding", "gzip"));

        // Simple CORS
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });

        options("/*", (req, res) -> {
            String headers = req.headers("Access-Control-Request-Headers");
            if (headers != null)
                res.header("Access-Control-Allow-Headers", headers);

            String method = req.headers("Access-Control-Request-Method");
            if (method != null)
                res.header("Access-Control-Allow-Methods", method);

            return "OK";
        });

        // Simple in-memory session tracking for reviewed cards
        // Token -> Set of reviewed card fronts
        Map<String, Set<String>> userReviewedCards = new ConcurrentHashMap<>();

        Gson gson = new Gson();

        // Authentication
        before("/flashcards/*", (req, res) -> {
            String auth = req.headers("Authorization");
            if (auth == null || !auth.equals("Bearer a-fake-token")) {
                res.status(401);
                res.type("application/json");
                halt(401, gson.toJson(new ErrorResponse("Not logged in")));
            }
        });

        get("/flashcards/default", (req, res) -> {
            res.type("application/json");
            return gson.toJson(UseCard.getAllCards());
        });

        get("/flashcards/random", (req, res) -> {
            Flashcard card = UseCard.getRandomCard();
            res.type("application/json");
            return gson.toJson(card);
        });

        get("/flashcards/randbatch", (req, res) -> {
            String auth = req.headers("Authorization");
            String token = auth.substring(7); // Remove "Bearer "

            userReviewedCards.putIfAbsent(token, Collections.synchronizedSet(new HashSet<>()));
            Set<String> reviewed = userReviewedCards.get(token);

            List<Flashcard> batch = UseCard.getUnreviewedCards(reviewed, 7);

            int totalCards = UseCard.getAllCards().size();
            int reviewedCount = reviewed.size();

            res.type("application/json");
            return gson.toJson(new BatchResponse(batch, reviewedCount, totalCards));
        });

        post("/flashcards/mark_reviewed", (req, res) -> {
            String auth = req.headers("Authorization");
            String token = auth.substring(7); // Remove "Bearer "

            userReviewedCards.putIfAbsent(token, Collections.synchronizedSet(new HashSet<>()));
            Set<String> reviewed = userReviewedCards.get(token);

            // Expect JSON body with {"cardFront": "..."}
            com.google.gson.JsonObject body = gson.fromJson(req.body(), com.google.gson.JsonObject.class);
            String cardFront = body.get("cardFront").getAsString();

            reviewed.add(cardFront);

            res.type("application/json");
            return gson.toJson("OK");
        });

        post("/flashcards/clear_progress", (req, res) -> {
            String auth = req.headers("Authorization");
            String token = auth.substring(7); // Remove "Bearer "

            if (userReviewedCards.containsKey(token)) {
                userReviewedCards.get(token).clear();
            }

            res.type("application/json");
            return gson.toJson("OK");
        });

        post("/login", (req, res) -> {
            System.out.println("Received /login request with body: " + req.body());
            LoginRequest lr = gson.fromJson(req.body(), LoginRequest.class);

            if ("alice".equals(lr.username) && "secret".equals(lr.password)) {
                res.type("application/json");
                return gson.toJson(new LoginResponse("a-fake-token", lr.username));
            } else {
                res.status(401);
                res.type("application/json");
                return gson.toJson(new ErrorResponse("Invalid credentials"));
            }
        });
    }

    static class LoginRequest {
        String username;
        String password;
    }

    static class LoginResponse {
        String token;
        String username;

        LoginResponse(String t, String u) {
            token = t;
            username = u;
        }
    }

    static class ErrorResponse {
        String error;

        ErrorResponse(String e) {
            error = e;
        }
    }

    static class BatchResponse {
        List<Flashcard> cards;
        int reviewedCount;
        int totalCount;

        BatchResponse(List<Flashcard> c, int r, int t) {
            cards = c;
            reviewedCount = r;
            totalCount = t;
        }
    }
}
