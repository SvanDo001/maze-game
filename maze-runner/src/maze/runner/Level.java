package maze.runner;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Stefan & Kenny
 */
public class Level extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Wall wall;
    private Grass grass;
    private Player player;
    private Cheater cheater;
    private Friend friend;
    private Helper helper;
    private Bazooka bazooka;
    private boolean newMap;

    public Level() {
        timer = new Timer(25, this);
        timer.start();
        map = new Map();
        wall = new Wall();
        grass = new Grass();
        player = new Player();
        cheater = new Cheater();
        friend = new Friend();
        helper = new Helper();
        bazooka = new Bazooka();
        addKeyListener(new Al());
        setFocusable(true);
        newMap = true;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int y = 0; y < 14; y++) {
            for (int x = 0; x < 14; x++) {
                if (map.getTile(x, y).equals("g")) {
                    g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("w")) {
                    g.drawImage(wall.getGameObject(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("c")) {
                    if (newMap == true) {
                        cheater.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals("f")) {
                    if (newMap == true) {
                        friend.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals("h")) {
                    if (newMap == true) {
                        helper.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals("b")) {
                    if (newMap == true) {
                        bazooka.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
            }

            g.drawImage(player.getGameObject(), player.getTileX() * 32, player.getTileY() * 32, null);
            g.drawImage(cheater.getGameObject(), cheater.getTileX() * 32, cheater.getTileY() * 32, null);
            g.drawImage(friend.getGameObject(), friend.getTileX() * 32, friend.getTileY() * 32, null);
            g.drawImage(bazooka.getGameObject(), bazooka.getTileX() * 32, bazooka.getTileY() * 32, null);
            g.drawImage(helper.getGameObject(), helper.getTileX() * 32, helper.getTileY() * 32, null);
        }
        newMap = false;
    }

    public void throwBackPlayer(int steps) {
        int ArraySizeTileX = player.getStepCounterTileX().size() - 1;
        int ArraySizeTileY = player.getStepCounterTileY().size() - 1;

        int throwBackPositionX = player.getStepCounterTileX().get(ArraySizeTileX - steps);
        int throwBackPositionY = player.getStepCounterTileY().get(ArraySizeTileY - steps);

        player.moveTo(throwBackPositionX, throwBackPositionY);
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (!map.getTile(player.getTileX(), player.getTileY() - 1).equals("w")) {
                    player.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (!map.getTile(player.getTileX(), player.getTileY() + 1).equals("w")) {
                    player.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!map.getTile(player.getTileX() - 1, player.getTileY()).equals("w")) {
                    player.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!map.getTile(player.getTileX() + 1, player.getTileY()).equals("w")) {
                    player.move(1, 0);
                }
            }
            player.setStepCounterTileX();
            player.setStepCounterTileY();

            keyEvent(player.getTileX(), player.getTileY());
        }
    }

    public void keyEvent(int x, int y) {
        if (x == cheater.getTileX() && y == cheater.getTileY()) {
            System.out.println("Cheater Bereikt!");
            throwBackPlayer(5);
            cheater.setGameObjectPosition(-1, -1);
        }
        if (x == friend.getTileX() && y == friend.getTileY()) {
            System.out.println("Vriend Bereikt!");
            int steps = player.historyTileX.size() - 1;
            JOptionPane.showMessageDialog(null, "Congratulations, you have " +
                    "reached your friend! " + "You did it in " + steps 
                    + " steps.");
            friend.setGameObjectPosition(-1, -1);
        }
        if (x == helper.getTileX() && y == helper.getTileY()) {
            System.out.println("Helper Bereikt!");
            helper.setGameObjectPosition(-1, -1);
        }
        if (x == bazooka.getTileX() && y == bazooka.getTileY()) {
            System.out.println("Bazooka Bereikt!");
            bazooka.setGameObjectPosition(-1, -1);
        }

    }
}
