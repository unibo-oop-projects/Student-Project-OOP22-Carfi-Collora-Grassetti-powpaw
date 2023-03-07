package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;

public interface Player {

    Point2D getPosition();

    void getVelocity();

    double getWidth();

    double getHeight();

    void moveLeft();

    void moveRight();

    void jump();

    void attack();

    int getAttackPower();

    int getMaxHealth();

    int getCurrentHealth();
}
