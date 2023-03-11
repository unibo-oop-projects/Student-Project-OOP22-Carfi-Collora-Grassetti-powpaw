package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;

public interface Player {

    Point2D getPosition();

    Point2D getVelocity();

    double getWidth();

    double getHeight();

    void setWidth(double width);

    void setHeight(double height);

    void moveLeft();

    void moveRight();

    void jump();

    void idle();

    void attack();

    double getAttackPower();

    double getCurrentHealth();

    Hitbox getHitbox();

    void update(Duration deltaTime);
}
