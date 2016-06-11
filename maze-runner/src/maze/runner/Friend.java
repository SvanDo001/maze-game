package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kenny Dillewaard & Stefan van Doodewaard
 */

public class Friend extends GameObject {

    private final Image friend;

    public Friend() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/friend.png"));
        friend = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return friend;
    }
}
