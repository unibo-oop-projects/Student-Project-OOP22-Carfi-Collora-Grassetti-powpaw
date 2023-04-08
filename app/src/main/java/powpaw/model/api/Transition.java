package powpaw.model.api;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface Transition {

    Point2D fallTransition(Point2D pos);

    boolean checkPlayerCollisionByHitbox(Hitbox hitbox);

    boolean checkPlayerInTerrain(Shape hitbox);
}
