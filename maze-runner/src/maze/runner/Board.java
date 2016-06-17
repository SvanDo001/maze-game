package maze.runner;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Paints and repaints the board. Handles the key press events, the interaction
 * of the objects, starts a new maze and resets the current maze.
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
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

    /**
     * @param event returns an ActionEvent from the listener.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // repaints the level after an keystroke is hit
        repaint();
    }

    /**
     *
     * @param g object type of Graphical object from the Graphics class
     */
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

    /**
     * Handles the keystrokes of the arrow keys and the space bar.
     */
    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();

            /* checks whether a player hits a wall after the non number arrow 
             * key up is pressed. It also checks if a player is getting out of
             * bounds. If so, it prints a message.
             */
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

            /* checks whether a player hits a wall after the non number arrow 
             * key down is pressed. It also checks if a player is getting out of
             * bounds. If so, it prints a message.
             */
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

            /* checks whether a player hits a wall after the non number arrow 
             * key left is pressed. It also checks if a player is getting out of
             * bounds. If so, it prints a message.
             */
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

            /* checks whether a player hits a wall after the non number arrow 
             * key right is pressed. It also checks if a player is getting out of
             * bounds. If so, it prints a message.
             */
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

            /* Destroys a wall tile when space is hit and the player is carrying 
             * a bazooka. False otherwise. Also it prints a message.
             */
            if (keycode == KeyEvent.VK_SPACE) {

                if (player.getBazookaPickup() == true) {
                    player.setBazookaPickup();

                    player.destroyWall(getLevel(), player, mapLoader);
                } else if (player.getBazookaPickup() == false) {

                    System.out.println("Ammo Depleted");
                }
            }

            /* Saves the last position of player in two seperated arrays and
             * only if the player doesn't bump a wall.
             */
            player.setStepCounterTileXY();

            // method call KeyEvent()
            keyEvent(player.getTileX(), player.getTileY());
        }
    }

    /**
     * Checks whether the player has reached an interactive GameObject and gives 
     * back a message with a specific action attached to it. Replaces an 
     * interactive GameObject when the conditions of the specific interactive
     * GameObject are met.
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

    // Loads a new maze file on the board and calls the resetMaze() method
    public void newMaze() {
        mapLoader.nextFile();
        resetMaze();
    }

    /** Resets the current maze file by pulling the player back to the start
     * position, removes the current bazooka from player and clears the
     * last positions of player on the map. Also it adds the start position
     * back in the arrays.
     */
    public void resetMaze() {
        player.moveTo(1, 1);

        if (player.getBazookaPickup() == true) {
            player.setBazookaPickup();
        }
        mapLoader.openFile();
        mapLoader.readFile();
        mapLoader.closeFile();

        player.getStepCounterTileX().clear();
        player.getStepCounterTileY().clear();
        player.getStepCounterTileX().add(1);
        player.getStepCounterTileY().add(1);
    }

    // returns the last direct of the player
    public String getLastDirection() {
        return lastDirection;
    }

    // returns the current level instance
    public Board getLevel() {
        return Board.this;
    }
}
