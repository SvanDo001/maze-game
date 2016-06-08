package maze.runner;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public abstract class GameObject {
    
    public int tileX;
    public int tileY;
    
    private boolean active;
    
    public int getTileX() {
        return tileX;
    }
    
    public int getTileY() {
        return tileY;
    }
}
