package powpaw.model.api;

import javafx.geometry.Point2D;

public interface Block {

    Point2D getPosition();

    void setX(double x);

    void setY(double y);

    Hitbox getHitbox();

    double getWidth();

    void setWidth(double width);

    double getHeight();

    void setHeight(double height);
}
