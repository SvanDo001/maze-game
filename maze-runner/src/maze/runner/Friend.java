package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kenny Dillewaard & Stefan van Doodewaard
 */

public class Friend extends GameObject {
    
    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Image friend;

    public Friend() {
        ImageIcon img = new ImageIcon(classloader.
                getSystemResource("resources/tiles/friend.png"));
        friend = img.getImage();
    }

    public Image getGameObject() {
        return friend;
    }
}
