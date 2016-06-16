package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kenny Dillewaard & Stefan van Doodewaard
 */
public class Friend extends GameObject {

    private Image FRIEND_TILE;

    public Friend() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/friend.png"));
        FRIEND_TILE = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return FRIEND_TILE;
    }

    public void meetFriend(Player player) {
        int steps = player.historyTileX.size() - 1;
        JOptionPane.showMessageDialog(null, "Congratulations, you have "
                + "reached your friend! " + "\n    You have completed the maze "
                + "in " + steps + " steps.");
    }
}
