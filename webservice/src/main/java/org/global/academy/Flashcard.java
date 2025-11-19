package org.global.academy;

public class Flashcard {
    private String front;  // e.g., Thai character
    private String back;   // e.g., English meaning

    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}
