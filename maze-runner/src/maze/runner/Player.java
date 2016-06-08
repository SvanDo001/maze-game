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
                getSystemResource("resources/tiles/cpt_america.png"));
        player = img.getImage();

        historyTileX = new ArrayList<>();
        historyTileY = new ArrayList<>();
        
        tileX = 1;
        tileY = 1;
    }

    public Image getPlayer() {
        return player;
    }

    public void move(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }

    public void stepCounter() {
        historyTileX.add(tileX);
        historyTileY.add(tileY);
        int a = historyTileX.size() - 1;
        int b = historyTileY.size() - 1;
        System.out.println(historyTileX.get(a) + " "
                + " " + historyTileY.get(b));
    }
    
    public void getPreviousPositionTileX(int steps, String access) {
        int previousPositionX = historyTileX.size() - 1;
        
        previousPositionX = previousPositionX - steps;
        
        historyTileX.get(previousPositionX);       
    }
    
    public void getPreviousPositionTileY(int steps) {
        int previousPositionY = historyTileY.size() - 1;
        
        previousPositionY = previousPositionY - steps;
        
        historyTileY.get(previousPositionY);    
    }
}