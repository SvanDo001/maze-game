package maze.runner;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class GameFrame extends JFrame {

    private static final int FRAME_WIDTH = 464;
    private static final int FRAME_HEIGHT = 518;
    private Game game = null;

    public GameFrame() {
        // Construct menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createGameMenu());
        menuBar.add(createInfoMenu());

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    public GameFrame(Game game) {
        this();
        this.game = game;
    }

    class ExitItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    /**
     * Creates the game and info menu
     *
     * @return the menu
     */
    public JMenu createGameMenu() {
        JMenu menu = new JMenu("Game");
        JMenuItem exitItem = new JMenuItem("Exit");
        ActionListener listener = new ExitItemListener();
        exitItem.addActionListener(listener);
        menu.add(createNewGameItem());
        menu.add(createRestartGameItem());
        menu.add(exitItem);
        return menu;
    }

    public JMenu createInfoMenu() {
        JMenu menu = new JMenu("Info");
        menu.add(createInfoManualItem());
        menu.add(createInfoAboutItem());
        return menu;
    }

    public JMenuItem createNewGameItem() {
        class NewGameItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.start();
            }
        }

        JMenuItem item = new JMenuItem("Start New Level");
        ActionListener listener = new NewGameItemListener();
        item.addActionListener(listener);
        return item;
    }

    public JMenuItem createRestartGameItem() {
        class RestartGameItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.restart();
            }
        }

        JMenuItem item = new JMenuItem("Restart Level");
        ActionListener listener = new RestartGameItemListener();
        item.addActionListener(listener);
        return item;
    }

    public JMenuItem createInfoManualItem() {
        class InfoManualItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.manual();
            }
        }

        JMenuItem item = new JMenuItem("Manual");
        ActionListener listener = new InfoManualItemListener();
        item.addActionListener(listener);
        return item;
    }

    public JMenuItem createInfoAboutItem() {
        class InfoAboutItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                Game game = new Game();
                game.about();
            }
        }

        JMenuItem item = new JMenuItem("About");
        ActionListener listener = new InfoAboutItemListener();
        item.addActionListener(listener);
        return item;
    }

}
