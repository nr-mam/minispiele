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

    public final static int WIDTH_FRAME = 1500, HEIGHT_FRAME = 700;
    public final static int WIDTH_FIELD = 1480, HEIGHT_FIELD = 680;
    public int vStart = 100; // Geschwindigkeit
    private Image imgField;
    private int width, height;
    private int playingField[][];
    private SnakeKopf head = new SnakeKopf();
    private int tempo;
    private boolean left, right, up, down;
    public boolean gameover = false;
    //TODO

    public Snake() {
        
        try {
            imgField = ImageIO.read(this.getClass().getResource("..\\images\\SnakeSpielfeld.jpg"));

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

    }

    @Override
    public void run() {
        setGameover(false);
        int speed = vStart;
        head.setRIGHT(true);
        while (true) {
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

            repaint();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (gameover == true){
                break;
            }

        }
        
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
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

}
