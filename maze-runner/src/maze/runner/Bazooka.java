package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Bazooka extends GameObject {

    private final Image BAZOOKA;

    public Bazooka() {
        active = false;
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/bazooka.png"));
        BAZOOKA = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return BAZOOKA;
    }

    public void destroyWall(Level level, Player player, Map map) {
        int currentTileX = player.getTileX();
        int currentTileY = player.getTileY();

        if (level.getLastDirection().equalsIgnoreCase("UP")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(currentTileX, currentTileY - 1).equals("w")) {
                    currentTileY--;
                } else {
                    check = false;
                    level.setBreakX_Y(currentTileX, currentTileY - 1);
                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("DOWN")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(currentTileX, currentTileY + 1).equals("w")) {
                    currentTileY++;
                } else {
                    check = false;
                    level.setBreakX_Y(currentTileX, currentTileY + 1);
                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("LEFT")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(currentTileX - 1, currentTileY).equals("w")) {
                    currentTileX--;
                } else {
                    check = false;
                    level.setBreakX_Y(currentTileX - 1, currentTileY);
                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("RIGHT")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(currentTileX + 1, currentTileY).equals("w")) {
                    currentTileX++;
                } else {
                    check = false;
                    level.setBreakX_Y(currentTileX + 1, currentTileY);
                }
            }
        }
    }
}
