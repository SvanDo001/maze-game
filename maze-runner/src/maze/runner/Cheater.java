package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Cheater extends GameObject {

    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Image cheater;

    public Cheater() {
        ImageIcon img = new ImageIcon(classloader.
                getSystemResource("resources/tiles/cheater.png"));
        cheater = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }

    public Image getGameObject() {
        return cheater;
    }
    
    public void setCheaterPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
    
    
}
