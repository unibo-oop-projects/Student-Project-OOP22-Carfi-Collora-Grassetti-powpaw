package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.PlayerImpl.PlayerState;

public interface Player {

    Point2D getPosition();

    Point2D getVelocity();

    void setVelocity(Point2D velocity);

    double getWidth();

    double getHeight();

    int getNumber();

    Shape getFeetBox();

    Rectangle getArmHitbox();

    PlayerState getState();

    PlayerStats getPlayerStats();

    void setWidth(double width);

    void setHeight(double height);

    void moveLeft();

    void moveRight();

    void jump();

    void idle();

    void dodge();

    Hitbox getHitbox();

    void update(Duration deltaTime);

}
