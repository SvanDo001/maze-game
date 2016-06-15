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
    private OptimalRoute optimalRoute;
    private Bazooka bazooka;
    private int breakX, breakY;
    private String lastDirection;

    public Level() {
        timer = new Timer(25, this);
        timer.start();
        map = new Map();
        wall = new Wall();
        grass = new Grass();
        player = new Player();
        cheater = new Cheater();
        friend = new Friend();
        helper = new Helper(0, 0);
        bazooka = new Bazooka();
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

                if (map.getObject(x, y).equals(map.getObject(x, y))) {
                    g.drawImage(map.getObject(x, y).getGameObject(), x * 32, y * 32, null);
                }
            }

            g.drawImage(player.getGameObject(), player.getTileX() * 32, player.getTileY() * 32, null);
            g.drawImage(cheater.getGameObject(), cheater.getTileX() * 32, cheater.getTileY() * 32, null);
            g.drawImage(friend.getGameObject(), friend.getTileX() * 32, friend.getTileY() * 32, null);
            g.drawImage(bazooka.getGameObject(), bazooka.getTileX() * 32, bazooka.getTileY() * 32, null);
            g.drawImage(helper.getGameObject(), helper.getTileX() * 32, helper.getTileY() * 32, null);
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
                    /  bazooka. False otherwise.
             */
            if (keycode == KeyEvent.VK_SPACE) {
                if (player.getBazookaPickup() == true) {
                    System.out.println(player.getBazookaPickup());
                    bazooka.destroyWall(getLevel(), player, map);
                    player.setBazookaPickup();
                } else {
                    System.out.println(player.getBazookaPickup());
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
            cheater.throwBackPlayer(player);
            map.replaceObject(x, y, "grass");
        }
        if (map.getObject(x, y) instanceof Friend) {
            friend.meetFriend(player);
        }
        if (map.getObject(x, y) instanceof Helper) {
            helper.meetHelper();
            map.replaceObject(x, y, "grass");
            map.showOptimaleRoute();
        }
        if (map.getObject(x, y) instanceof Bazooka) {
            player.setBazookaPickup();
            System.out.println(player.getBazookaPickup());
            map.replaceObject(x, y, "grass");
        }

    }

    public void resetGameAttributes() {

        // hier nog naarr kijken! moet nu dmv nieuwe objecten plaatsen.
//        optimalRoute.setActive();
//        player.setActive();
//        breakX = -1;
//        breakX = -1;
        player.moveTo(1, 1);
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public int getBreakX() {
        return breakX;
    }

    public int getBreakY() {
        return breakY;
    }

    public void setBreakX_Y(int x, int y) {
        breakX = x;
        breakY = y;
    }

    public Level getLevel() {
        return Level.this;
    }
}
