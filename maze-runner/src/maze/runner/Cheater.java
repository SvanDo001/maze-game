package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
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

    public void throwBackPlayer(Player player) {
        int random = ((int) (Math.random() * 10) + 5);
        JOptionPane.showMessageDialog(null, "Whahaha, I will knock you "
                + "back " + random + " steps!");
        
        // println's voor debugging
        System.out.println("# random steps: " + random); 
        System.out.println("");
        
        int ArraySizeTileX = player.getStepCounterTileX().size() - 1;
        int ArraySizeTileY = player.getStepCounterTileY().size() - 1;
        
        System.out.println(player.getStepCounterTileX());
        System.out.println(player.getStepCounterTileY());
        System.out.println("");
        
        System.out.println("ArraySizeTileX " + ArraySizeTileX);
        System.out.println("ArraySizeTileY " + ArraySizeTileY);
        System.out.println("");
        
        int throwBackPositionX = player.getStepCounterTileX().get(ArraySizeTileX - random);
        int throwBackPositionY = player.getStepCounterTileY().get(ArraySizeTileY - random);
        
        System.out.println("throwBackPositionX " + throwBackPositionX);
        System.out.println("throwBackPositionY " + throwBackPositionY);
        
        player.moveTo(throwBackPositionX, throwBackPositionY);
    }
}