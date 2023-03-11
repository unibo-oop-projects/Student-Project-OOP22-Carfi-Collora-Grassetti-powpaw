package powpaw.model.impl;

import java.time.Duration;

import javafx.geometry.Point2D;
import powpaw.common.DirectionVector;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    private static final double SPEED = 10.0;
    private static final double KNOCKBACK = 0.2;
    private static final Point2D GRAVITY = new Point2D(0, 0.5);

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
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
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
        velocity = DirectionVector.LEFT.multiply(SPEED);
    }

    @Override
    public void moveRight() {
        velocity = DirectionVector.RIGHT.multiply(SPEED);
    }

    @Override
    public void jump() {
        velocity = DirectionVector.UP.multiply(SPEED);
    }

    @Override
    public void idle() {
        velocity = new Point2D(0, 0);
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
        position = position.add(velocity.multiply(deltaTime.toMillis()));
        velocity = velocity.add(GRAVITY);
        hitbox.updateCenter(position);
    }
}
