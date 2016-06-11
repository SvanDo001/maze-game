package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Cheater extends GameObject {

    private final Image cheater;

    public Cheater() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/cheater.png"));
        cheater = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }

    @Override
    public Image getGameObject() {
        return cheater;
    }
    
    public void setCheaterPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
    
    
}
