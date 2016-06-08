package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Enemy extends GameObject {

    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Image enemy;

    public Enemy() {
        ImageIcon img = new ImageIcon(classloader.
                getSystemResource("resources/tiles/enemy.png"));
        enemy = img.getImage();
    }

    public Image getEnemy() {
        return enemy;
    }

    public void throwBackPlayer(int steps, String pos) {

        if (pos.equals("x")) {
            int previousPositionX = historyTileX.size() - 1;

            previousPositionX = previousPositionX - steps;

            int position = historyTileX.get(previousPositionX);
        }
        if (pos.equals("y")) {
            int previousPositionY = historyTileY.size() - 1;

            previousPositionY = previousPositionY - steps;

            int position = historyTileY.get(previousPositionY);
        }

    }
    //throwBackPlayer(12, "x");
    //throwBackPlayer(12, "y");
}
