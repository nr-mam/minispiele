
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class KI extends Spieler {

    private final int HOEHE_SPIELER, BREITE_SPIELER;
    private int x, y, schwierigkeit;
    private final Color color;

    public KI(int x, Color color, int schwierigkeit) {
        super(x, color);
        this.x = x;
        HOEHE_SPIELER = 150;
        BREITE_SPIELER = 20;
        y = 150;
        

        this.schwierigkeit = schwierigkeit;
        this.color = color;

    }

    private void moveUp() {
        Random r = new Random();
        int gewichtung = 0;
        gewichtung = r.nextInt(schwierigkeit);
        y += 7 - gewichtung;
    }

    private void moveDown() {
        Random r = new Random();
        int gewichtung = 0;
        gewichtung = r.nextInt(schwierigkeit);
        y -= 7 - gewichtung;
    }

    public void move(Ball ball) {

        if (ball.getyGeschw() > 0) {
            moveUp();
            if (y >= PingPong.HEIGHT_FIELD - HOEHE_SPIELER) {
                y = PingPong.HEIGHT_FIELD - HOEHE_SPIELER;
            }
        } else {
            moveDown();
            if (y <= 0) {
                y = 0;
            }
        }

    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.setColor(color);
        gr.fillRect(x, y, BREITE_SPIELER, HOEHE_SPIELER);
    }

    public int getHOEHE() {
        return HOEHE_SPIELER;
    }

    public int getBREITE() {
        return BREITE_SPIELER;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
