package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.api.BlockHitbox;

/**
 * Class representing the hitbox entity of a Block.
 * 
 * @author Giacomo Grassetti
 */

public class BlockHitboxImpl implements BlockHitbox {

    private Rectangle shape;

    /**
     * Constructor for the BlockHitboxImpl class that takes in a
     * Point2D object
     * representing the position of the block and two double values representing
     * the width and height
     * of the block. It creates a new Rectangle object with the given position,
     * width, and height,
     * and assigns it to the shape field of the BlockHitboxImpl instance.
     * 
     * @param pos    position of hitbox (x, y)
     * @param width  hitbox width
     * @param height hitbox height
     */

    public BlockHitboxImpl(Point2D pos, double width, double height) {
        this.shape = new Rectangle(pos.getX(), pos.getY(), width, height);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public boolean checkCollision(Shape otherHitbox) {
        if (this.shape.getBoundsInParent().intersects(otherHitbox.getBoundsInParent())) {
            return true;
        }
        return false;
    }

}
