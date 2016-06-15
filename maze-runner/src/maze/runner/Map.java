package maze.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        File f = new File("resources/Map"); System.out.println("file path: " + f.getAbsolutePath());
        try {
//            InputStream is = Hangman1.class.getResourceAsStream("/resources/word.txt");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

//            BufferedReader br = new BufferedReader(new FileReader("somefile.txt"));
//            BufferedReader infixLines = new BufferedReader ( new FileReader ( "input.infix" ));

            currentLevel = ((int) (Math.random() * 3));
            map = new Scanner(classloader.
                    getResourceAsStream(locatie.
                            get(0)));

//            InputStream is = Map.class.getResourceAsStream("resources//Map.txt");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            
//            BufferedReader reader = new BufferedReader(new FileReader("resources/Map"));
//            
//            System.out.println("reader : " + (char)reader.read());
//            reader.close();
            
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
<<<<<<< HEAD
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
=======
                    String character = a.substring(x, x + 1);
                    if (character.equals("w")) {
                        objects[x][y] = new Wall();
                        System.out.println("WALL  - X:" + x + " Y:" + y);
                    }
                    if (character.contains("g")) {
                        objects[x][y] = new Grass();
                        System.out.println("GRASS - X:" + x + " Y:" + y);
                    }
                    if (character.contains("c")) {
                        objects[x][y] = new Cheater();
                        System.out.println("CHEATER - X:" + x + " Y:" + y);
                    }
                    if (character.equals("f")) {
                        objects[x][y] = new Friend();
                        System.out.println("FRIEND - X:" + x + " Y:" + y);
                    }
                    if (character.equals("h")) {
                        objects[x][y] = new Helper();
                        System.out.println("HELPER - X:" + x + " Y:" + y);
                    }
                    if (character.equals("b")) {
                        objects[x][y] = new Bazooka();
                        System.out.println("BAZOOKA - X:" + x + " Y:" + y);
                    }
//                    if (a.contains("r")) {
//                        objects[x][y] = new Helper();
>>>>>>> ccf236cd260d0405133529bcbb3b8518c43db554
//                    }
                }
            }

        }
    }

    private void closeFile() {
        map.close();
    }    
}
