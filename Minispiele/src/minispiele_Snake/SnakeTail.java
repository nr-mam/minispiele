
package minispiele_Snake;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author nmamerow
 */
public class SnakeTail extends JComponent{
    private Image imgTail;
    private int xCoordinate, yCoordinate;
    private SnakeKopf head;
    public int numberOfTails;

    public SnakeTail(int x, int y) {
        try {
            imgTail = ImageIO.read(this.getClass().getResource("/images/Snake/SnakeFragment.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(SnakeTail.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgTail = this.imgTail;
        xCoordinate = x;
        yCoordinate = y;
       
        repaint();
        
        
    }
    

    @Override
    protected void paintComponent(Graphics gr) {
        for (int i = 0; i < numberOfTails; i++) {
            gr.drawImage(imgTail, xCoordinate + i *10, yCoordinate, this);
        }
        gr.drawImage(imgTail, xCoordinate, yCoordinate, this);
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setNumberOfTails(int number) {
        this.numberOfTails = number;
    }
    

   
    
    
    
    
    
}
