package powpaw.model.impl;

import java.time.Duration;
import javafx.geometry.Point2D;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    public enum PlayerState {
        IDLE, JUMP, DODGE, ATTACK, WALK_RIGHT, WALK_LEFT;
    }

    private static final long LONG_JUMP_PRESS   = 150l;
    private static final double JUMP_SPEED = 0.6;
    private static final double SPEED = 0.3;
    private static final double JUMP_HEIGHT = 50;
    private static final int MAX_JUMP = 3;

    public boolean jumpingPressed = false;
    
    public boolean isJumpingPressed() {
        return jumpingPressed;
    }

    public void setJumpingPressed(boolean jumpingPressed) {
        this.jumpingPressed = jumpingPressed;
    }

    double jumpPositionY;

    private static final double KNOCKBACK = 0.2;
    private static final Point2D GRAVITY = new Point2D(0, 0.1);

    private TransitionImpl transition;

    private PlayerState currentState;

    private Point2D position;
    private Point2D velocity;
    private Point2D acceleration;

    private double width;
    private double height;
    private int countJump = 0;
    private double attackPower;
    private int currentHealth;
    private Hitbox hitbox;

    public PlayerImpl(Point2D position) {
        this.transition = new TransitionImpl();
        this.position = position;
        this.currentHealth = 0;
        this.attackPower = 0.25;
        this.height = ScreenController.SIZE_HD_W / 20;
        this.width = ScreenController.SIZE_HD_W / 20;
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        jumpPositionY = this.position.getY() - JUMP_HEIGHT;
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
        this.velocity = velocity.add(DirectionVector.LEFT.getPoint());
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void moveRight() {
        this.currentState = PlayerState.WALK_RIGHT;
        this.velocity = velocity.add(DirectionVector.RIGHT.getPoint());
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void jump() {
        if ((!isFalling() && this.countJump < MAX_JUMP)
                || (isFalling() && this.countJump < MAX_JUMP)) {
            doJump();
        }
        //this.velocity = this.velocity.normalize();
    }

    private void doJump() {
        
        this.currentState = PlayerState.JUMP;
        this.velocity = velocity.add(DirectionVector.UP.getPoint()).normalize();
        /*else {
             if (jumpingPressed  && ((System.currentTimeMillis() - jumpPressedTime) >= LONG_JUMP_PRESS )) {
                jumpingPressed = false;
                System.out.println("ALREADY NOT"); 
            } else { 
                if (jumpingPressed) {
                    System.out.println("ALREADY YES");
                    this.velocity = velocity.add(DirectionVector.UP.getPoint()).normalize();
                }
            }*/
        

        /*
        //this.velocity = velocity.add(DirectionVector.UP.getPoint()).normalize();
        this.countJump++;
        double jumpPositionY = this.position.getY() - JUMP_HEIGHT;
        if(this.position.getY() > jumpPositionY){
            System.out.println("");
            this.velocity = velocity.add(DirectionVector.UP.getPoint()).normalize();
            //this.position = this.position.add(velocity.multiply(deltaTime.toMillis()).multiply(0.1));
        }
        */
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
        if (transition.checkPlayerCollisionByHitbox(hitbox)) {
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
        
        System.out.println(this.jumpingPressed);
        if (isFalling()) {
            this.position = new Point2D(this.position.getX(),
                this.position.add(DirectionVector.DOWN.getPoint()).add(GRAVITY).getY());
        }
        /* if(this.position.getY() >= jumpPositionY){
            this.position = this.position.add(0, velocity.getY());
            jumpingPressed = false;
        }else{
            jumpingPressed = true;
        } */
      
       
        position = position.add(velocity.multiply(deltaTime.toMillis()).multiply(SPEED));
        hitbox.updateCenter(position);
    }


}
