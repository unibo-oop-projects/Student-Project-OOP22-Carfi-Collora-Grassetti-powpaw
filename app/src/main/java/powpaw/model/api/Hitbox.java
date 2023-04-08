package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public interface Hitbox {

    double getRadius();

    Point2D getCenter();

    Shape getShape();

    void setOffsetX(double width);

    double getOffsetX();

    double getOffsetY();

    void setOffsetY(double height);

    void updateCenter(Point2D position);

    boolean checkCollision(Shape otherHitbox);

    Shape getFeetShape();

    Rectangle getArmShape();
}
