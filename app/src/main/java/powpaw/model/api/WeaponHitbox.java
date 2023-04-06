package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface WeaponHitbox {

    Shape getShape();

    void setOffsetX(double width);

    void setOffsetY(double height);

    void updateCenter(Point2D position);

    boolean checkCollision(Shape otherHitbox);

}