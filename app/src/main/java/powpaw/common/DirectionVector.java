package powpaw.common;

import javafx.geometry.Point2D;

/**
 * An enumeration representing a 2D direction vector in the four directions:
 * right, left, up, and down.
 * 
 * Each direction vector is represented as a {@code Point2D} object containing
 * the x and y components of the vector.
 * 
 * @author Alessia Carfì
 */
public enum DirectionVector {
    RIGHT(new Point2D(1.0, 0.0)),
    LEFT(new Point2D(-1.0, 0.0)),
    UP(new Point2D(0.0, -1.0)),
    DOWN(new Point2D(0.0, 1.0));

    private final Point2D point;

    /**
     * Constructs a new DirectionVector with the specified Point2D representation.
     * 
     * @param point the Point2D representation of the direction vector
     */
    DirectionVector(Point2D point) {
        this.point = point;
    }

    /**
     * Returns the Point2D representation of the direction vector.
     * 
     * @return the Point2D representation of the direction vector
     */
    public Point2D getPoint() {
        return this.point;
    }

    /**
     * Returns a new Point2D representing the scaled direction vector, where the x
     * and y components are multiplied by the specified factor.
     * 
     * @param factor the factor to scale the direction vector by
     * @return a new Point2D representing the scaled direction vector
     */
    public Point2D multiply(double factor) {
        return this.point.multiply(factor);
    }
}
