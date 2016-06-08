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
    private Level currentLevel;

    // default constructor
    public Game() {
        levels = new ArrayList<>();
        frame = new GameFrame(this);
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
        currentLevel = new Level();
        frame.add(currentLevel);
        frame.setVisible(true);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        currentLevel.grabFocus();
        addLevel(currentLevel);
    }

    public void start() {
        frame.remove(currentLevel);
        currentLevel = new Level();
        frame.add(currentLevel);
        frame.setVisible(true);
        currentLevel.grabFocus();
        addLevel(currentLevel);
    }

    public void restart() {
        frame.remove(currentLevel);
        currentLevel = this.levels.get(levels.size() - 1);
        frame.add(currentLevel);
        frame.setVisible(true);
        currentLevel.grabFocus();        
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