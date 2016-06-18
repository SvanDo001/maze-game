package maze.runner;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Handles the OptimalRoute objects.
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard.
 */
public class OptimalRoute extends GameObject {

    private final Image ROUTE_TILE;

    public OptimalRoute() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/routeTile.png"));
        ROUTE_TILE = img.getImage();

    }

    @Override
    public Image getGameObject() {
        return ROUTE_TILE;
    }
}