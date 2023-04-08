package powpaw.view.api;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import powpaw.model.impl.BlockImpl;

/**
 * Interface for MapRederImpl class that creates a pane and draws blocks on it using a ImagePattern.
 * 
 * @author Giacomo Grassetti
 */
public interface MapRender {

    /**
     * Method that creates a Pane and draws blocks on it.
     * 
     * @return A Pane object.
     */
    Pane createPane();

    /**
     * Getters for an ArrayList of BlockImpl representing terrains.
     * 
     * @return An ArrayList of BlockImpl
     */
    ArrayList<BlockImpl> getTerrains();

}