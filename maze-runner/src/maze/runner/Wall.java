package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Wall extends GameObject {

    private final Image WALL_TILE;
    
    private boolean active;

    public Wall() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/wallTile.png"));
        WALL_TILE = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return WALL_TILE;
    }
}
