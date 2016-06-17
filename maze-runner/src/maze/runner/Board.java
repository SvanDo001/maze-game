package maze.runner;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Stefan & Kenny
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private MapLoader mapLoader;
    private Player player;
    private String lastDirection;

    public Board() {
        timer = new Timer(25, this);
        timer.start();
        mapLoader = new MapLoader();
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

        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 14; y++) {

                // draws every GameObject from objects[x][y]array
                g.drawImage(mapLoader.getObject(x, y).getGameObject(), x * 32, y * 32, null);

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
                if (player.getTileY() - 1 >= 0) {
                    if (mapLoader.getObject(player.getTileX(), player.getTileY() - 1) instanceof Wall == false) {
                        player.move(0, -1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot walk off "
                            + "the grid ;-)");
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                lastDirection = "DOWN";
                if (player.getTileY() + 1 <= 13) {
                    if (mapLoader.getObject(player.getTileX(), player.getTileY() + 1) instanceof Wall == false) {
                        player.move(0, 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot walk off "
                            + "the grid ;-)");
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                lastDirection = "LEFT";
                if (player.getTileX() - 1 >= 0) {
                    if (mapLoader.getObject(player.getTileX() - 1, player.getTileY()) instanceof Wall == false) {
                        player.move(-1, 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot walk off "
                            + "the grid ;-)");
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                lastDirection = "RIGHT";
                if (player.getTileX() + 1 <= 13) {
                    if (mapLoader.getObject(player.getTileX() + 1, player.getTileY()) instanceof Wall == false) {
                        player.move(1, 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot walk off "
                            + "the grid ;-)");
                }
            }
            
            /* Destroys a wall tile when space is hit and player is carrying a 
             * bazooka. False otherwise.
             */
            if (keycode == KeyEvent.VK_SPACE) {

                if (player.getBazookaPickup() == true) {
                    player.setBazookaPickup();

                    player.destroyWall(getLevel(), player, mapLoader);
                } else if (player.getBazookaPickup() == false) {

                    System.out.println("Ammo Depleted");
                }
            }

            player.setStepCounterTileXY();

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
        if (mapLoader.getObject(x, y) instanceof Cheater) {
            Cheater cheater = (Cheater) mapLoader.getObject(x, y);
            cheater.throwBackPlayer(player);
            mapLoader.replaceObject(x, y, "grass");
        }
        if (mapLoader.getObject(x, y) instanceof Friend) {
            Friend friend = (Friend) mapLoader.getObject(x, y);
            friend.meetFriend(player);
            newMaze();
        }
        if (mapLoader.getObject(x, y) instanceof Helper) {
            Helper helper = (Helper) mapLoader.getObject(x, y);
            helper.meetHelper();
            mapLoader.replaceObject(x, y, "grass");
            mapLoader.showOptimaleRoute();
        }
        if (mapLoader.getObject(x, y) instanceof Bazooka) {

            // If player already has a bazooka, do not pickup.
            if (player.getBazookaPickup() == false) {
                player.setBazookaPickup();
                mapLoader.replaceObject(x, y, "grass");
            }

        }

    }

    public void newMaze() {
        mapLoader.nextFile();
        resetMaze();
    }

    public void resetMaze() {
        player.moveTo(1, 1);
        
        if (player.getBazookaPickup() == true) {
                player.setBazookaPickup();
        }        
        mapLoader.openFile();
        mapLoader.readFile();
        mapLoader.closeFile();
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public Board getLevel() {
        return Board.this;
    }
}
