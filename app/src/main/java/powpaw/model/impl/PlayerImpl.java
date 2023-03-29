package powpaw.model.impl;

import java.time.Duration;
import javafx.geometry.Point2D;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    public enum State {
        IDLE, WALKING, JUMPING, DYING
    }

    public static final double SPEED = 0.5;
    // private static final double KNOCKBACK = 0.2;
    private static final Point2D GRAVITY = new Point2D(0, 0.01);

    private TransitionFactory transition;
    private Point2D position;
    private Point2D velocity;
    private double width;
    private double height;
    
    private static final double MAX_JUMP_SPEED = 0.7;
    private Point2D acceleration = new Point2D(0,0);
    private State currentState;
    int jumpCount = 0;
    boolean isJumping = false;
    // private double attackPower;
    // private int currentHealth;
    private Hitbox hitbox;

    public PlayerImpl(Point2D position) {
        this.transition = new TransitionFactory();
        this.position = position;
        // this.attackPower = 0.25;
        this.height = ScreenController.SIZE_HD_W / 20;
        this.width = ScreenController.SIZE_HD_W / 20;
        hitbox = new PlayerHitboxImpl(this.position, this.width, this.height);
        this.idle();
    }

    @Override
    public Point2D getAcceleration() {
        return acceleration;
    }

    @Override
    public void setAcceleration(Point2D acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void setState(State state){
        this.currentState = state;
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
        this.currentState = State.WALKING;
        setVelocity(new Point2D(-SPEED,this.velocity.getY()));
        /* this.velocity = velocity.add(DirectionVector.LEFT.getPoint());
        this.velocity = this.velocity.normalize(); */
    }

    @Override
    public void moveRight() {
        this.currentState = State.WALKING;
        setVelocity(new Point2D(SPEED,this.velocity.getY()));
        /* this.velocity = velocity.add(DirectionVector.RIGHT.getPoint());
        this.velocity = this.velocity.normalize(); */
    }

    @Override
    public void jump() {
        if(this.currentState.equals(State.JUMPING)){
            return;
        }
        if(!isFalling()){
            this.isJumping = true;
            this.setState(State.JUMPING);
            this.setVelocity(new Point2D(this.velocity.getX(), -MAX_JUMP_SPEED));
        }

        /*this.velocity = velocity.add(DirectionVector.UP.getPoint());
        this.velocity = this.velocity.normalize();*/    
    }

    @Override
    public void idle() {
        this.isJumping = false;
        this.currentState = State.IDLE; 
        this.velocity = new Point2D(0, 0);
        
    }

    @Override
    public boolean isPlayerJumping(){
        return this.isJumping;
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

    private boolean isFalling(){
        if(transition.checkPlayerCollisionByHitbox(hitbox)){
            isJumping = false;
            return false;
        }
        return true;
    }
    // @Override
    // public void attack() {
    // currentHealth += KNOCKBACK * attackPower;
    // }

    // @Override
    // public double getAttackPower() {
    // return this.attackPower;
    // }

    // @Override
    // public double getCurrentHealth() {
    // return this.currentHealth;
    // }

    @Override
    public void update(Duration deltaTime) {
        if(isFalling()){
            this.position = new Point2D(this.position.getX(), this.position.add(DirectionVector.DOWN.getPoint()).add(GRAVITY).getY());
            //this.velocity = DirectionVector.DOWN.getPoint().add(GRAVITY);
        }
        position = position.add(velocity.multiply(deltaTime.toMillis()).multiply(SPEED)); 
        hitbox.updateCenter(position); 
        ScreenController.isOutOfScreen(hitbox);


    }

}
