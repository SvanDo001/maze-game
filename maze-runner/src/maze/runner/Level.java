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
    private Cheater cheater;
    private Friend friend;

    public Level() {
        map = new Map();
        player = new Player();
        cheater = new Cheater();
        friend = new Friend();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
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
                    g.drawImage(map.getGrassTile(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("w")) {
                    g.drawImage(map.getWallTile(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("e")) {
                    g.drawImage(cheater.getCheater(), x * 32, y * 32, null);
                }
                if (map.getTile(x, y).equals("f")) {
                    g.drawImage(friend.getFriend(), x * 32, y * 32, null);
                }
            }
            g.drawImage(player.getPlayer(), player.getTileX() * 32,
                    player.getTileY() * 32, null);
        }
    }
    
    public void throwBackPlayer(int steps) {        
        int currentPositionX = player.getStepCounterTileX().size() - 1;
        int currentPositionY = player.getStepCounterTileY().size() - 1;
      
        int throwBackPositionX = player.getStepCounterTileX().
                get(currentPositionX) - steps;
        int throwBackPositionY = player.getStepCounterTileY().
                get(currentPositionY) - steps;

        player.move(throwBackPositionX, throwBackPositionY);
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (!map.getTile(player.getTileX(), player.getTileY() - 1).
                        equals("w")) {
                    player.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (!map.getTile(player.getTileX(), player.getTileY() + 1).
                        equals("w")) {
                    player.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!map.getTile(player.getTileX() - 1, player.getTileY()).
                        equals("w")) {
                    player.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!map.getTile(player.getTileX() + 1, player.getTileY()).
                        equals("w")) {
                    player.move(1, 0);
                }
            }
            if (keycode == KeyEvent.VK_SPACE) {
                throwBackPlayer(2);
            }
            
            player.setStepCounterTileX();
            player.setStepCounterTileY();
        }
    }
}
