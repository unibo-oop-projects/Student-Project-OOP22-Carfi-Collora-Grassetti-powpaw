package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;

public interface Player {

    Point2D getPosition();

    Point2D getVelocity();

    void moveLeft();

    void moveRight();

    void jump();

    void attack();

    double getAttackPower();

    double getCurrentHealth();

    void update(Duration deltaTime);
}
