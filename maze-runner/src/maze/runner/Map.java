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
            objects = new GameObject[14][14];
            
            for (int y = 0; y < objects.length; y++)
            {
                String a = map.next();
                for (int x = 0; x < objects[y].length; x++)
                {
                    if (a.substring(x, x + 1).equals("w")) {
                        objects[y][x] = new Wall();
                        System.out.println(objects[13][13]);
                    }
//                    if (a.equals("g")) {
//                        objects[y][x] = new Friend();
//                    }
//                    if (a.equals("c")) {
//                        objects[y][x] = new Cheater();
//                    }
//                    if (a.equals("f")) {
//                        objects[y][x] = new Friend();
//                    }
//                    if (a.equals("h")) {
//                        objects[y][x] = new Helper();
//                    }
//                    if (a.equals("b")) {
//                        objects[y][x] = new Bazooka();
//                    }
//                    if (a.equals("r")) {
//                        objects[y][x] = new Helper();
//                    }
                }
            }
        }
    }

    private void closeFile() {
        map.close();
    }    
}
