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
                if (map.getTile(x, y).equals("g")) {
                    g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("r")) {
                    if (optimalRoute == false) {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    } else {
                        g.drawImage(helper.getOptimaleRoute(), x * 32, y * 32, null);
                    }
                }
                if (map.getTile(x, y).equals("w")) {
                    if (x == breakX && y == breakY) {
                        g.drawImage(grass.getGameObject(), x * 32, y * 32, null);
                    } else {
                        g.drawImage(wall.getGameObject(), x * 32, y * 32, null);
                    }
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
                    destroyWall();
                    bazookaPickUp = false;
            }

            player.setStepCounterTileX();
            player.setStepCounterTileY();

            keyEvent(player.getTileX(), player.getTileY());
        }
    }
    
    /**
     * Checks whether the player has reach another GameObject and gives back
     * a message with an specific action attached to it. Places the reached
     * GameObject outside of the grid.
     * 
     * @param x the coordinate of the x ass
     * @param y the coordinate of the y ass
     */
    public void keyEvent(int x, int y) {
        if (x == cheater.getTileX() && y == cheater.getTileY()) {
            System.out.println("Cheater Bereikt!");
            int random = ((int) (Math.random() * 10) + 5);
            JOptionPane.showMessageDialog(null, "Whahaha, I will knock you " +
                    "back " + random + " steps!");
            throwBackPlayer(random);
            cheater.setGameObjectPosition(-1, -1);
        }
        if (x == friend.getTileX() && y == friend.getTileY()) {
            System.out.println("Vriend Bereikt!");
            int steps = player.historyTileX.size() - 1;
            JOptionPane.showMessageDialog(null, "Congratulations, you have " 
                    + "reached your friend! " + "\n    You have completed the maze in " 
                    + steps + " steps.");
            friend.setGameObjectPosition(-1, -1);
        }
        if (x == helper.getTileX() && y == helper.getTileY()) {
            System.out.println("Helper Bereikt!");
            JOptionPane.showMessageDialog(null, "Let me help you by showing you the "
                    + "optimal route to your friend!");
            helper.setGameObjectPosition(-1, -1);
            optimalRoute = true;
        }
        if (x == bazooka.getTileX() && y == bazooka.getTileY()) {
            System.out.println("Bazooka Bereikt!");
            bazooka.setGameObjectPosition(-1, -1);
            bazookaPickUp = true;
        }

    }
    
    public void destroyWall() { 
        int currentTileX = player.getTileX();
        int currentTileY = player.getTileY();
        
        if (lastDirection.equalsIgnoreCase("UP")) {
            boolean check = true;
            
            while (check == true)  {
                if (!map.getTile(currentTileX, currentTileY - 1).equals("w")) {
                    currentTileY--;
                } else  {
                    check = false;
                    breakX = currentTileX;
                    breakY = currentTileY - 1;
                }
            }
        } 
        
        if (lastDirection.equalsIgnoreCase("DOWN")) {
            boolean check = true;
            
            while (check == true)  {
                if (!map.getTile(currentTileX, currentTileY + 1).equals("w")) {
                    currentTileY++;
                } else {
                    check = false;
                    breakX = currentTileX;
                    breakY = currentTileY + 1;
                }
            }
        }
        
        if (lastDirection.equalsIgnoreCase("LEFT")) {
            boolean check = true;
            
            while (check == true)  {
                if (!map.getTile(currentTileX - 1, currentTileY).equals("w")) {
                    currentTileX--;
                } else {
                    check = false;
                    breakX = currentTileX - 1;
                    breakY = currentTileY;
                }
            }
        }
                
        if (lastDirection.equalsIgnoreCase("RIGHT")) {
            boolean check = true;
            
            while (check == true)  {
                if (!map.getTile(currentTileX + 1, currentTileY).equals("w")) {
                    currentTileX++;
                } else {
                    check = false;
                    breakX = currentTileX + 1;
                    breakY = currentTileY;
                }
            }
        }
    }
    
    public void reset() {
        newMap = true;
        optimalRoute = false;
        bazookaPickUp = false;
        breakX = -1;
        breakX = -1;
        player.moveTo(1, 1);
    }
}

