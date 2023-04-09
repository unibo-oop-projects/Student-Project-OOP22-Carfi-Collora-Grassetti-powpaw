package powpaw.model.impl;

import javafx.geometry.Point2D;

/**
 * Static class for the creation of different Blocks
 * 
 * @author Giacomo Grassetti
 */

public class BlockFactory {

    /**
     * The function creates a new block with a specified position and size and
     * returns it.
     * 
     * @param x The x-coordinate of the top-left corner of the block.
     * @param y The "y" parameter in the "createBlock" method represents the
     *          vertical position of the
     *          block being created on the coordinate plane.
     * @return An instance of the BlockImpl class
     */
    public static BlockImpl createBlock(double x, double y) {
        BlockImpl block = new BlockImpl(new Point2D(x, y), 1, 1);
        return block;
    }

}
