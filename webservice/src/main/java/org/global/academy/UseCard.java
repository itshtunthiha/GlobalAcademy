package org.global.academy;

import java.util.ArrayList;
import java.util.List;

public class UseCard {
    private static List<Flashcard> cards = new ArrayList<>();

    static {
        cards.add(new Flashcard("สวัสดี", "Hello"));
        cards.add(new Flashcard("ขอบคุณ", "Thank you"));
        cards.add(new Flashcard("ยินดีที่ได้<br>รู้จัก", "Nice to meet you"));
    }
    
    public static List<Flashcard> getAllCards() {
        return cards;
    }

    public static Flashcard getRandomCard() {
        int idx = (int) (Math.random() * cards.size());
        return cards.get(idx);
    }
}
