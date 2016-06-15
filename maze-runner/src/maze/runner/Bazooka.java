package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
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

    public void destroyWall(Level level, Player player, Map map) {
        int x = player.getTileX();
        int y = player.getTileY();

        if (level.getLastDirection().equalsIgnoreCase("UP")) {
            boolean check = true;
            System.out.println("UP");

            while (check == true) {
                if (map.getObject(x, y - 1) instanceof Wall == false) {
                    y--;
                } else {
                    map.replaceObject(x, y, "grass");
                    check = false;
                }
//                if (!map.getObject(currentTileX, currentTileY - 1).equals("w")) {
//                    currentTileY--;
//                } else {
//                    check = false;
//                    level.setBreakX_Y(currentTileX, currentTileY - 1);
//                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("DOWN")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(x, y + 1).equals("w")) {
                    y++;
                } else {
                    check = false;
                    level.setBreakX_Y(x, y + 1);
                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("LEFT")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(x - 1, y).equals("w")) {
                    x--;
                } else {
                    check = false;
                    level.setBreakX_Y(x - 1, y);
                }
            }
        }

        if (level.getLastDirection().equalsIgnoreCase("RIGHT")) {
            boolean check = true;

            while (check == true) {
                if (!map.getObject(x + 1, y).equals("w")) {
                    x++;
                } else {
                    check = false;
                    level.setBreakX_Y(x + 1, y);
                }
            }
        }
    }
}
