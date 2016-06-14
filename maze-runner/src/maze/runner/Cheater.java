package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Cheater extends GameObject {

    private Image cheater;

    public Cheater() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/cheater.png"));
        cheater = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return cheater;
    }
    
    public void throwBackPlayer(Player player) {
        System.out.println("Cheater Bereikt!");
        int random = ((int) (Math.random() * 10) + 5);
        JOptionPane.showMessageDialog(null, "Whahaha, I will knock you " +
                "back " + random + " steps!");

        int ArraySizeTileX = player.getStepCounterTileX().size() - 1;
        int ArraySizeTileY = player.getStepCounterTileY().size() - 1;

        int throwBackPositionX = player.getStepCounterTileX().get(ArraySizeTileX - random);
        int throwBackPositionY = player.getStepCounterTileY().get(ArraySizeTileY - random);
        
        setGameObjectPosition(-1, -1);
        player.moveTo(throwBackPositionX, throwBackPositionY);
    }
}
