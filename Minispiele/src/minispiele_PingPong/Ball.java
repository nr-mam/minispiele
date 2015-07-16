
package minispiele_PingPong;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Klasse zur Erstelung des PingPong-Balles welcher sich konstant bewegt und von
 * den Rändern sowie den Spielern Abprallt.
 *
 * @author Richard
 */
public class Ball extends JComponent {

    //Balldurchmesser 50px
    public static Double V = 0.0;
    private static final int bHeight = 50, bWidth = 50;
    private Double xGeschw, yGeschw;//Koordinatenänderung
    private int x, y; //Koordinaten
    private final int schwierigkeit;
    private final Component comp;
    private Image PingPongBall;

    /**
     * Erstellt den Ball an der Stelle P(x/y) und bekommt den Komponenten der
     * PingPong-Klasse übergeben um ihn letztendlich in der paintComponent()
     * Methode zeichnen zu können. Die schwierigkeit legt die geschwindigkeit
     * des Balles fest.
     *
     * @param x
     * @param y
     * @param comp
     * @param schwierigkeit
     */
    public Ball(int x, int y, Component comp, int schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
        this.x = x;
        this.y = y;
        V = (double) schwierigkeit;
        this.xGeschw = V;
        this.yGeschw = V;
        this.comp = comp;
        ladeBall();
    }

    /**
     * Lädt das Bild vom Ball.
     *
     * @return Das Bild vom Ball
     */
    private Image ladeBall() {
        try {
            PingPongBall = ImageIO.read(getClass().getResource("/images/PingPong/PingPongBallGruen.png"));
        } catch (IOException e) {
        }
        return PingPongBall;
    }

    /**
     * Zeichnet den PingPong-Ball.
     *
     * @param gr
     */
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(PingPongBall, x, y, comp);

    }

    /**
     * Bewegt den PingPong-Ball und legt Fest, ab wann dieser abprallen (seine
     * Richtung ändern) soll.
     */
    public void move() {

        if (x + 50 > 1200) {
            xGeschw = -V;
        } else if (x <= 0) {
            xGeschw = V;
        }
        if (y + 50 > 750) {
            yGeschw = -V;
        } else if (y <= 0) {
            yGeschw = V;
        }
        x += xGeschw;
        y += yGeschw;

    }

    public void setxGeschw(double xGeschw) {
        this.xGeschw = xGeschw;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public double getyGeschw() {
        return yGeschw;
    }

}
