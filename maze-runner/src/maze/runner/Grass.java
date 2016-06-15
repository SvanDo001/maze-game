package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Grass extends GameObject {

    private final Image GRASS_TILE;

    public Grass() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/grassTile.png"));
        GRASS_TILE = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return GRASS_TILE;
    }

}
