package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.api.Hitbox;

public class PlayerHitboxImpl implements Hitbox {

    private double radius;
    private double feetRadius;
    private double offsetX;
    private double offsetY;
    private double offsetFeet;
    private Circle hitbox;
    private Circle feetBox;
    private Rectangle armHitbox;

    public PlayerHitboxImpl(Point2D PlayerPosition, double width, double height) {
        this.radius = width / 2;
        this.feetRadius = this.radius / 3;
        this.offsetX = width / 2;
        this.offsetY = height / 2;
        this.offsetFeet = height - feetRadius;
        final double x = PlayerPosition.getX() + this.offsetX;
        final double y = PlayerPosition.getY() + this.offsetY;
        final double yFeet = PlayerPosition.getY() + this.offsetFeet;
        final double yArm = PlayerPosition.getY() + this.offsetY;
        this.hitbox = new Circle(x, y, this.radius);
        this.hitbox.setFill(Color.BEIGE); // debug
        this.armHitbox = new Rectangle(x, yArm, this.offsetX, this.offsetY / 2);
        this.armHitbox.setFill(Color.GREEN); // debug
        this.feetBox = new Circle(x, yFeet, this.feetRadius);
        this.feetBox.setFill(Color.RED); // debug
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public Point2D getCenter() {
        return new Point2D(this.hitbox.getCenterX(), this.hitbox.getCenterY());
    }

    @Override
    public Shape getShape() {
        return this.hitbox;
    }

    @Override
    public Shape getFeetShape() {
        return this.feetBox;
    }

    @Override
    public Rectangle getArmShape() {
        return this.armHitbox;
    }

    @Override
    public void setOffsetX(double width) {
        this.offsetX = width / 2;
    }

    @Override
    public double getOffsetX() {
        return this.offsetX;
    }

    @Override
    public double getOffsetY() {
        return this.offsetY;
    }

    @Override
    public void setOffsetY(double height) {
        this.offsetY = height / 2;
    }

    @Override
    public void updateCenter(Point2D position) {
        this.hitbox.setCenterX(position.getX() + offsetX);
        this.hitbox.setCenterY(position.getY() + offsetY);

        this.feetBox.setCenterX(position.getX() + offsetX);
        this.feetBox.setCenterY(position.getY() + offsetFeet);

        this.armHitbox.setX(position.getX() + offsetX);
        this.armHitbox.setY(position.getY() + offsetY);
    }

    @Override
    public boolean checkCollision(Shape otherHitbox) {
        return this.armHitbox.getBoundsInParent().intersects(otherHitbox.getBoundsInParent());
    }
}
