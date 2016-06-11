package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Ammo extends GameObject {
    
        private final Image AMMO;
    
    public Ammo() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/ammo.png"));
        AMMO = img.getImage();
    }
    
    @Override
    public Image getGameObject() {
        return AMMO;
    }
    
    public void moveAmmo(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }
}