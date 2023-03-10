package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import powpaw.model.api.Hitbox;

public class PlayerHitboxImpl implements Hitbox {

    private double radius;
    private Shape hitbox;
    private Point2D center;

    public PlayerHitboxImpl(Point2D PlayerPosition, double width, double height) {
        this.radius = width / 2;
        this.center = new Point2D(PlayerPosition.getX() + width / 2,
                PlayerPosition.getY() + height / 2);
        this.hitbox = new Circle(this.radius, this.center.getX(), this.center.getY());
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public Point2D getCenter() {
        return this.center;
    }

    @Override
    public Shape getHitbox() {
        return this.hitbox;
    }

    @Override
    public void updateCenter(Point2D position, double width, double height) {
        ((Circle) this.hitbox).setCenterX(position.getX() + width / 2);
        ((Circle) this.hitbox).setCenterY(position.getY() + height / 2);
    }

    @Override
    public boolean checkCollision(Shape otherHitbox) {
        return this.hitbox.getBoundsInParent().intersects(otherHitbox.getBoundsInParent());
    }

}
