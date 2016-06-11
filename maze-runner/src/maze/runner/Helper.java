/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Helper extends GameObject {

    private Image helper;

    public Helper() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/helper.png"));
        helper = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }

    @Override
    public Image getGameObject() {
        return helper;
    }
    
    @Override
    public void setGameObjectPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
}
