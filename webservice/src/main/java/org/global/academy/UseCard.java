package org.global.academy;

import java.util.ArrayList;
import java.util.List;

public class UseCard {
    private static List<Flashcard> cards = new ArrayList<>();

    static {
        // Add some sample Thai consonant flashcards
        cards.add(new ThaiConsonantFlashcard("ก", "g/k", "ko kai"));
        cards.add(new ThaiConsonantFlashcard("ข", "kh", "kho khai"));
        cards.add(new ThaiConsonantFlashcard("ค", "kh", "kho khwai"));
        cards.add(new ThaiConsonantFlashcard("ง", "ng", "ngo ngu"));
    }

    public static List<Flashcard> getAllCards() {
        return cards;
    }

    public static Flashcard getRandomCard() {
        int idx = (int) (Math.random() * cards.size());
        return cards.get(idx);
    }
}
