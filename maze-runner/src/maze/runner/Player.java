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
 
    private Image player;
    private Image playerBazooka;

    public Player() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/player.png"));
        player = img.getImage();
        img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/playerBazooka.png"));
        playerBazooka = img.getImage();

        historyTileX = new ArrayList<>();
        historyTileY = new ArrayList<>();
        
        //toevoegen van startpositie X & Y
        historyTileX.add(1);
        historyTileY.add(1);

        tileX = 1;
        tileY = 1;
    }

    @Override
    public Image getGameObject() {
        return player;
    }
    
    public Image getBazooka() {
        return playerBazooka;
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
