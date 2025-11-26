package org.global.academy;

public class ThaiConsonantFlashcard extends Flashcard {
    private String pronunciation;

    public ThaiConsonantFlashcard(String front, String back, String pronunciation) {
        super(front, back, pronunciation);
        this.pronunciation = pronunciation;
    }

    public String getPronunciation() {
        return pronunciation;
    }
}
