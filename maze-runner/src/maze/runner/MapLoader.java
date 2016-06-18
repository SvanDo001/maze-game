package maze.runner;

import java.util.*;

/**
 * Returns GameObjects. Reads, opens and closes and iterate files in the
 * correct order. The strings of the files are interpreted and object instances
 * are created that are stored in the ArrayList of GameObjects. Also, it
 * replaces objects and the file shows the optimal route when the helper is met.
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public final class MapLoader {

    private ClassLoader classloader = Thread.currentThread().
            getContextClassLoader();
    private Scanner mapScanner;

    private GameObject[][] objects;
    private ArrayList<String> levelFiles;

    public int currentLevel;

    public MapLoader() {
        currentLevel = 0;
        
        levelFiles = new ArrayList<>();
        levelFiles.add("resources/Map1.txt");
        levelFiles.add("resources/Map2.txt");
        levelFiles.add("resources/Map3.txt");

        openFile();
        readFile();
        closeFile();
    }

    public GameObject getObject(int x, int y) {
        GameObject gameObject = objects[x][y];
        return gameObject;

    }

    /** 
     * 
     * Iterates the maze files in the correct order and restarts the sequence
     * after the last maze file is used and a new map file is called.
     */
    public void nextFile() {
        currentLevel++;
        if (currentLevel >= 3) {
            currentLevel = 0;
        }
    }

    // Opens the map files.
    public void openFile() {
        try {
            mapScanner = new Scanner(classloader.
                    getResourceAsStream(levelFiles.get(currentLevel)));
        } catch (Exception e) {
            System.out.println("Error loading map");
            System.out.println(e);
        }
    }

    /**
     * 
     * Creates an Array of objects and reads the the strings of the maze files
     * and compares individual strings. If the comparison is true an GameObject
     * will be created and places in the 2d ArrayList of objects.
     */
    public void readFile() {
        while (mapScanner.hasNext()) {
            objects = new GameObject[14][14];

            for (int y = 0; y < objects.length; y++) {
                String a = mapScanner.next();
                for (int x = 0; x < objects[y].length; x++) {
                    String character = a.substring(x, x + 1);
                    if (character.equals("w")) {
                        objects[x][y] = new Wall();
                    }
                    if (character.contains("g")) {
                        objects[x][y] = new Grass();
                    }
                    if (character.contains("c")) {
                        objects[x][y] = new Cheater();
                    }
                    if (character.equals("f")) {
                        objects[x][y] = new Friend();
                    }
                    if (character.equals("h")) {
                        objects[x][y] = new Helper();
                    }
                    if (character.equals("b")) {
                        objects[x][y] = new Bazooka();
                    }
                    if (character.contains("r")) {
                        objects[x][y] = new Grass();
                    }
                }
            }
        }
    }

    // Closes the file.
    public void closeFile() {
        mapScanner.close();
    }

    // Replaces an certain object with an grass object.
    public void replaceObject(int x, int y, String type) {
        if (type.equals("grass")) {
            objects[x][y] = new Grass();
        }
    }

    /**
     * 
     * Replaces the grass tiles of the positions in the file with route tiles
     * objects and shows them on the maze.
     */
    public void showOptimaleRoute() {
        openFile();

        for (int y = 0; y < objects.length; y++) {
            String a = mapScanner.next();
            for (int x = 0; x < objects[y].length; x++) {
                String character = a.substring(x, x + 1);
                if (character.contains("r")) {
                    objects[x][y] = new OptimalRoute();
                }
            }
        }
        
        closeFile();
    }
}
