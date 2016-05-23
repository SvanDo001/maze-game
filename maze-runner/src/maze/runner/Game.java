package maze.runner;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Game extends ClickListener
{    
    private ArrayList <Level> starts; // Verschillende collecties mogelijk
    final int FRAME_WIDTH = 464;
    final int FRAME_HEIGHT = 495;
    
    JButton start = new JButton("Start");
    JButton restart = new JButton("Restart");
    JButton quit = new JButton("Quit");
    
    JFrame frame = new JFrame();
    
    // default constructor
    public Game()
    {        
        starts = new ArrayList <>();
    }
    
    // Starts new game and call's the exiting start method
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.menu();
    }
    
    // Add's a new Level to the Array of maze Levels
    public void newMaze(Level maze)
    {
        starts.add(maze);
    }
    
    // Removes a existing Level to the Array of maze Levels
    public void removeMaze(Level maze)
    {
        starts.remove(maze);
    }
    
    public void menu()
    {
        JFrame frame = new JFrame();
             
        JButton start = new JButton("Start");
        JButton restart = new JButton("Restart");
        JButton quit = new JButton("Quit");
        
        start.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Game game = new Game();
            game.start();
            
        }
        });
        
        restart.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Game game = new Game();
            game.restart();
        }
        });
        
        quit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Game game = new Game();
            game.quit();
        }
        });
        
        JPanel panelMenu = new JPanel();
        panelMenu.add(start, BorderLayout.PAGE_END);
        panelMenu.add(restart, BorderLayout.PAGE_END);
        panelMenu.add(quit, BorderLayout.PAGE_END);
        frame.add(panelMenu, BorderLayout.PAGE_START);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
    
    
    // Initiates a new Jframe 
    public void start()
    {
        frame.add(new Level());
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
    
    public void restart()
    {
        
    }
    
    public void quit()
    {
        ActionListener listener2 = new ClickListener();
        quit.addActionListener(listener2);
        
        System.exit(0);
    }
}
