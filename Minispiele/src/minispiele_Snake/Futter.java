
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
public final class Futter extends JComponent {

    public int xCoordinate, yCoordinate;
    public Image imgEat;

    public Futter() {
        try {
            imgEat = ImageIO.read(this.getClass().getResource("/images/Snake/SnakeFutter.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Futter.class.getName()).log(Level.SEVERE, null, ex);
        }
        position();
    }

    public void position() {

        xCoordinate = 10 + 10 * (int) ((Math.random()) * (Snake.FRAME_WIDTH_1 / 10 - 10));
        yCoordinate = 10 + 10 * (int) ((Math.random()) * (Snake.FRAME_HEIGHT_1 / 10 - 10));

    }

    public void paintComponent(Graphics gr) {
        gr.drawImage(imgEat, xCoordinate, yCoordinate, this);

    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

}
