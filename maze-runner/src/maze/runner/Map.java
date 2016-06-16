package maze.runner;

import java.util.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public final class Map {

    private ClassLoader classloader = Thread.currentThread().
            getContextClassLoader();
    private Scanner map;

    private GameObject[][] objects;
    private ArrayList<String> levelFiles;

    public int currentLevel;

    public Map() {
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

    public void nextFile() {
        currentLevel++;
        if (currentLevel >= 3) {
            currentLevel = 0;
        }
    }

    public void openFile() {
        try {
            map = new Scanner(classloader.
                    getResourceAsStream(levelFiles.get(currentLevel)));
        } catch (Exception e) {
            System.out.println("Error loading map");
            System.out.println(e);
        }
    }

    public void readFile() {

        while (map.hasNext()) {
            objects = new GameObject[14][14];

            for (int y = 0; y < objects.length; y++) {
                String a = map.next();
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

    public void closeFile() {
        map.close();
    }

    public void replaceObject(int x, int y, String type) {
        if (type.equals("grass")) {
            objects[x][y] = new Grass();
        }
    }

    public void showOptimaleRoute() {
        openFile();

        for (int y = 0; y < objects.length; y++) {
            String a = map.next();
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
