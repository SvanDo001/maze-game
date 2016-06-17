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
    public Game game = null;

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

        JMenuItem start = new JMenuItem("Start New Level");
        ActionListener listener = new NewGameItemListener();
        start.addActionListener(listener);
        return start;
    }

    public JMenuItem createRestartGameItem() {
        class RestartGameItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.restart();
            }
        }

        JMenuItem restart = new JMenuItem("Restart Level");
        ActionListener listener = new RestartGameItemListener();
        restart.addActionListener(listener);
        return restart;
    }

    public JMenuItem createInfoManualItem() {
        class InfoManualItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.manual();
            }
        }

        JMenuItem manual = new JMenuItem("Manual");
        ActionListener listener = new InfoManualItemListener();
        manual.addActionListener(listener);
        return manual;
    }

    public JMenuItem createInfoAboutItem() {
        class InfoAboutItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                game.about();
            }
        }

        JMenuItem about = new JMenuItem("About");
        ActionListener listener = new InfoAboutItemListener();
        about.addActionListener(listener);
        return about;
    }
}