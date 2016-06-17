package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 * Handles the friend objects and shows an message when the end of the mapfile
 * is reached.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
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

    /**
     * Shows an message with the total amount of steps that the player needed to
     * reach the end position of the current map, the friend object. 
     * 
     * @param player variable of object Player which passes an player object
     * to be used in the method.
     */
    public void meetFriend(Player player) {
        int steps = player.getStepCounterTileX().size() - 1;
        JOptionPane.showMessageDialog(null, "Congratulations, you have "
                + "reached your friend! " + "\n    You have completed the maze "
                + "in " + steps + " steps.");
    }
}
