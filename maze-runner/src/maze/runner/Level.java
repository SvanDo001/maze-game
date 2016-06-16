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
    private Player player;
    private String lastDirection;

    public Level() {
        timer = new Timer(25, this);
        timer.start();
        map = new Map();
        player = new Player();
        addKeyListener(new Al());
        setFocusable(true);
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

                // draws every GameObject from objects[x][y]array
                g.drawImage(map.getObject(x, y).getGameObject(), x * 32, y * 32, null);

                // draws the player based on his own x, y coordinates
                g.drawImage(player.getGameObject(), player.getTileX() * 32, player.getTileY() * 32, null);
            }
        }
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                lastDirection = "UP";
                if (map.getObject(player.getTileX(), player.getTileY() - 1) instanceof Wall == false) {
                    player.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                lastDirection = "DOWN";
                if (map.getObject(player.getTileX(), player.getTileY() + 1) instanceof Wall == false) {
                    player.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                lastDirection = "LEFT";
                if (map.getObject(player.getTileX() - 1, player.getTileY()) instanceof Wall == false) {
                    player.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                lastDirection = "RIGHT";
                if (map.getObject(player.getTileX() + 1, player.getTileY()) instanceof Wall == false) {
                    player.move(1, 0);
                }
            }

            /* Destroys a wall tile when space is hit and player is carrying a 
             * bazooka. False otherwise.
             */
            if (keycode == KeyEvent.VK_SPACE) {

                if (player.getBazookaPickup() == true) {
                    player.setBazookaPickup();

                    player.destroyWall(getLevel(), player, map);
                } else if (player.getBazookaPickup() == false) {

                    System.out.println("Ammo Depleted");
                }
            }

            player.setStepCounterTileX();
            player.setStepCounterTileY();

            keyEvent(player.getTileX(), player.getTileY());
        }
    }

    /**
     * Checks whether the player has reached another GameObject and gives back a
     * message with a specific action attached to it. Places the reached
     * GameObject outside of the grid.
     *
     * @param x the coordinate of the x axis
     * @param y the coordinate of the y axis
     */
    public void keyEvent(int x, int y) {
        if (map.getObject(x, y) instanceof Cheater) {
            Cheater cheater = (Cheater) map.getObject(x, y);
            cheater.throwBackPlayer(player);
            map.replaceObject(x, y, "grass");
        }
        if (map.getObject(x, y) instanceof Friend) {
            Friend friend = (Friend) map.getObject(x, y);
            friend.meetFriend(player);
            map.readFile();
        }
        if (map.getObject(x, y) instanceof Helper) {
            Helper helper = (Helper) map.getObject(x, y);
            helper.meetHelper();
            map.replaceObject(x, y, "grass");
            map.showOptimaleRoute();
        }
        if (map.getObject(x, y) instanceof Bazooka) {
            
            // If player already has a bazooka, do not pickup.
            if (player.getBazookaPickup() == false) {
                player.setBazookaPickup();
                map.replaceObject(x, y, "grass");
            }
            
        }

    }

    public void newMaze() {
        player.moveTo(1, 1);

        map.nextFile();
        map.openFile();
        map.readFile();
        map.closeFile();
    }

    public void resetMaze() {
        player.moveTo(1, 1);

        map.openFile();
        map.readFile();
        map.closeFile();
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public Level getLevel() {
        return Level.this;
    }
}
