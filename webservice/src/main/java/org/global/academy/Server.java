package org.global.academy;

import com.google.gson.Gson;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.options;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Server {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/public");

        // Simple CORS
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });

        options("/*", (req, res) -> {
            String headers = req.headers("Access-Control-Request-Headers");
            if (headers != null) res.header("Access-Control-Allow-Headers", headers);
            String method = req.headers("Access-Control-Request-Method");
            if (method != null) res.header("Access-Control-Allow-Methods", method);
            return "OK";
        });

        Gson gson = new Gson();

        // 🔒 LOGIN REQUIRED FOR FLASHCARD ROUTES
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

        // Protected API — must be logged in
        get("/flashcards/random", (req, res) -> {
            Flashcard card = UseCard.getRandomCard();
            res.type("application/json");
            return gson.toJson(card);
        });

        // Public — Login endpoint
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
}
