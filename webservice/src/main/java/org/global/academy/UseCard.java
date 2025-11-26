package org.global.academy;

import java.util.ArrayList;
import java.util.List;

public class UseCard {
    private static List<Flashcard> cards = new ArrayList<>();

    static {
        cards.add(new Flashcard("สวัสดี", "Hello", "sà-wàt-dii"));
        cards.add(new Flashcard("ขอบคุณ", "Thank you", "kòp-kun"));
        cards.add(new Flashcard("ยินดีที่ได้<br>รู้จัก", "Nice to meet you", "yin-dii-tîi-dâi-rúu-jàk"));
        cards.add(new Flashcard("ใช่", "Yes", "châi"));
        cards.add(new Flashcard("ไม่", "No", "mâi"));
        cards.add(new Flashcard("ขอโทษ", "Sorry", "kŏr-tôht"));
        cards.add(new Flashcard("ลาก่อน", "Goodbye", "laa-gòn"));
        cards.add(new Flashcard("ช่วยเหลือ", "Help", "chûay-lĕua"));
        cards.add(new Flashcard("น้ำ", "Water", "náam"));
        cards.add(new Flashcard("อาหาร", "Food", "aa-hăan"));
        cards.add(new Flashcard("ห้องน้ำ", "Bathroom", "hông-náam"));
        cards.add(new Flashcard("เท่าไหร่", "How much?", "tâo-rài"));
        cards.add(new Flashcard("แพง", "Expensive", "paeng"));
        cards.add(new Flashcard("ถูก", "Cheap", "tùuk"));
        cards.add(new Flashcard("อร่อย", "Delicious", "à-ròi"));
        cards.add(new Flashcard("เผ็ด", "Spicy", "pèt"));
        cards.add(new Flashcard("ร้อน", "Hot", "rón"));
        cards.add(new Flashcard("หนาว", "Cold", "năao"));
        cards.add(new Flashcard("สวย", "Beautiful", "sŭay"));
        cards.add(new Flashcard("น่ารัก", "Cute", "nâa-rák"));
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
