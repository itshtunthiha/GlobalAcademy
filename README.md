# 📘 **NONG MALI — Thai Learning Web App**

Welcome to **NONG MALI**, a simple but engaging web app designed to help users learn Thai vocabulary through beautiful flashcards, progress tracking, and a clean modern UI.

This project includes:

* ✔ A Java backend built with **Spark Java**
* ✔ Static frontend pages (HTML, CSS, JS)
* ✔ Flashcard system with front/back flipping
* ✔ Token-based login
* ✔ Beautiful UI inspired by educational apps

---

## 📂 Project Structure

```
webservice/
├── pom.xml                     # Maven config
├── src/
│   ├── main/
│   │   ├── java/org/global/academy/
│   │   │   ├── Server.java                 # Main backend server
│   │   │   ├── Flashcard.java              # Flashcard model
│   │   │   ├── ThaiConsonantFlashcard.java # Thai consonant cards
│   │   │   ├── UseCard.java                # Utility for flashcards
│   │   │   └── IntegerResponse.java        # Simple API response
│   │   └── resources/public/               # Frontend files
│   │       ├── index.html
│   │       ├── welcome.html
│   │       ├── about.html
│   │       ├── flashcards.html
│   │       ├── login.html
│   │       ├── index_style.css
│   │       ├── bunny.png / bunny-graphic.png
│   │       └── icons/
│   │           ├── bolt.svg
│   │           ├── brain.svg
│   │           ├── heart.svg
│   │           └── trophy.svg
└── target/                     # Compiled output
```

---

## 🚀 Running the Project

### **1. Build with Maven**

```
mvn clean package
```

This generates:

```
target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### **2. Run the server**

```
java -jar target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar
```

The server runs on:

👉 **[http://localhost:8080](http://localhost:8080)**

---

## 🎮 Flashcards Feature

The `flashcards.html` page:

* Loads flashcards from
  **GET /flashcards/default**
* Displays cards with a flip animation
* Requires login (JWT token stored in localStorage)
* Uses clean UI and Thai fonts

Flashcard JSON example:

```json
[
  { "front": "ก", "back": "Gaw Gai" },
  { "front": "ข", "back": "Khaw Khai" }
]
```

---

## 🔐 Authentication

Login is handled by:

```
POST /login
```

On success, the backend returns:

```json
{
  "token": "jwt-token",
  "username": "example"
}
```

The client stores it:

```
localStorage.setItem("token", token)
localStorage.setItem("username", username)
```

If no token → user is redirected to `login.html`.

---

## 🖥 Frontend Pages Summary

| File                                   | Description                                    |
| -------------------------------------- | ---------------------------------------------- |
| **index.html**                         | Welcome landing page                           |
| **welcome.html**                       | Post-login greeting                            |
| **login.html**                         | Login UI                                       |
| **flashcards.html**                    | Flashcards game                                |
| **about.html**                         | About NONG MALI                                |

---

## 🛠 Tech Stack

### **Backend**

* Java 17+
* Spark Java (Micro-framework)
* Maven
* Gson (JSON serialization)

### **Frontend**

* Vanilla HTML
* CSS
* JavaScript
* Custom UI inspired by modern learning apps

---

## 🌸 NONG MALI Philosophy

NONG MALI aims to make Thai learning:

* **Simple**
* **Fun**
* **Beautiful**
* **Beginner-friendly**

Learning Thai should feel like playing, not studying ✨

---

## 📄 License

This project is for educational use.

---

## 💖 Author

Created by **Global Academy Students during OOP class**.
