package powpaw.controller.api;

import java.util.ArrayList;

import powpaw.model.impl.BlockImpl;

/**
 * Interface for MapControllerImpl
 * 
 * @author Giacomo Grassetti
 */

public interface MapController {

    /**
     * Getter of map terrains
     * 
     * @return ArrayList<BlockImpl>
     */
    ArrayList<BlockImpl> getPlatforms();

}