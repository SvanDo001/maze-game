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
 * @author Ken & Stefan
 */
public class OptimalRoute extends GameObject {

    private final Image ROUTE_TILE;

    public OptimalRoute() {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/routeTile.png"));
        ROUTE_TILE = img.getImage();

    }

    @Override
    public Image getGameObject() {
        return ROUTE_TILE;
    }
}