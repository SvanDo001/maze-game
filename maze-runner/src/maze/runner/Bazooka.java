package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 * Handles the bazooka objects
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Bazooka extends GameObject {

    private final Image BAZOOKA_TILE;

    public Bazooka() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/bazooka.png"));
        BAZOOKA_TILE = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return BAZOOKA_TILE;
    }
}
