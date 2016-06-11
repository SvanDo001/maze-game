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
    private Image helperRoute;

    public Helper() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/helper.png"));
        helper = img.getImage();
<<<<<<< HEAD
=======
        
>>>>>>> 4cb8e82917794890f98db688112dfa812f9a309e
        img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/routeTile.png"));
        helperRoute = img.getImage();
    }

    @Override
    public Image getGameObject() {
        return helper;
    }
    
<<<<<<< HEAD
    public Image getOptimalRoute() {
=======
    public Image getOptimaleRoute() {
>>>>>>> 4cb8e82917794890f98db688112dfa812f9a309e
        return helperRoute;
    }
}
