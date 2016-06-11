package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Cheater extends GameObject {

    private Image cheater;

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
    
    @Override
    public void setGameObjectPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
}
