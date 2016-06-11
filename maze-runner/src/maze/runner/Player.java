package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan & Kenny
 */
public class Player extends GameObject implements Moveable {

    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private ArrayList<Integer> historyTileX;
    private ArrayList<Integer> historyTileY;

    private Image player;

    public Player() {
        ImageIcon img = new ImageIcon(classloader.
                getSystemResource("resources/tiles/player.png"));
        player = img.getImage();

        historyTileX = new ArrayList<>();
        historyTileY = new ArrayList<>();
        
        //toevoegen van startpositie X & Y
        historyTileX.add(1);
        historyTileY.add(1);

        tileX = 1;
        tileY = 1;
    }

    public Image getPlayer() {
        return player;
    }

    @Override
    public void move(int dx, int dy, boolean throwBack) {
        if (throwBack == false) {
            tileX += dx;
            tileY += dy;
        }
        if (throwBack == true) {
            
        }
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
        System.out.println("X : " + historyTileX.toString());
    }

    @Override
    public ArrayList<Integer> getStepCounterTileY() {
        return historyTileY;
    }

    @Override
    public void setStepCounterTileY() {
        historyTileY.add(tileY);
        System.out.println("Y : " + historyTileY.toString());
    }

}
