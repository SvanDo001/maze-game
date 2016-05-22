package maze.runner;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Stefan
 */
public class Player
{
    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    
    private int x;
    private int y;
    private int tileX;
    private int tileY;
    
    private Image player;
    
    public Player()
    {
        // ImageIcon img = new ImageIcon("C://Users//Stefan//Documents//Sourcetree//maze-runner//Tiles//player.png");
        ImageIcon img = new ImageIcon(classloader.getSystemResource("resources/tiles/player.png"));
        player = img.getImage();
        
        x = 32;
        y = 32;
        
        tileX = 1;
        tileY = 1;
                
    }
    
    public Image getPlayer()
    {
        return player;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getTileX()
    {
        return tileX;
    }
        
    public int getTileY()
    {
        return tileY;
    }
    
    public void move(int dx, int dy, int tx, int ty)
    {
        x += dx;
        y += dy;
        
        tileX += tx;
        tileY += ty;
    }
}
