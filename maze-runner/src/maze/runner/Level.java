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
    private boolean optimalRoute;
    private boolean bazookaPickUp;
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
        helper = new Helper();
        bazooka = new Bazooka();
        addKeyListener(new Al());
        setFocusable(true);
        newMap = true;
        optimalRoute = false;
        bazookaPickUp = false;
        
        //debugging
        breakX = -1;
        breakY = -1;
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
                System.out.println(map.getTile(x, y));
                if (map.getTile(x, y).equals(grass)) {
                    g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals(helper)) {
                    if (optimalRoute == false) {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    } else {
                        g.drawImage(helper.getOptimaleRoute(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals(wall)) {
                    if (x == breakX && y == breakY) {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    } else {
                        g.drawImage(wall.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals(cheater)) {
                    if (newMap == true) {
                        cheater.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals(friend)) {
                    if (newMap == true) {
                        friend.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals(helper)) {
                    if (newMap == true) {
                        helper.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals(bazooka)) {
                    if (newMap == true) {
                        bazooka.setGameObjectPosition(x, y);
                    } else {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    }
                }
            }
            if (bazookaPickUp == false){
                g.drawImage(player.getGameObject(), player.getTileX() * 32, player.getTileY() * 32, null);
            } else {
                g.drawImage(player.getBazooka(), player.getTileX() * 32, player.getTileY() * 32, null);
            }
            g.drawImage(cheater.getGameObject(), cheater.getTileX() * 32, cheater.getTileY() * 32, null);
            g.drawImage(friend.getGameObject(), friend.getTileX() * 32, friend.getTileY() * 32, null);
            g.drawImage(bazooka.getGameObject(), bazooka.getTileX() * 32, bazooka.getTileY() * 32, null);
            g.drawImage(helper.getGameObject(), helper.getTileX() * 32, helper.getTileY() * 32, null);
        }
        newMap = false;
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();
            
            if (keycode == KeyEvent.VK_UP) {
                lastDirection = "UP";
                if (!map.getTile(player.getTileX(), player.getTileY() - 1).equals("w")) {
                    player.move(0, -1);
                } else if (player.getTileX() == breakX && (player.getTileY() - 1) == breakY) {
                    player.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                lastDirection = "DOWN";
                if (!map.getTile(player.getTileX(), player.getTileY() + 1).equals("w")) {
                    player.move(0, 1);
                } else if (player.getTileX() == breakX && (player.getTileY() + 1) == breakY) {
                    player.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                lastDirection = "LEFT";
                if (!map.getTile(player.getTileX() - 1, player.getTileY()).equals("w")) {
                    player.move(-1, 0);
                } else if ((player.getTileX() - 1) == breakX && player.getTileY() == breakY) {
                    player.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                lastDirection = "RIGHT";
                if (!map.getTile(player.getTileX() + 1, player.getTileY()).equals("w")) {
                    player.move(1, 0);
                } else if ((player.getTileX() + 1) == breakX && player.getTileY() == breakY) {
                    player.move(1, 0);
                }
            }
            
            /* Destroys a wall tile when space is hit and player is carrying a 
            /  bazooka. False otherwise.
            */
            if (keycode == KeyEvent.VK_SPACE && bazookaPickUp == true) {
                    bazooka.destroyWall(getLevel(), player , map);
                    bazookaPickUp = false;
            }

            player.setStepCounterTileX();
            player.setStepCounterTileY();

            keyEvent(player.getTileX(), player.getTileY());
        }
    }
    
    /**
     * Checks whether the player has reached another GameObject and gives back
     * a message with a specific action attached to it. Places the reached
     * GameObject outside of the grid.
     * 
     * @param x the coordinate of the x axis
     * @param y the coordinate of the y axis
     */
    public void keyEvent(int x, int y) {
        if (x == cheater.getTileX() && y == cheater.getTileY()) {
            cheater.throwBackPlayer(player);
        }
        if (x == friend.getTileX() && y == friend.getTileY()) {
            friend.meetFriend(player);
            
        }
        if (x == helper.getTileX() && y == helper.getTileY()) {
            helper.meetHelper();
            optimalRoute = true;
        }
        if (x == bazooka.getTileX() && y == bazooka.getTileY()) {
            bazooka.setGameObjectPosition(-1, -1);
            bazookaPickUp = true;
        }

    }
    

    
    public void resetGameAttributes() {
        newMap = true;
        optimalRoute = false;
        bazookaPickUp = false;
        breakX = -1;
        breakX = -1;
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

