package maze.runner;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Level extends JPanel implements ActionListener
{   
    private Timer timer;
    
    private Map map;
    private Player player;
    
    public Level()
    {
        map = new Map();
        player = new Player();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for (int y = 0; y < 14; y++)
        {
            for (int x = 0; x < 14; x++)
            {
                if (map.getMap(x, y).equals("g"))
                {
                    g.drawImage(map.getGrass(), x * 32, y * 32, null);
                }
                if (map.getMap(x, y).equals("w"))
                {
                    g.drawImage(map.getWall(), x * 32, y * 32, null);
                }
            }
        }
        
        g.drawImage(player.getPlayer(), player.getX(), player.getY(), null);
    }
    
    public class Al extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)
        {
            int keycode = event.getKeyCode();
            
            if(keycode == KeyEvent.VK_UP)
            {
                player.move(0, -32, 0, -1);
            }
            if(keycode == KeyEvent.VK_DOWN)
            {
                player.move(0, 32, 0, 1);
            }
            if(keycode == KeyEvent.VK_LEFT)
            {
                player.move(-32, 0, -1, 0);
            }
            if(keycode == KeyEvent.VK_RIGHT)
            {
                player.move(32, 0, 32, 0);
            }
        }
        
        public void keyReleased(KeyEvent event)
        {
            
        }
        
        public void keyTyped (KeyEvent event)
        {
            
        }
    }
}
