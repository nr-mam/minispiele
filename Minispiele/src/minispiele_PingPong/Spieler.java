
package minispiele_PingPong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Richard
 */
public class Spieler {

    private final int deltaY, HOEHE, BREITE;
    private final Color color;
    private int y, x;

    public Spieler(int x, Color color) {
        HOEHE = 150;
        BREITE = 20;
        this.color = color;
        this.x = x;
        y = 100;
        this.deltaY = 4;
    }

    public void move(int i) {
        if (i == -1) {
            if (y >= 750 - HOEHE) {
                y = 750 - HOEHE;
            } else {
                y += deltaY;
            }

        }
        if (i == 1) {
            if (y <= 0) {
                y = 0;
            } else {
                y -= deltaY;
            }
        }

    }

    public void paintComponent(Graphics gr) {
        gr.setColor(color);
        gr.fillRect(x, y, BREITE, HOEHE);

    }

    public int getHOEHE() {
        return HOEHE;
    }

    public int getBREITE() {
        return BREITE;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
