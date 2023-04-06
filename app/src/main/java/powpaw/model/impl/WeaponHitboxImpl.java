package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class WeaponHitboxImpl {
    private double offsetX;
    private double offsetY;
    private Rectangle shape;

    public WeaponHitboxImpl(Point2D pos, double width, double height) {
        this.shape = new Rectangle(pos.getX(), pos.getY(), width, height);
        this.offsetX = width / 2;
        this.offsetY = height / 2;
    }

    public double getRadius() {
        return this.shape.getWidth() / 2;
    }

    public Point2D getCenter() {
        return new Point2D(this.shape.getWidth() / 2, this.shape.getHeight() / 2);
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setOffsetX(double width) {
        this.offsetX = this.shape.getWidth() / 2;
    }

    public void setOffsetY(double height) {
        this.offsetY = this.shape.getHeight() / 2;
    }

    public void switchDodge() {
        return;
    }

    public void updateCenter(Point2D position) {
        this.shape.setX(position.getX() + offsetX);
        this.shape.setY(position.getY() + offsetY);
    }

    public boolean checkCollision(Shape otherHitbox) {
        if (this.shape.getBoundsInParent().intersects(otherHitbox.getBoundsInParent())) {
            return true;
        }
        return false;
    }

}
