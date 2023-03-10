package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface Hitbox {

    double getRadius();

    Point2D getCenter();

    Shape getHitbox();

    void updateCenter(Point2D position, double width, double height);

    boolean checkCollision(Shape otherHitbox);
}
