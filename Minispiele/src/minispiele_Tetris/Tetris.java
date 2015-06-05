/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable, KeyListener {

    private TBaustein block = new TBaustein(-1);
    private int LINKS_BEWEGUNG, RECHTS_BEWEGUNG;
    private boolean links, rechts;
    private final int GRENZE_UNTEN = 600, GRENZE_RECHTS = 360, GRENZE_LINKS = 30;

    public Tetris() {
        //Initialisiert die einzelnen Komponenten
        LINKS_BEWEGUNG = KeyEvent.VK_LEFT;
        RECHTS_BEWEGUNG = KeyEvent.VK_RIGHT;
        links = false;
        rechts = false;
        
        
        //Erstellt die GUI
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        

    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        block.paintComponent(gr);

    }

    @Override
    public void run() {
        while(true){
        
            
            
            
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == LINKS_BEWEGUNG){
            if(block.getX()!=GRENZE_LINKS){
            block.moveBlockLeft();
            
            }
        
        }
        if(e.getKeyCode() == RECHTS_BEWEGUNG){
            if(block.getX()!=GRENZE_RECHTS){
            block.moveBlockRight();
            
            }
        
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
