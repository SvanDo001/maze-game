package maze.runner;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
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
public class LevelTest {
    
    public LevelTest() {
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
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent event = null;
        Level instance = new Level();
        instance.actionPerformed(event);
    }

    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        Level instance = new Level();
        instance.paint(g);
    }

    @Test
    public void testThrowBackPlayer() {
        System.out.println("throwBackPlayer");
        int steps = 0;
        Level instance = new Level();
        instance.throwBackPlayer(steps);
    }

    @Test
    public void testKeyEvent() {
        System.out.println("keyEvent");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        instance.keyEvent(x, y);
    }

    @Test
    public void testDestroyWall() {
        System.out.println("destroyWall");
        Level instance = new Level();
        instance.destroyWall();
    }

    @Test
    public void testReset() {
        System.out.println("reset");
        Level instance = new Level();
        instance.reset();
    }
    
}
