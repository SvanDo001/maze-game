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
    private ArrayList<String> locatie;

    private int currentLevel;

    public Map() {
        locatie = new ArrayList<>();
        locatie.add("resources/Map1.txt");
        locatie.add("resources/Map2.txt");
        locatie.add("resources/Map3.txt");

        openFile();
        readFile();
        closeFile();
    }

    public GameObject getObject(int x, int y) {
        GameObject gameObject = objects[x][y];
        return gameObject;

    }

    private void openFile() {
        try {
            currentLevel = ((int) (Math.random() * 3));
            map = new Scanner(classloader.
                    getResourceAsStream(locatie.get(currentLevel)));;
        } catch (Exception e) {
            System.out.println("Error loading map");
            System.out.println(e);
        }
    }

    private void readFile() {
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
                        objects[x][y] = new Helper(x, y);
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

    private void closeFile() {
        map.close();
    }

    public void replaceObject(int x, int y, String type) {
        if (type.equals("grass")) {
            objects[x][y] = new Grass();
            System.out.println("new  Grass() @> objects[" + x + "][" + y 
                    + "] : " + objects[x][y]);
        }
    }

    public void showOptimaleRoute() {
        map = new Scanner(classloader.
                getResourceAsStream(locatie.get(currentLevel)));

        for (int y = 0; y < objects.length; y++) {

            String a = map.next();

            for (int x = 0; x < objects[y].length; x++) {

                String character = a.substring(x, x + 1);

                if (character.contains("r")) {
                    objects[x][y] = new OptimalRoute();
                    System.out.println("new  Opt.Route() @> objects[" + x + "][" + y + "] : " + objects[x][y]);
                }
            }
        }
        closeFile();
    }
}