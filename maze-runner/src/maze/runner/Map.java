package maze.runner;

import java.util.*;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public final class Map {
    
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Scanner map;

    private final String[] MAP = new String[14];
    
    ArrayList<String> locatie;
    int currentLevel;

    public Map() {
        locatie = new ArrayList<>();
        locatie.add("resources/Map.txt");
        locatie.add("resources/Map2.txt");
        locatie.add("resources/Map3.txt");
        
        openFile();
        readFile();
        closeFile();
    }

    public String getTile(int x, int y) {
        String tileIndex = MAP[y].substring(x, x + 1);
        return tileIndex;
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
            for (int i = 0; i < 14; i++) {
                MAP[i] = map.next();
            }
        }
    }

    private void closeFile() {
        map.close();
    }
}
