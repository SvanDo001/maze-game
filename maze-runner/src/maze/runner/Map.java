/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Stefan
 */
public class Map
{
    private Scanner map;
    
    private String[] Map = new String[14];
    
    private Image grass, 
                  wall;
    
    public Map()
    {
        ImageIcon img = new ImageIcon("C://Users//Stefan//Documents//Sourcetree//maze-runner//Tiles//grass.png");
        grass = img.getImage();
        img = new ImageIcon("C://Users//Stefan//Documents//Sourcetree//maze-runner//Tiles//wall.png");
        wall = img.getImage();
        
        openFile();
        readFile();
        closeFile();
    }
    
    public Image getGrass()
    {
        return grass;
    }
    
    public Image getWall()
    {
        return wall;
    }
    
    public String getMap(int x, int y)
    {
        String index = Map[y].substring(x, x + 1);
        return index;
    }
    
    public void openFile()
    {
        try
        {
            map = new Scanner(new File("C://Users//Stefan//Documents//Sourcetree//maze-runner//Tiles////Map.txt"));
        }
        catch (Exception e)
        {
            System.out.println("Error loading map");
        }
    }
    
    public void readFile()
    {
        while(map.hasNext())
        {
            for (int i = 0; i < 14; i++)
            {
                Map[i] = map.next();
            }
            
        }
    }
    
    public void closeFile()
    {
        map.close();
    }
}
