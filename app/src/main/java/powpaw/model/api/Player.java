package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;
import powpaw.model.impl.PlayerImpl.State;

public interface Player {

    Point2D getAcceleration();

    void setAcceleration(Point2D acceleration);

    void setState(State state);

    Point2D getPosition();

    Point2D getVelocity();

    void setVelocity(Point2D velocity);

    double getWidth();

    double getHeight();

    void setWidth(double width);

    void setHeight(double height);

    void moveLeft();

    void moveRight();

    void jump();

    boolean isPlayerJumping();

    void idle();

    // void attack();

    void dodge();

    // double getAttackPower();

    // double getCurrentHealth();

    Hitbox getHitbox();

    void update(Duration deltaTime);

}
