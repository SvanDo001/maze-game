package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Bazooka extends GameObject {
    
        private final Image BAZOOKA;
    
    public Bazooka() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/bazooka.png"));
        BAZOOKA = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return BAZOOKA;
    }
    
    public void shoot() {
        
    } 
}