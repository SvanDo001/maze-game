package maze.runner;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken
 */
public class PlayerTest{
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetGameObject() {
        System.out.println("getGameObject");
        Player instance = new Player();
        Image result = instance.getGameObject();
        assertNotNull(result);
    }

    @Test
    public void testGetBazooka() {
        System.out.println("getBazooka");
        Player instance = new Player();
        Image result = instance.getBazooka();
        assertNotNull(result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        int dx = 0;
        int dy = 0;
        Player instance = new Player();
        instance.move(dx, dy);
    }

    @Test
    public void testMoveTo() {
        System.out.println("moveTo");
        int dx = 0;
        int dy = 0;
        Player instance = new Player();
        instance.moveTo(dx, dy);
    }

    @Test
    public void testSetGameObjectPosition() {
        System.out.println("setGameObjectPosition");
        int x = 5;
        int y = 5;
        Player instance = new Player();
        instance.setGameObjectPosition(x, y);

        assertEquals(instance.tileX, x);
        assertEquals(instance.tileY, y);
    }
 
    @Test
    public void testGetStepCounterTileX() {
        System.out.println("getStepCounterTileX");
        Player instance = new Player();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getStepCounterTileX();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetStepCounterTileX() {
        System.out.println("setStepCounterTileX");
        Player instance = new Player();
        instance.setStepCounterTileX();
    }

    @Test
    public void testGetStepCounterTileY() {
        System.out.println("getStepCounterTileY");
        Player instance = new Player();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getStepCounterTileY();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetStepCounterTileY() {
        System.out.println("setStepCounterTileY");
        Player instance = new Player();
        instance.setStepCounterTileY();
    }
    
}
