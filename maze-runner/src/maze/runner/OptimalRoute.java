/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ken
 */
public class OptimalRoute extends GameObject {
    
    private Image optimaleRoute;

    public OptimalRoute() {

        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/routeTile.png"));
        optimaleRoute = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return optimaleRoute;
    }
}
