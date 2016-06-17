package maze.runner;

import java.util.*;
import javax.swing.*;

/**
 * Handles the menu actions. Initiates the first maze. Starts a new maze,
 * restarts the current maze, shows the manual and the about messages.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Game extends GameFrame {

    private JFrame frame;
    private JPanel panel;
    private Board board;

    // default constructor
    public Game() {
        frame = new GameFrame(this);
        panel = new JPanel();
    }

    /*
     * Initiates the first maze on the board when the application is started.
     */
    public void game() {
        board = new Board();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(board);
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Maze Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        board.grabFocus();
    }

    // starts a new mazefile.
    public void start() {
        board.newMaze();
    }

    // restarts the current mazefile.
    public void restart() {
        board.resetMaze();
    }

    // shows a message with information about the game.
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

    // show a message with information about the creators of the game.
    public void about() {
        JOptionPane.showMessageDialog(null, "A game by Kenny Dillewaard & "
                + "Stefan van Doodewaard");

    }
}