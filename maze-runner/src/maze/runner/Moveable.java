package maze.runner;

import java.util.ArrayList;

/**
 * Moveable interface. Defines and declares move, moveTo and stepCounter 
 * methods.
 * 
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public interface Moveable {

    // move method with paramaters for the player to move to.
    void move(int dx, int dy);

    // moveTo method adjusts the parameter for the player in the ArrayLists.
    void moveTo(int dx, int dy);

    // stepCounter ArrayList that returns the last position of the player of TileX.
    ArrayList<Integer> getStepCounterTileX();

    // method that sets the StepCounter with the last position of player.
    void setStepCounterTileXY();

    // stepCounter ArrayList that returns the last position of the player of TileY.
    ArrayList<Integer> getStepCounterTileY();
}
