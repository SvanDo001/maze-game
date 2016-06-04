/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import javax.swing.JFrame;
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
public class EmptyFrameViewerTest {
    
    public EmptyFrameViewerTest() {
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

    /**
     * Test of EmptyFrame method, of class MazeFrame.
     */
    @Test
    public void testEmptyFrame() {
        System.out.println("EmptyFrame");
        MazeFrame instance = new EmptyFrameViewerImpl();
        JFrame expResult = null;
        JFrame result = instance.EmptyFrame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EmptyFrameViewerImpl extends MazeFrame {
    }
    
}
