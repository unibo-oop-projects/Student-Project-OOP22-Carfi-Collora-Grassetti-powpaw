package powpaw.model.impl;

import java.time.Duration;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    public enum PlayerState {
        IDLE, JUMP, DODGE, ATTACK, WALK_RIGHT, WALK_LEFT;
    }

    private static final double SPEED = 0.3;
    private static final double JUMP_SPEED = 1.7;
    private static final int MAX_JUMP = 3;
    private static final double KNOCKBACK = 0.2;
    private static final double GRAVITY = 1.3;

    private TransitionImpl transition;

    private PlayerState currentState;

    private Point2D position;
    private Point2D velocity;
    private Point2D acceleration;

    private int number;
    private int jumpTime = 0;
    private double width;
    private double height;
    private int countJump = 0;
    private double attackPower;
    private int currentHealth;
    private PlayerHitboxImpl hitbox;

    public PlayerImpl(Point2D position, int number) {
        this.transition = new TransitionImpl();
        this.position = position;
        this.number = number;
        // this.attackPower = 0.25;
        this.height = ScreenController.SIZE_HD_H / 15;
        this.width = ScreenController.SIZE_HD_W / 25;
        this.hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        this.currentState = PlayerState.IDLE;
        this.idle();
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
    public Point2D getVelocity() {
        return this.velocity;
    }

    @Override
    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public Point2D getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(Point2D acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public Shape getFeetBox() {
        return this.hitbox.getFeetShape();
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
        this.currentState = PlayerState.WALK_LEFT;
        this.velocity = velocity.add(DirectionVector.LEFT.getPoint()).normalize();
    }

    @Override
    public void moveRight() {
        this.currentState = PlayerState.WALK_RIGHT;
        this.velocity = velocity.add(DirectionVector.RIGHT.getPoint()).normalize();
    }

    @Override
    public void jump() {
        jumpTime++;
        if (jumpTime > 5) {
            this.currentState = PlayerState.IDLE;
            jumpTime = 0;
        }
        if (this.countJump < MAX_JUMP) {
            doJump();
        }
    }

    private void doJump() {
        if (this.currentState != PlayerState.JUMP) {
            this.currentState = PlayerState.JUMP;
            this.countJump++;
            this.velocity = this.velocity.add(DirectionVector.UP.multiply(JUMP_SPEED)).normalize();
            this.currentState = PlayerState.IDLE;
        }
    }

    @Override
    public void idle() {
        this.currentState = PlayerState.IDLE;
        this.velocity = new Point2D(0, 0);
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

    private boolean isFalling() {
        if (transition.checkPlayerInTerrain(hitbox.getFeetShape())) {
            this.countJump = 0;
            return false;
        }
        return true;
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
        if (isFalling()) {
            this.position = new Point2D(this.position.getX(), this.position.add(DirectionVector.DOWN.multiply(GRAVITY)).getY());
        }
        position = position.add(velocity.multiply(deltaTime.toMillis()).multiply(SPEED));
        hitbox.updateCenter(position);
    }

}
