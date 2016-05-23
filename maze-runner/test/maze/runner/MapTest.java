/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.awt.Image;
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
public class MapTest {
    
    public MapTest() {
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
     * Test of getGrass method, of class Map.
     */
    @Test
    public void testGetGrass() {
        System.out.println("getGrass");
        Map instance = new Map();
        Image expResult = null;
        Image result = instance.getGrass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWall method, of class Map.
     */
    @Test
    public void testGetWall() {
        System.out.println("getWall");
        Map instance = new Map();
        Image expResult = null;
        Image result = instance.getWall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMap method, of class Map.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        int x = 0;
        int y = 0;
        Map instance = new Map();
        String expResult = "";
        String result = instance.getMap(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openFile method, of class Map.
     */
    @Test
    public void testOpenFile() {
        System.out.println("openFile");
        Map instance = new Map();
        instance.openFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class Map.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        Map instance = new Map();
        instance.readFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeFile method, of class Map.
     */
    @Test
    public void testCloseFile() {
        System.out.println("closeFile");
        Map instance = new Map();
        instance.closeFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
