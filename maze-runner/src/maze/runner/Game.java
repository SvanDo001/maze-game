package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Game extends GameFrame {

    private ArrayList<Level> levels; // Verschillende collecties mogelijk
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
        currentLevel.reset();
        frame.add(currentLevel);
        frame.setVisible(true);
        currentLevel.grabFocus();
    }

    public void manual() {
        JOptionPane.showMessageDialog (null, 
                "In order to finish the maze, navigate the player towards the \n" +
                "friend. Avoid the cheater for he will send you back a random \n" +
                "amount of steps. You can also use the bazooka to destroy a \n" +
                "wall in the direction you last moved or have the helper show \n" +
                "you the optimal route.\n\n" +
                "Controls:\n" +
                "- Arrow keys to move\n" +
                "- Space bar to shoot bazooka"
        , "Manual", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void about() {
        JOptionPane.showMessageDialog(null, "A game by Kenny Dillewaard & Stefan van Doodewaard");

    }
}
