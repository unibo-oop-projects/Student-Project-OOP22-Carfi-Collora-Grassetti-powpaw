package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.api.WeaponHitbox;

/**
 * Class that implements the WeaponHitbox interface and provides methods for
 * creating
 * and updating a rectangular hitbox for a weapon in a game, as well as checking
 * for collisions with
 * other hitboxes.
 * 
 * @author Giacomo Grassetti
 */
public class WeaponHitboxImpl implements WeaponHitbox {
    private Rectangle shape;

    /**
     * Constructor for the WeaponHitboxImpl that creates a new Rectangle object with
     * the given position, width and height.
     * 
     * @param pos
     * @param width
     * @param height
     */
    public WeaponHitboxImpl(Point2D pos, double width, double height) {
        this.shape = new Rectangle(pos.getX(), pos.getY(), width, height);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void updateCenter(Point2D position) {
        this.shape.setX(position.getX());
        this.shape.setY(position.getY());
    }

    @Override
    public boolean checkCollision(Shape otherHitbox) {
        if (this.shape.getBoundsInParent().intersects(otherHitbox.getBoundsInParent())) {
            return true;
        }
        return false;
    }

}
