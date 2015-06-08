/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Marc
 */
public class TScore extends JComponent {

    private int score, lines;
    private TBaustein baustein1, baustein2;

    public TScore(TBaustein b1, TBaustein b2) {
        score = 0;
        baustein1 = b1;
        baustein2 = b2;
        lines = 0;
    }

    @Override
    public void paintComponent(Graphics gr) {
        
        for (int i = 0; i < baustein1.getBlockForm().length; i++) {
            for (int j = 0; j < baustein1.getBlockForm()[i].length; j++) {
                if (baustein1.getBlockForm()[i][j] == 1) {
                    gr.drawImage(baustein1.img, ((i * 30)+515), ((j * 30)+ 175), this);
                }
            }

        }
        score = 155;
        gr.drawString(Integer.toString(score), 515, 171);

    }
    
    public TBaustein neuerBaustein(){
    TBaustein bausteinNext = baustein1;
    baustein1 = baustein2;
    baustein2 = new TBaustein(-1);
    return bausteinNext;
    }

}
