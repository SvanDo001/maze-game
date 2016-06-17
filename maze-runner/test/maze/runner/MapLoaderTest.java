/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class MapLoaderTest {
    
    public MapLoaderTest() {
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
     * Test of getObject method, of class MapLoader.
     */
    @Test
    public void testGetObject() {
        System.out.println("getObject");
        int x = 0;
        int y = 0;
        MapLoader instance = new MapLoader();
        GameObject expResult = null;
        GameObject result = instance.getObject(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextFile method, of class MapLoader.
     */
    @Test
    public void testNextFile() {
        System.out.println("nextFile");
        MapLoader instance = new MapLoader();
        instance.nextFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openFile method, of class MapLoader.
     */
    @Test
    public void testOpenFile() {
        System.out.println("openFile");
        MapLoader instance = new MapLoader();
        instance.openFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class MapLoader.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        MapLoader instance = new MapLoader();
        instance.readFile();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeFile method, of class MapLoader.
     */
    @Test
    public void testCloseFile() {
        System.out.println("closeFile");
        MapLoader instance = new MapLoader();
        instance.closeFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replaceObject method, of class MapLoader.
     */
    @Test
    public void testReplaceObject() {
        System.out.println("replaceObject");
        int x = 0;
        int y = 0;
        String type = "";
        MapLoader instance = new MapLoader();
        instance.replaceObject(x, y, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showOptimaleRoute method, of class MapLoader.
     */
    @Test
    public void testShowOptimaleRoute() {
        System.out.println("showOptimaleRoute");
        MapLoader instance = new MapLoader();
        instance.showOptimaleRoute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
