package org.global.academy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Flashcard extends JPanel {
    private String front;
    private String back;
    private boolean learned;          // true if the card is learned
    private boolean showingFront = true;

    // Constructor
    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
        this.learned = false;

        setPreferredSize(new Dimension(400, 200));
        setFont(new Font("Tahoma", Font.PLAIN, 24));
        setBackground(Color.WHITE);

        // Click to flip
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                showingFront = !showingFront;
                repaint();
            }
        });
    }

    // Getters and setters
    public String getFront()   { return front; }
    public String getBack()    { return back; }
    public boolean isLearned() { return learned; }
    public void setFront(String front)   { this.front = front; }
    public void setBack(String back)     { this.back = back; }
    public void setLearned(boolean b)    { this.learned = b; }

    // Draw the text
    public void showCard(Graphics g) {
        g.setColor(Color.BLACK);
        String text = showingFront ? front : back;
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = (getHeight() / 2) + fm.getAscent() / 2;
        g.drawString(text, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        showCard(g);
    }
}
