package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Game extends GameFrame {

    private final ArrayList<Level> levels; // Verschillende collecties mogelijk
    private JFrame frame;

    // default constructor
    public Game() {
        levels = new ArrayList<>();
        frame = new GameFrame();
    }
    
    // Add's a new Level to the Array of maze Levels
    public void addLevel(Level level) {
        levels.add(level);
    }

    // Removes a existing Level to the Array of maze Levels
    public void removeLevel(Level level) {
        levels.remove(level);
    }

    public void game() {
        frame.add(new Level());
        frame.setVisible(true);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        addLevel(new Level());
    }

    // Initiates a new Jframe 
    public void start() {
        frame.add(new Level());
        frame.setVisible(true);
        frame.setTitle("Maze Runner");
        frame.setLocationRelativeTo(null);
        addLevel(new Level());
    }

    public void restart() {
    }
    
    public void about() {
        JFrame frame = new GameFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("A game by Kenny Dillewaard & Stefan van Doodewaard");
        frame.setVisible(true);
        panel.add(label, BorderLayout.CENTER);
        frame.add(panel);
    }
}