package maze.runner;

import java.awt.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public abstract class GameObject {

    public int tileX;
    public int tileY;
    public boolean active;

    public abstract Image getGameObject();
    
    public void setActive() {
        if (active == false) {
            active = true;
        }
        if (active == true) {
            active = false;
        }
    }
    
    public boolean getActive() {
        return active;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setGameObjectPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
}
