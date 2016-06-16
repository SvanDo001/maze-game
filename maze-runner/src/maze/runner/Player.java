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

        //toevoegen van startpositie X & Y
        historyTileX.add(1);
        historyTileY.add(1);

        tileX = 1;
        tileY = 1;

        bazookaPickup = false;
    }

    @Override
    public Image getGameObject() {
        return PLAYER_TILE;
    }

    public void setBazookaPickup() {
        if (bazookaPickup == false) {
            bazookaPickup = true;
            ImageIcon img = new ImageIcon(ClassLoader.
                    getSystemResource("resources/tiles/player.png"));
            PLAYER_TILE = img.getImage();
        }
        if (bazookaPickup == true) {
            ImageIcon img = new ImageIcon(ClassLoader.
                    getSystemResource("resources/tiles/playerBazooka.png"));
            PLAYER_TILE = img.getImage();
        }
    }

    public boolean getBazookaPickup() {
        return bazookaPickup;
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
    public void setStepCounterTileX() {
        historyTileX.add(tileX);
    }

    @Override
    public ArrayList<Integer> getStepCounterTileY() {
        return historyTileY;
    }

    @Override
    public void setStepCounterTileY() {
        historyTileY.add(tileY);
    }
}