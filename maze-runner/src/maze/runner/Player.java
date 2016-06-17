package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan & Kenny
 */
public class Player extends GameObject implements Moveable {

    public ArrayList<Integer> historyTileX;
    public ArrayList<Integer> historyTileY;

    private Image PLAYER_TILE;
    private boolean bazookaPickup;

    public Player() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/player.png"));
        PLAYER_TILE = img.getImage();

        historyTileX = new ArrayList<>();
        historyTileY = new ArrayList<>();

        //Starting player position in position-tracking array
        historyTileX.add(1);
        historyTileY.add(1);

        //Starting player position in-game
        tileX = 1;
        tileY = 1;
                
        bazookaPickup = false;
    }

    public void setBazookaPickup() {
        if (bazookaPickup == false) {
            bazookaPickup = true;
            ImageIcon img = new ImageIcon(ClassLoader.
                    getSystemResource("resources/tiles/playerBazooka.png"));
            PLAYER_TILE = img.getImage();
        } else if (bazookaPickup == true) {
            bazookaPickup = false;
            ImageIcon img = new ImageIcon(ClassLoader.
                    getSystemResource("resources/tiles/player.png"));
            PLAYER_TILE = img.getImage();
        }
    }
    
    public void destroyWall(Board level, Player player, MapLoader map) {
        try {
            int x = player.getTileX();
            int y = player.getTileY();

            if (level.getLastDirection().equalsIgnoreCase("UP")) {
                boolean check = true;
                while (check == true) {
                    if (map.getObject(x, y - 1) instanceof Wall == false) {
                        y--;
                    } else {
                            map.replaceObject(x, y - 1, "grass");
                        check = false;
                    }
                }
            }

            if (level.getLastDirection().equalsIgnoreCase("DOWN")) {
                boolean check = true;
                while (check == true) {
                    if (map.getObject(x, y + 1) instanceof Wall == false) {
                        y++;
                    } else {
                        map.replaceObject(x, y + 1, "grass");
                        check = false;
                    }
                }
            }

            if (level.getLastDirection().equalsIgnoreCase("LEFT")) {
                boolean check = true;
                while (check == true) {
                    if (map.getObject(x - 1, y) instanceof Wall == false) {
                        x--;
                    } else {
                        map.replaceObject(x - 1, y, "grass");
                        check = false;
                    }
                }
            }

            if (level.getLastDirection().equalsIgnoreCase("RIGHT")) {
                boolean check = true;
                while (check == true) {
                    if (map.getObject(x + 1, y) instanceof Wall == false) {
                        x++;
                    } else {
                        map.replaceObject(x + 1, y, "grass");
                        check = false;
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
        }
    }

    public boolean getBazookaPickup() {
        return bazookaPickup;
    }

    @Override
    public Image getGameObject() {
        return PLAYER_TILE;
    }

    @Override
    public void move(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }

    @Override
    public void moveTo(int dx, int dy) {
        tileX = dx;
        tileY = dy;
    }

    @Override
    public ArrayList<Integer> getStepCounterTileX() {
        return historyTileX;
    }

    @Override
    public void setStepCounterTileXY() {
        if (historyTileX.get(historyTileX.size() - 1) != tileX || historyTileY.
                get(historyTileY.size() - 1) != tileY){
        historyTileX.add(tileX);
        historyTileY.add(tileY);
        }
    }

    @Override
    public ArrayList<Integer> getStepCounterTileY() {
        return historyTileY;
    }
}
