package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *  Handles the player object. Replaces the player image with an bazooka image
 *  if a bazooka is picked up. Also if the player is firing an bazooka the
 *  destroy wall method is executed.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Player extends GameObject implements Moveable {

    private ArrayList<Integer> historyTileX;
    private ArrayList<Integer> historyTileY;

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

    /**
     * 
     * Replaces the player image with an player bazooka image when a player
     * picks up a bazooka.
     */
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
    
    /**
     * When the player fires a bazooka the destroyWall() method is executed. It
     * replaces the bazooka that is picked up with and grass tile and destorys
     * the first wall in the last direction the player is facing.
     * 
     * @param level object type of Level from the Level class
     * @param player object type of Player from the Player class
     * @param map object type of Map from the Map class
     */
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

    // returns a boolean and checks if a player carries a bazooka
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
