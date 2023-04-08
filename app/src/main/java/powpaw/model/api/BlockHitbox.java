package powpaw.model.api;

import javafx.scene.shape.Shape;

public interface BlockHitbox {

    Shape getShape();

    boolean checkCollision(Shape otherHitbox);

}