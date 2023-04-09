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

    /**
     * Getter of the weapon hitbox shape .
     * 
     * @return The Shape of the weapon hitbox.
     */
    @Override
    public Shape getShape() {
        return this.shape;
    }

    /**
     * Method that updates the position of a shape to a new center point.
     * 
     * @param position A Point2D representing the new center position of the shape
     */
    @Override
    public void updateCenter(Point2D position) {
        this.shape.setX(position.getX());
        this.shape.setY(position.getY());
    }

    /**
     * Method that checks if the hitbox of one shape intersects with the weapon
     * hitbox.
     * 
     * @param otherHitbox Shape representing the hitbox of
     *                    another object to check for collision.
     * @return True if hitbox of the current shape intersects with the hitbox of the
     *         other shape passed.
     */
    @Override
    public boolean checkCollision(Shape otherHitbox) {
        if (this.shape.getBoundsInParent().intersects(otherHitbox.getBoundsInParent())) {
            return true;
        }
        return false;
    }

}
