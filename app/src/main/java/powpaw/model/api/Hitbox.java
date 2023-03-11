package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface Hitbox {

    double getRadius();

    Point2D getCenter();

    Shape getHitbox();

    void setOffsetX(double width);

    void setOffsetY(double height);

    void updateCenter(Point2D position);

    boolean checkCollision(Shape otherHitbox);
}
