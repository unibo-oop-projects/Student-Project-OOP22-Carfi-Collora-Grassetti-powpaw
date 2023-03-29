package powpaw.model.impl;

import java.time.Duration;
import javafx.geometry.Point2D;
import powpaw.common.DirectionVector;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Player;

public class PlayerImpl implements Player {

    private static final double SPEED = 0.1;
    // private static final double KNOCKBACK = 0.2;
    private static final Point2D GRAVITY = new Point2D(0, 0.01);

    private TransitionFactory transition;
    private Point2D position;
    private Point2D velocity;
    private double width;
    private double height;
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
        this.velocity = velocity.add(DirectionVector.LEFT.getPoint());
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void moveRight() {
        this.velocity = velocity.add(DirectionVector.RIGHT.getPoint());
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void jump() {
        if(!isFalling()){
            for (int i=0; i<50; i++){
                this.position = this.position.add(DirectionVector.UP.getPoint());
            }
        }
        //this.velocity = velocity.add(DirectionVector.UP.getPoint());
        this.velocity = this.velocity.normalize();
    }

    @Override
    public void idle() {
        this.velocity = new Point2D(0, 0);
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
