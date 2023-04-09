package powpaw.model.impl;

import java.util.ArrayList;
import powpaw.model.api.Level;

/**
 * Class for the creation of the game map.
 * 
 * @author Giacomo Grassetti
 */

public class CreateMap {

    private ArrayList<BlockImpl> terrains = new ArrayList<>();

    /**
     * Constructor of CreateMap
     */
    public CreateMap() {
        createTerrains();
    }

    /**
     * The function creates terrains by iterating through a 2D matrix and adding
     * blocks to a list based
     * on the values in the matrix.
     */
    private void createTerrains() {
        for (int y = 0; y < Level.Level2.length; y++) {
            String row = Level.Level2[y];
            for (int x = 0; x < row.length(); x++) {
                switch (row.charAt(x)) {
                    case '0':
                        break;
                    case '1':
                        BlockImpl block = BlockFactory.createBlock(x, y);
                        terrains.add(block);
                        break;
                }
            }
        }

    }

    /**
     * Getter of terrains list.
     * 
     * @return An ArrayList of BlockImpl
     */
    public ArrayList<BlockImpl> getTerrains() {
        return terrains;
    }

}
