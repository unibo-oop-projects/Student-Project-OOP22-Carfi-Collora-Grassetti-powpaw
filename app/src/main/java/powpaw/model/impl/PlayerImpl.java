package powpaw.model.impl;

import java.time.Duration;
import java.util.Optional;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.StaticStats;
import powpaw.model.api.DamageMeter;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;
import powpaw.model.api.Weapon;

/**
 * The {@code PlayerImpl} class implements the {@code Player} interface and
 * represents a player object in game.
 * 
 * It contains information about the player's state, position, direction,
 * health, and hitbox.
 * 
 * @author Alessia Carfì, Giacomo Grassetti, Simone Collorà
 */

public class PlayerImpl implements Player {

    /**
     * Enumerated type representing the various states of the player.
     * IDLE - Player is not doing anything
     * JUMP - Player is jumping
     * DODGE - Player is dodging
     * ATTACK - Player is attacking
     * WALK_RIGHT - Player is moving to the right
     * WALK_LEFT - Player is moving to the left
     * HIT - Player is hit
     */
    public enum PlayerState {
        IDLE, JUMP, DODGE, ATTACK, WALK_RIGHT, WALK_LEFT, HIT;
    }

    private static final double JUMP_SPEED = 0.8;
    private static final double JUMP_TIME = 0.4;
    private static final double DODGE_TIME = 0.5;
    private static final double GRAVITY = 0.5;

    private TransitionImpl transition;

    private Optional<Weapon> weapon;

    private PlayerState currentState;
    private PlayerState directionState;

    private Point2D position;
    private Point2D direction;
    private Point2D directionDeath;

    private int number;
    private double width;
    private double height;
    private double knockback = 1;
    private DamageMeter currentHealth;
    private PlayerStats stats;
    private Hitbox hitbox;

    private boolean isJumping = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isAttacking = false;
    private boolean isHit = false;
    private boolean isDodging = false;
    private boolean canMove = true;
    private Timeline jumpTimeline = new Timeline(
            new KeyFrame(javafx.util.Duration.seconds(JUMP_TIME), event -> {
                this.isJumping = false;
            }));
    private Timeline dodgeTimeline = new Timeline(
            new KeyFrame(javafx.util.Duration.seconds(DODGE_TIME), event -> {
                canMove = true;
                this.currentState = PlayerState.IDLE;
            }));

    /**
     * Constructs a new {@code PlayerImpl} object with the specified position and
     * number.
     * 
     * @param position the initial position of the player
     * @param number   the number of the player
     */
    public PlayerImpl(Point2D position, int number) {
        this.transition = new TransitionImpl();
        this.position = position;
        this.number = number;
        this.height = ScreenController.SIZE_HD_H / 8;
        this.width = ScreenController.SIZE_HD_W / 15;
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        this.currentState = PlayerState.IDLE;
        this.idle();
        this.stats = number == 1 ? StaticStats.getStatsP1() : StaticStats.getStatsP2();
        this.directionState = number == 1 ? PlayerState.WALK_RIGHT : PlayerState.WALK_LEFT;
        this.currentHealth = new DamageMeterImpl();
        this.weapon = Optional.empty();
    }

    @Override
    public Optional<Weapon> getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(Optional<Weapon> weapon) {
        this.weapon = weapon;
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
    public Rectangle getArmHitbox() {
        return this.hitbox.getArmShape();
    }

    @Override
    public void increaseArmHitbox() {
        getArmHitbox().setWidth(getHitbox().getOffsetX() + getHitbox().getOffsetX() / 2);
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
    public void setCurrentState(PlayerState state) {
        this.currentState = state;
    }

    @Override
    public PlayerState getDirectionState() {
        return this.directionState;
    }

    @Override
    public PlayerStats getPlayerStats() {
        return this.stats;
    }

    @Override
    public DamageMeter getCurrentHealth() {
        return this.currentHealth;
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
    public void setIsAttacking(boolean b) {
        this.isAttacking = b;
    }

    @Override
    public void setIsHit(boolean b) {
        this.isHit = b;
    }

    @Override
    public void setIsDodging(boolean b) {
        this.isDodging = b;
    }

    /**
     * Moves the player to the left.
     */
    private void moveLeft() {
        this.currentState = PlayerState.WALK_LEFT;
        this.directionState = PlayerState.WALK_LEFT;
        this.direction = direction.add(DirectionVector.LEFT.getPoint());
    }

    /**
     * Moves the player to the right.
     */
    private void moveRight() {
        this.currentState = PlayerState.WALK_RIGHT;
        this.directionState = PlayerState.WALK_RIGHT;
        this.direction = direction.add(DirectionVector.RIGHT.getPoint());
    }

    /**
     * Makes the player character jump.
     */
    private void jump() {
        this.currentState = PlayerState.JUMP;
        this.direction = this.direction.add(DirectionVector.UP.getPoint());
        jumpTimeline.play();
    }

    /**
     * Sets the player's state to "ATTACK".
     */
    private void attack() {
        this.currentState = PlayerState.ATTACK;
    }

    /**
     * Sets the player's state to "DODGE" and makes the player unable to move.
     */
    private void dodge() {
        canMove = false;
        this.currentState = PlayerState.DODGE;
        dodgeTimeline.play();
    }

    @Override
    public void idle() {
        this.direction = new Point2D(0, 0);
    }

    @Override
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
        currentHealth.setDamage(damage);
        this.knockback += currentHealth.getDamage();
    }

    @Override
    public void update(Duration deltaTime) {
        this.idle();
        if (isFalling() && !isJumping) {
            this.direction = this.direction.add(DirectionVector.DOWN.getPoint());
            jumpTimeline.stop();
        }
        if (canMove) {
            if (this.isJumping) {
                this.jump();
            }
            if (this.isMovingLeft) {
                this.moveLeft();
            }
            if (this.isMovingRight) {
                this.moveRight();
            }
            if (this.isAttacking) {
                this.attack();
            }
            if (this.isDodging) {
                this.dodge();
            }
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
