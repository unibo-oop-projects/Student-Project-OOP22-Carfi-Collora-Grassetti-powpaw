package powpaw.model.api;

import javafx.geometry.Point2D;
import powpaw.model.impl.BlockHitboxImpl;

public interface Block {

    Point2D getPosition();

    void setX(double x);

    void setY(double y);

    BlockHitboxImpl getHitbox();

    double getWidth();

    void setWidth(double width);

    double getHeight();

    void setHeight(double height);
}
