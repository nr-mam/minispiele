/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minispiele_Tetris.Tetris;

/**
 *
 * @author nmamerow
 */
public class Snake extends JPanel implements Runnable, KeyListener {

    public final static int FRAME_WIDTH = 1200, FRAME_HEIGHT = 700;
    public final static int WIDTH_FIELD = 1180, HEIGHT_FIELD = 680;
    public int vStart = 100; // Geschwindigkeit
    private Image imgField;
    private int width, height;
    private SnakeKopf head = new SnakeKopf();
    private Futter eat = new Futter();
    private int tempo;
    private boolean left, right, up, down;
    public boolean gameover1 = false;
    public Tail first;
    public LinkedList<Tail> taillist = new LinkedList<>();
    public int score = 0;
    public ArrayList<SnakeTail> taillistarray = new ArrayList<>();

    //TODO
    public Snake() {

        try {
            imgField = ImageIO.read(this.getClass().getResource("..\\images\\SnakeSpielfeld.png"));

        } catch (IOException ex) {
            Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
        }
        width = imgField.getWidth(this);
        height = imgField.getHeight(this);
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(width + 6, height + 26));
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        frame.setResizable(false);
        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);
        new Thread(this).start();

    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(imgField, 0, 0, this);
        head.paintComponent(gr);
        eat.paintComponent(gr);
        if (taillistarray.size() > 1) {
            for (int i = 0; i < taillistarray.size(); i++) {
                taillistarray.get(i).paintComponent(gr);

            }
        }

        //first.paintComponent(gr);
    }

    @Override
    public void run() {
        int i = 1;
        taillistarray.clear();

        setGameover(false);
        int speed = vStart;
        head.setRIGHT(true);
        SnakeTail first = new SnakeTail(head.getxCoordinate(), head.getyCoordinate());
        taillistarray.add(0, first);
        int x = 0;
        int y = 0;

        while (true) {

            //first = new Tail(head.getxCoordinate(), head.getyCoordinate());
            speed = vStart;
            if (head.isRIGHT()) {
                head.moveHeadRight();
            }
            if (head.isDOWN()) {
                head.moveHeadDown();
            }
            if (head.isLEFT()) {
                head.moveHeadLeft();
            }
            if (head.isUP()) {
                head.moveHeadUp();
            }
            first.setxCoordinate(head.xCoordinate);
            first.setyCoordinate(head.yCoordinate);
            update();
            if (head.getxCoordinate() == eat.getxCoordinate() && head.getyCoordinate() == eat.getyCoordinate()) {
                score();
                //first.add();
                taillistarray.add(i, new SnakeTail(x, y));
                update();

            }

            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (gameover1 == true) {
                break;
            }
            if (taillistarray.size() < 1) {
                x = head.getxCoordinate();
                y = head.getyCoordinate();
            } else {
                x = taillistarray.get(taillistarray.size() - 1).getxCoordinate();
                y = taillistarray.get(taillistarray.size() - 1).getyCoordinate();
            }
            update();
            
            repaint();

            //first.update(first.getxCoordinate(), first.getyCoordinate());
        }

    }

    public void setGameover(boolean gameover) {
        gameover1 = gameover;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        head.move(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        head.move(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void score() {
        score++;
        eat.position();

    }

    public void update() {
        //first.update(first.getxCoordinate(), first.getyCoordinate());
        if (taillistarray.size() > 0) {
            for (int i = 1; i < taillistarray.size(); i++) {
                taillistarray.set(taillistarray.size() - (i), taillistarray.get(taillistarray.size() - (1 + i)));

            }
        }

    }

}
