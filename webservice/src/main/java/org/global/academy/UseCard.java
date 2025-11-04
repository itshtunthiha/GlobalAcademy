package org.global.academy;


import java.util.ArrayList;
import java.util.List;

public class UseCard {
    public static void main(String[] args) {
         List<ThaiConsonantFlashcard> card = new ArrayList<>();
         card.add(new ThaiConsonantFlashcard("ก", "กไก่", "gaaw gài","Middle"));
         card.add(new ThaiConsonantFlashcard("ข", "ขไข่", "khǎaw khài", "High"));
         card.add(new ThaiConsonantFlashcard("ฃ", "ฃขวด", "khǎaw khùuat", "High"));
        for (ThaiConsonantFlashcard letter:card) 
        {
            letter.showCard();
            // statements to be executed for each element
        }

    }
   

}
