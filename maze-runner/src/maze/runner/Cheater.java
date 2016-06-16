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

        int ArraySizeTileX = player.getStepCounterTileX().size() - 1;
        int ArraySizeTileY = player.getStepCounterTileY().size() - 1;

        int throwBackPositionX = player.getStepCounterTileX().
                get(ArraySizeTileX - random);
        int throwBackPositionY = player.getStepCounterTileY().
                get(ArraySizeTileY - random);

        // Kan dit niet netter?
        setGameObjectPosition(-1, -1);
        player.moveTo(throwBackPositionX, throwBackPositionY);
    }
}