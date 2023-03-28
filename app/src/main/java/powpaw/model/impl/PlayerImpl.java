package powpaw.model.impl;

import java.time.Duration;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    private static final double SPEED = 0.1;
    private static final double KNOCKBACK = 0.2;
    // private static final Point2D GRAVITY = new Point2D(0, 0.001);

    private Point2D position;
    private Point2D velocity;
    private double width;
    private double height;
    private double attackPower;
    private int currentHealth;
    private Hitbox hitbox;

    public PlayerImpl(Point2D position) {
        this.position = position;
        this.attackPower = 0.25;
        this.height = ScreenController.SIZE_HD_W / 20;
        this.width = ScreenController.SIZE_HD_W / 20;
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        this.idle();
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public Point2D getVelocity() {
        return this.velocity;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public Hitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
        this.hitbox.setOffsetX(width);
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
        this.hitbox.setOffsetY(height);
    }

    @Override
    public void moveLeft() {
        this.velocity = velocity.add(DirectionVector.LEFT.multiply(SPEED));
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void moveRight() {
        this.velocity = velocity.add(DirectionVector.RIGHT.multiply(SPEED));
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void jump() {
        this.velocity = velocity.add(DirectionVector.UP.multiply(SPEED));
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void idle() {
        velocity = new Point2D(0, 0);
    }

    @Override
    public void dodge() {
        hitbox.switchDodge();
        try {
            Thread.sleep(Duration.ofMillis(1).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hitbox.switchDodge();
    }

    @Override
    public void attack() {
        currentHealth += KNOCKBACK * attackPower;
    }

    @Override
    public double getAttackPower() {
        return this.attackPower;
    }

    @Override
    public double getCurrentHealth() {
        return this.currentHealth;
    }

    @Override
    public void update(Duration deltaTime) {
        // velocity = velocity.add(GRAVITY);
        position = position.add(velocity.multiply(deltaTime.toMillis()));
        hitbox.updateCenter(position);
    }
}
