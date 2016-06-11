package maze.runner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Stefan
 */
public final class Map {
    
    //classloader om resource vanuit project resources te laden
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Scanner map;

    private final String[] MAP = new String[14];

    public Map() {
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
            map = new Scanner(classloader.
                    getResourceAsStream("resources/Map.txt"));

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
