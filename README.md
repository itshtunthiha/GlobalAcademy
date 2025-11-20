# 📘 **NONG MALI — Thai Learning Web App**

**NONG MALI** is an engaging Thai-learning web application designed to help beginners practice Thai consonants and vocabulary through interactive flashcards, clean UI, and a lightweight Java backend.

🌐 **Live Demo:**
👉 **[https://nongmali.up.railway.app/](https://nongmali.up.railway.app/)**

---

## 📸 Preview

![NONG MALI Preview](preview.png)

---

# 📂 Project Structure

```
.
├── Dockerfile
├── start.sh                     # Startup script for Railway
├── README.md
├── preview.png
└── webservice/
    ├── pom.xml                  # Maven configuration
    ├── src/
    │   ├── main/
    │   │   ├── java/org/global/academy/
    │   │   │   ├── Server.java
    │   │   │   ├── Flashcard.java
    │   │   │   ├── ThaiConsonantFlashcard.java
    │   │   │   ├── UseCard.java
    │   │   │   └── IntegerResponse.java
    │   │   └── resources/public/
    │   │       ├── index.html
    │   │       ├── login.html
    │   │       ├── about.html
    │   │       ├── flashcards.html
    │   │       ├── css/index-style.css
    │   │       ├── imgs/bunny.png
    │   │       └── icons/*.svg
    └── target/ (compiled binaries)
```

---

# 🚀 Running the Project Locally

### 1️⃣ **Build With Maven**

```bash
cd webservice
mvn clean package
```

This generates:

```
target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

### 2️⃣ **Run the Server**

```bash
java -jar target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Your app will be available at:

👉 **[http://localhost:8080](http://localhost:8080)**

---

# ☁️ Deployment (Railway)

This project is fully deployed on **Railway.app**, using:

✔ Java 17
✔ Dockerfile
✔ `start.sh` entrypoint

Live Deployment URL:

👉 **[https://nongmali.up.railway.app/](https://nongmali.up.railway.app/)**

To redeploy:

1. Push changes to GitHub
2. Railway automatically rebuilds & redeploys your Docker image

If you want manual deploy:

```bash
railway up
```

---

# 🎮 Flashcards System

The **flashcards** page loads data from:

```
GET /flashcards/default
```

Features:

* 🃏 Flip animation (front/back)
* 🔤 Thai consonants + transliteration
* 🔐 Requires login token
* 🎨 Clean UI inspired by mobile language-learning apps

**Flashcard JSON Example:**

```json
[
  { "front": "ก", "back": "Gaw Gai" },
  { "front": "ข", "back": "Khaw Khai" }
]
```

---

# 🔐 Authentication Flow

Login endpoint:

```
POST /login
```

Response:

```json
{
  "token": "jwt-token",
  "username": "example"
}
```

Stored in browser:

```javascript
localStorage.setItem("token", token);
```

If no token → user is redirected to `login.html`.

---

# 🖥 Frontend Pages Overview

| File              | Description             |
| ----------------- | ----------------------- |
| `index.html`      | Landing page            |
| `login.html`      | Login screen            |
| `flashcards.html` | Main learning interface |
| `about.html`      | App and team info       |
| `bunny.png`       | Mascot character        |

---

# 🛠 Tech Stack

### **Backend**

* Java 17
* Spark Java
* Maven
* Gson

### **Frontend**

* HTML5
* CSS3
* JavaScript
* Mobile-friendly UI

### **Deployment**

* Railway (Docker)
* Bash startup script

---

# 🌸 Philosophy

**NONG MALI** aims to make learning Thai:

✨ Simple
✨ Fun
✨ Visual
✨ Beginner-friendly

Learning should feel like playing, not memorizing.

---

# 📄 License

This project is created for **educational use**.

---

# 💖 Author

Created by **Global Academy Students**
👩‍🏫 During the OOP Java Programming Course