package maze.runner;

import java.awt.*;

/**
 * Handles the superclass of game objects.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public abstract class GameObject {

    public int tileX;
    public int tileY;

    // abstract methode return each GameObject.
    public abstract Image getGameObject();

    // returns the current tile at the x coordinate
    public int getTileX() {
        return tileX;
    }

    // returns the current tile at the y coordinate
    public int getTileY() {
        return tileY;
    }
}