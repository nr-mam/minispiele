/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.TextField;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class Punktezaehler {

    private Ball ball;
    private JTextField tf;
    private int zaehler1, zaehler2, seite, maxPunkte;
    private Einstellungen einst;

    /**
     * Erstellt einen Punktezähler der jeden Kontakt mit dem Ball mitzählt.
     * Dieser Punktezähler ist ein sehr schmales Rechteck an dem jeweiligen Rand
     * des Spielfeldes.
     *
     * @param tf anzeigefeld der aktuellen Punkte
     * @param ball der Spielball
     * @param seite die Seite auf der dieser Punktezähler erstellt werden soll
     */
    public Punktezaehler(JTextField tf, Ball ball, int seite) {
        this.ball = ball;
        this.tf = tf;
        this.seite = seite;
        maxPunkte = Einstellungen.maxPunkte;
        zaehler1 = 0;
        zaehler2 = 0;
    }

    /**
     * vergleicht die Punkte mit der angegebenen maximalen Punktzahl welche in
     * den Einstellungen festgelegt wurde
     *
     * @return limit ist erreicht = true, nicht = false
     */
    public boolean maxPunkteVergleichen() {
        if (maxPunkte == zaehler1 || maxPunkte == zaehler2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean kollisionLinksPruefen(Ball ball) {
        Rectangle linkeHitbox = new Rectangle(0, 0, 1, PingPong.HEIGHT_FIELD);
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return linkeHitbox.intersects(ballHitbox);
    }

    public boolean kollisionRechtsPruefen(Ball ball) {
        Rectangle rechteHitbox = new Rectangle(PingPong.WIDTH_FIELD, 0, 1, PingPong.HEIGHT_FIELD);
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return rechteHitbox.intersects(ballHitbox);
    }

    /**
     * Addiert der Anzeigetafel und der Zählvariable den Punkt falls eine
     * Kollision aufgetreten ist.
     * @param tf
     */
    public void addieren(JTextField tf) {
        this.tf = tf;
        if (kollisionLinksPruefen(ball)) {
            if (seite == -1) {
                zaehler1++;
                tf.setText(Integer.toString(zaehler1));

            }
        }
        if (kollisionRechtsPruefen(ball)) {
            if (seite == 1) {
                zaehler2++;
                tf.setText(Integer.toString(zaehler2));

            }
        }

    }

}
