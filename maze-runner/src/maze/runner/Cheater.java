package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 * Handles the cheater objects and randomly throws the player back to an earlier
 * position when the cheater is met.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Cheater extends GameObject {

    private final Image CHEATER_TILE;

    public Cheater() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/cheater.png"));
        CHEATER_TILE = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return CHEATER_TILE;
    }

    /**
     * Random throws back the player when an interaction occurs between player
     * and cheater.
     * 
     * @param player variable of object Player which passes an player object
     * to be used in the method.
     */
    public void throwBackPlayer(Player player) {
        int random = ((int) (Math.random() * 10) + 5);
        JOptionPane.showMessageDialog(null, "Whahaha, I will knock you "
                + "back " + random + " steps!");
                
        int ArraySizeTileX = player.getStepCounterTileX().size() - 1;
        int ArraySizeTileY = player.getStepCounterTileY().size() - 1;
        
        int throwBackPositionX = player.getStepCounterTileX().get(ArraySizeTileX - random);
        int throwBackPositionY = player.getStepCounterTileY().get(ArraySizeTileY - random);
        
        player.moveTo(throwBackPositionX, throwBackPositionY);
    }
}