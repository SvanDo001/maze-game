package maze.runner;

import java.util.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public final class Map {
    
    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private Scanner map;
    
    private GameObject[][] objects;
    private ArrayList<String> locatie;
    
    private int currentLevel;

    public Map() {
        locatie = new ArrayList<>();
        locatie.add("resources/Map.txt");
        locatie.add("resources/Map2.txt");
        locatie.add("resources/Map3.txt");
        
        openFile();
        readFile();
        closeFile();
    }
    
    public GameObject getTile(int x, int y) {
        GameObject gameObject = objects[y][x];
        return gameObject;
        
        
    }
    
    private void openFile() {
        try {
            currentLevel = ((int) (Math.random() * 3));
            map = new Scanner(classloader.
                    getResourceAsStream(locatie.
                            get(currentLevel)));
        } catch (Exception e) {
            System.out.println("Error loading map");
            System.out.println(e);
        }
    }

    private void readFile() {
        while (map.hasNext()) {
            int y = 14;
            int x = 14;
            objects = new GameObject[y][x];
            
            for (y = 0; y < objects.length; y++)
            {
                String a = map.next();
                for (x = 0; x < objects[y].length; x++)
                {
                    if (a.contains("w")) {
                        objects[y][x] = new Wall();
                        System.out.println(objects[0][0]);
                    }
                    else if (a.contains("g")) {
                        objects[y][x] = new Friend();
                        System.out.println(objects[0][1]);
                    }
                    else if (a.contains("c")) {
                        objects[y][x] = new Cheater();
                    }
                    else if (a.contains("f")) {
                        objects[y][x] = new Friend();
                    }
                    else if (a.contains("h")) {
                        objects[y][x] = new Helper();
                    }
                    else if (a.contains("b")) {
                        objects[y][x] = new Bazooka();
                    }
                    else if (a.contains("r")) {
                        objects[y][x] = new Helper();
                    }
                }
            }
        }
    }

    private void closeFile() {
        map.close();
    }
}
