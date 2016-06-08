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
}
