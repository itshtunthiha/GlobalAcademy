package org.global.academy;

import java.util.ArrayList;
import java.util.List;

public class UseCard {
    private static List<Flashcard> cards = new ArrayList<>();

    static {
        cards.add(new Flashcard("สวัสดี", "Hello"));
        cards.add(new Flashcard("ขอบคุณ", "Thank you"));
        cards.add(new Flashcard("ยินดีที่ได้<br>รู้จัก", "Nice to meet you"));
        cards.add(new Flashcard("ใช่", "Yes"));
        cards.add(new Flashcard("ไม่", "No"));
        cards.add(new Flashcard("ขอโทษ", "Sorry"));
        cards.add(new Flashcard("ลาก่อน", "Goodbye"));
        cards.add(new Flashcard("ช่วยเหลือ", "Help"));
        cards.add(new Flashcard("น้ำ", "Water"));
        cards.add(new Flashcard("อาหาร", "Food"));
        cards.add(new Flashcard("ห้องน้ำ", "Bathroom"));
        cards.add(new Flashcard("เท่าไหร่", "How much?"));
        cards.add(new Flashcard("แพง", "Expensive"));
        cards.add(new Flashcard("ถูก", "Cheap"));
        cards.add(new Flashcard("อร่อย", "Delicious"));
        cards.add(new Flashcard("เผ็ด", "Spicy"));
        cards.add(new Flashcard("ร้อน", "Hot"));
        cards.add(new Flashcard("หนาว", "Cold"));
        cards.add(new Flashcard("สวย", "Beautiful"));
        cards.add(new Flashcard("น่ารัก", "Cute"));
    }

    public static List<Flashcard> getAllCards() {
        return cards;
    }

    public static Flashcard getRandomCard() {
        int idx = (int) (Math.random() * cards.size());
        return cards.get(idx);
    }

    public static List<Flashcard> getUnreviewedCards(java.util.Set<String> reviewedFronts, int limit) {
        List<Flashcard> unreviewed = new ArrayList<>();
        for (Flashcard card : cards) {
            if (!reviewedFronts.contains(card.getFront())) {
                unreviewed.add(card);
            }
        }

        List<Flashcard> result = new ArrayList<>();
        java.util.Collections.shuffle(unreviewed);

        for (int i = 0; i < Math.min(limit, unreviewed.size()); i++) {
            result.add(unreviewed.get(i));
        }
        return result;
    }
}
