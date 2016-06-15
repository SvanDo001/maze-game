/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.util.ArrayList;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public interface Moveable {

    public void move(int dx, int dy);

    public void moveTo(int dx, int dy);

    public ArrayList<Integer> getStepCounterTileX();

    public void setStepCounterTileX();

    public ArrayList<Integer> getStepCounterTileY();

    public void setStepCounterTileY();
}
