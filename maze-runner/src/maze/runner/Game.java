package maze.runner;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public class Game
{
    private ArrayList <Level> starts; // Verschillende collecties mogelijk
    
    // default constructor
    public Game()
    {
        starts = new ArrayList <>();
    }
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.start();
    }
    
    public void newMaze(Level maze)
    {
        starts.add(maze);
    }
    
    public void removeMaze(Level maze)
    {
        starts.remove(maze);
    }
    
    public void start()
    {
        final int FRAME_WIDTH = 464;
        final int FRAME_HEIGHT = 495;
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Maze Runner");
        frame.add(new Level());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        
    }
}
