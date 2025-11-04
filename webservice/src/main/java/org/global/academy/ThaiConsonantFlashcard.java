package org.global.academy;

import javax.swing.*;


public class ThaiConsonantFlashcard extends Flashcard{

    private String symbol;
    private String thaiReading;
    private String romanizedPronunciation;
    private String toneClass;
    
    // Constructor
    public ThaiConsonantFlashcard(String symbol, String thaiReading, 
                                String romanizedPronunciation, String toneClass) {
        // Front: Symbol (ก) Thai reading (กอ ไก่)
        super(symbol + " " + thaiReading, 
              "Romanized English pronunciation (" + romanizedPronunciation + ") Tone class (" + toneClass + ")");
        
        this.symbol = symbol;
        this.thaiReading = thaiReading;
        this.romanizedPronunciation = romanizedPronunciation;
        this.toneClass = toneClass;
    }
    
    // Getter methods for new fields
    public String getSymbol() {
        return symbol;
    }
    
    public String getThaiReading() {
        return thaiReading;
    }
    
    public String getRomanizedPronunciation() {
        return romanizedPronunciation;
    }
    
    public String getToneClass() {
        return toneClass;
    }
    
    // Setter methods for new fields
    public void setSymbol(String symbol) {
        this.symbol = symbol;
        updateFront();
    }
    
    public void setThaiReading(String thaiReading) {
        this.thaiReading = thaiReading;
        updateFront();
    }
    
    public void setRomanizedPronunciation(String romanizedPronunciation) {
        this.romanizedPronunciation = romanizedPronunciation;
        updateBack();
    }
    
    public void setToneClass(String toneClass) {
        this.toneClass = toneClass;
        updateBack();
    }
    
    // Helper methods to update front and back when individual fields change
    private void updateFront() {
        setFront(symbol + " " + thaiReading);
    }
    
    private void updateBack() {
        setBack("Romanized English pronunciation (" + romanizedPronunciation + 
                ") Tone class (" + toneClass + ")");
    }
    // Method to display the card (for console testing)
    public void showCard() {
        JFrame frame = new JFrame("Thai Consonant Flashcard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        
    }
}
