package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

/**
 * Interface of TransitionImpl class.
 * 
 * @author Giacomo Grassetti
 */
public interface Transition {

    /**
     * Method that checks collision and returns a new position if there is no
     * collision, otherwise
     * it returns the current position.
     * 
     * @param pos The current position of an object in a 2D coordinate system,
     *            represented by a Point2D
     *            object.
     * @return If there is no collision detected at the given position, returns a
     *         new
     *         position that is 2 units below the current position. If there is a
     *         collision, the method returns
     *         the current position without any changes.
     */
    Point2D fallTransition(Point2D pos);

    /**
     * This function checks if a given position collides with any of the terrain
     * blocks in a map.
     * 
     * @param pos pos is a Point2D object representing the position of a weapon in
     *            2D space. It
     *            contains the x and y coordinates of the weapon's position.
     * 
     * @return True if the given position intersect the terrains, false otherwise
     */
    boolean checkPlayerCollisionByHitbox(Hitbox hitbox);

    /**
     * This function checks if a player is within the boundaries of a terrain block
     * in a game map.
     * 
     * @param feetBox A Shape object representing the hitbox of the player's feet.
     * @return True if player feet intersect with terrains, false otherwise.
     */
    boolean checkPlayerInTerrain(Shape hitbox);
}
