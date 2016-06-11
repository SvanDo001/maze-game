package maze.runner;

import java.awt.*;
/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public abstract class GameObject {
    
    public int tileX;
    public int tileY;
    
    private boolean active;
    
    public abstract Image getGameObject();
    
    public int getTileX() {
        return tileX;
    }
    
    public int getTileY() {
        return tileY;
    }
    
    public void active() {
        active = true;
    }
    
    public void inactive() {
        active = false;
    }
    
    public void setGameObjectPosition(int x, int y) {
        tileX = x;
        tileY = y;
    }
}
