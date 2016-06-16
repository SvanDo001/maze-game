package maze.runner;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Game extends GameFrame {

    private ArrayList<Level> levels; // Verschillende collecties mogelijk
    private JFrame frame;
    private JPanel panel;
    private Level currentLevel;

    // default constructor
    public Game() {
        levels = new ArrayList<>();
        frame = new GameFrame(this);
        panel = new JPanel();
    }

    public void game() {
        currentLevel = new Level();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(currentLevel);
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        currentLevel.grabFocus();
    }

    public void start() {
        panel.remove(currentLevel);
        currentLevel = new Level();
        panel.add(currentLevel);
        frame.add(panel);
        frame.setVisible(true);
        currentLevel.grabFocus();
    }

    public void restart() {
        panel.remove(currentLevel);
        currentLevel.resetGameAttributes();
        panel.add(currentLevel);
        frame.add(panel);
        frame.setVisible(true);
        currentLevel.grabFocus();
    }

    public void manual() {
        JOptionPane.showMessageDialog(null,
                "In order to finish the maze, navigate the player towards "
                + "the \nfriend. Avoid the cheater for he will send "
                + "you back a random \namount of steps. You can also "
                + "use the bazooka to destroy a \nwall in the "
                + "direction you last moved or have the helper show "
                + "\n you the optimal route.\n\nControls:\n- Arrow "
                + "keys to move\n- Space bar to shoot bazooka", 
                "Manual", JOptionPane.INFORMATION_MESSAGE);
    }

    public void about() {
        JOptionPane.showMessageDialog(null, "A game by Kenny Dillewaard & "
                + "Stefan van Doodewaard");

    }
}