/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable {

    private TBaustein block = new TBaustein(1);

    public Tetris() {
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
           //block.blockZeichnen();
        }
    }

}
