package powpaw.model.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;

public class BlockImpl {

    private Hitbox hitbox;
    private Point2D position;
    public double width;
    public double height;

    public BlockImpl(Point2D pos, double width, double height) {
        this.position = new Point2D(pos.getX() * ScreenController.SIZE_HD_W / 30,
                pos.getY() * ScreenController.SIZE_HD_H / 10);
        this.hitbox = new BlockHitboxImpl(position, width * ScreenController.SIZE_HD_W / 30,
                height * ScreenController.SIZE_HD_H / 10);
    }

    public double getHeight() {
        return height;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setX(double x) {
        this.position = new Point2D(x, this.position.getY());
    }

    public void setY(double y) {
        this.position = new Point2D(this.position.getX(), y);
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
