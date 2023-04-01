package powpaw.model.api;

import javafx.geometry.Point2D;

public interface Transition {

    Point2D fallTransition(Point2D pos);

    boolean checkPlayerCollisionByHitbox(Hitbox hitbox);
}
