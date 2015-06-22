/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
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
    private Image ImgGameOver;
    private int width, height;
    public int tail = 2;
    private SnakeKopf head = new SnakeKopf(tail, this);
    private Futter eat = new Futter();
    public boolean gameover1 = false;
    //public Tail first;
    public LinkedList<Tail> taillist = new LinkedList<>();
    public int score = 0;
    //public int number = 1;
    public ArrayList<SnakeTail> taillistarray = new ArrayList<>();
    public int snakeColor;//1 = rot; 2 = blau; 3 = lila
    public int eatColor; //1 = blau; 2 = gelb; 3 = lila

    public void setvStart(int vStart) {
        this.vStart = vStart;
    }

    public void setEatColor(int eatColor) {
        this.eatColor = eatColor;
    }

    public void setSnakeColor(int snakeColor) {
        this.snakeColor = snakeColor;
    }

    //TODO
    public Snake() {
        try {
            ImgGameOver = ImageIO.read(this.getClass().getResource("..\\images\\Snake\\GameOver.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            imgField = ImageIO.read(this.getClass().getResource("..\\images\\Snake\\SnakeSpielfeld.jpg"));

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
        if(head.getGameover() == true){
            gr.drawImage(ImgGameOver, FRAME_WIDTH/2-250, FRAME_HEIGHT/2-75, this);
        }
        Font f = new Font("Score", Font.ITALIC, 12);
        gr.setFont(new Font("Score", Font.ITALIC, 12));
        gr.drawString("Score: " + (score * 100), 10, 10);

        //first.paintComponent(gr);
    }

    @Override
    public void run() {
        //int i = 1;
        taillistarray.clear();

        setGameover(false);
        int speed = vStart;
        head.setRIGHT(true);
        //SnakeTail first = new SnakeTail(head.getxCoordinate(), head.getyCoordinate());
        //taillistarray.add(0, first);
        int x = 0;
        int y = 0;

        while (true) {

            speed = vStart;
            head.collision();
            if (head.getGameover() == false) {
                if (head.isRIGHT()) {
                    head.setMovingDirection(2);

                }
                if (head.isDOWN()) {
                    head.setMovingDirection(3);

                }
                if (head.isLEFT()) {
                    head.setMovingDirection(4);

                }
                if (head.isUP()) {
                    head.setMovingDirection(1);

                }
                head.moveHead();

                if (head.getxPixel() == eat.getxCoordinate() && head.getyPixel() == eat.getyCoordinate()) {
                    tail += 5;
                    score();
                    head.setTaillengt(tail);

                }
                

            }

            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
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
