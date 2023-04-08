package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.api.WeaponHitbox;

public class WeaponHitboxImpl implements WeaponHitbox {
    private Rectangle shape;

    public WeaponHitboxImpl(Point2D pos, double width, double height) {
        this.shape = new Rectangle(pos.getX(), pos.getY(), width, height);
        shape.setFill(Color.BLACK);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void updateCenter(Point2D position) {
        this.shape.setX(position.getX());
        this.shape.setY(position.getY());
    }

    @Override
    public boolean checkCollision(Shape otherHitbox) {
        if (this.shape.getBoundsInParent().intersects(otherHitbox.getBoundsInParent())) {
            return true;
        }
        return false;
    }

}
