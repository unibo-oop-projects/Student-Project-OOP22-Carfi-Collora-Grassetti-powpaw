package powpaw.model.impl;

import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.StatsHandler;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    public enum PlayerState {
        IDLE, JUMP, DODGE, ATTACK, WALK_RIGHT, WALK_LEFT, HIT;
    }

    private static final double JUMP_SPEED = 0.8;
    private static final double JUMP_TIME = 0.4;
    private static final double GRAVITY = 0.5;

    private TransitionImpl transition;

    private PlayerState currentState;

    private Point2D position;
    private Point2D direction;
    private Point2D directionDeath;

    private int number;
    private double width;
    private double height;
    private double attackPower;
    private double knockback = 1;
    private double currentHealth = 0.5;
    private PlayerStats stats;
    private Hitbox hitbox;

    private boolean isJumping = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isHit = false;
    private Timeline timeline = new Timeline(
            new KeyFrame(javafx.util.Duration.seconds(JUMP_TIME), event -> {
                this.isJumping = false;
            }));

    public PlayerImpl(Point2D position, int number) {
        this.transition = new TransitionImpl();
        this.position = position;
        this.number = number;
        this.height = ScreenController.SIZE_HD_H / 8;
        this.width = ScreenController.SIZE_HD_W / 15;
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        this.currentState = PlayerState.IDLE;
        this.idle();
        this.stats = number == 1 ? StatsHandler.getStatsP1() : StatsHandler.getStatsP2();
        // this.directionDeath = new Point2D(0, 0);
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public Point2D getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    @Override
    public Shape getFeetBox() {
        return this.hitbox.getFeetShape();
    }

    @Override
    public Rectangle getArmHitbox() {
        return this.hitbox.getArmShape();
    }

    @Override
    public void increaseArmHitbox() {
        getArmHitbox().setWidth(getHitbox().getOffsetX() + getHitbox().getOffsetX()/2);
    }

    @Override
    public void reduceArmHitbox() {
        getArmHitbox().setWidth(getHitbox().getOffsetX());
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
    public PlayerState getState() {
        return this.currentState;
    }

    @Override
    public PlayerStats getPlayerStats() {
        return this.stats;
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
    public void setIsJumping(boolean b) {
        this.isJumping = b;
    }

    @Override
    public void setIsMovingLeft(boolean b) {
        this.isMovingLeft = b;
    }

    @Override
    public void setIsMovingRight(boolean b) {
        this.isMovingRight = b;
    }

    @Override
    public void setIsHit(boolean b) {
        this.isHit = b;
    }

    private void moveLeft() {
        this.currentState = PlayerState.WALK_LEFT;
        this.direction = direction.add(DirectionVector.LEFT.getPoint());
    }

    private void moveRight() {
        this.currentState = PlayerState.WALK_RIGHT;
        this.direction = direction.add(DirectionVector.RIGHT.getPoint());
    }

    private void jump() {
        this.currentState = PlayerState.JUMP;
        this.direction = this.direction.add(DirectionVector.UP.getPoint());
    }

    @Override
    public void idle() {
        this.currentState = PlayerState.IDLE;
        this.direction = new Point2D(0, 0);
    }

    @Override
    public void dodge() {
        hitbox.switchDodge();
        this.currentState = PlayerState.DODGE;
        try {
            Thread.sleep(Duration.ofMillis(1).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hitbox.switchDodge();
    }

    public boolean isFalling() {
        return !transition.checkPlayerInTerrain(hitbox.getFeetShape());
    }

    @Override
    public void setDirectionDeath(Point2D direction) {
        this.directionDeath = direction;
    }

    @Override
    public void receiveAttack(Point2D direction, double damage) {
        this.currentState = PlayerState.HIT;
        isHit = true;
        this.directionDeath = direction;
        this.knockback += currentHealth;
    }

    @Override
    public void update(Duration deltaTime) {
        this.idle();

        if (isFalling() && !isJumping) {
            this.direction = this.direction.add(DirectionVector.DOWN.getPoint());
            timeline.stop();
        }

        if (this.isJumping) {
            this.jump();
            timeline.play();
        }

        if (this.isMovingLeft) {
            this.moveLeft();
        }

        if (this.isMovingRight) {
            this.moveRight();
        }

        this.direction = this.direction.normalize();

        if (isHit) {
            this.position = this.position
                    .add(this.directionDeath.multiply(this.knockback).multiply(deltaTime.toMillis()));
            this.isHit = false;
        } else {
            this.position = this.position.add(new Point2D(this.direction.getX() * stats.getSpeed(),
                    this.direction.getY() * (isJumping ? JUMP_SPEED : GRAVITY)).multiply(deltaTime.toMillis()));
        }
        this.hitbox.updateCenter(this.position);
    }

}
