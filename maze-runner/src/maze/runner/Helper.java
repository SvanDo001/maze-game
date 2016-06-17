package maze.runner;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Helper extends GameObject {

    private final Image HELPER_TILE;

    public Helper() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/helper.png"));
        HELPER_TILE = img.getImage();

        // Wat is het nut nog om deze variabelen mee te geven?
    }

    @Override
    public Image getGameObject() {
        return HELPER_TILE;
    }
    
    public void meetHelper() {
        JOptionPane.showMessageDialog(null, "Let me help you by showing you the "
                + "optimal route to your friend!");
    }
}