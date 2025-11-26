package org.global.academy;

public class Flashcard {
    private String front; // e.g., Thai character
    private String back; // e.g., English meaning
    private String pronunciation; // e.g., romanization

    public Flashcard(String front, String back, String pronunciation) {
        this.front = front;
        this.back = back;
        this.pronunciation = pronunciation;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public String getPronunciation() {
        return pronunciation;
    }
}
