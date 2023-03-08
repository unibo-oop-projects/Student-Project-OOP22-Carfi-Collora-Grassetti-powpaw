package powpaw.model.impl;

import java.time.Duration;

import javafx.geometry.Point2D;
import powpaw.common.DirectionVector;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    private static final double SPEED = 10.0;
    private static final double KNOCKBACK = 0.2;
    private static final Point2D GRAVITY = new Point2D(0, 0.5);

    private Point2D position;
    private Point2D velocity;
    private double attackPower;
    private int currentHealth;

    public PlayerImpl(Point2D position) {
        this.position = position;
        this.attackPower = 0.25;
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
    public void moveLeft() {
        velocity = DirectionVector.LEFT.multiply(SPEED);
    }

    @Override
    public void moveRight() {
        velocity = DirectionVector.RIGHT.multiply(SPEED);
    }

    @Override
    public void jump() {
        velocity = DirectionVector.RIGHT.multiply(SPEED);
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
        Point2D oldPosition = new Point2D(position.getX(), position.getY());
        Point2D oldVelocity = new Point2D(velocity.getX(), velocity.getY());

        position = oldPosition.add(oldVelocity.multiply(deltaTime.toMillis()));
        velocity = oldVelocity.add(GRAVITY);
    }

}
