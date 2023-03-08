package powpaw.common;

import javafx.geometry.Point2D;

public enum DirectionVector {
    RIGHT(new Point2D(1.0, 0.0)),
    LEFT(new Point2D(-1.0, 0.0)),
    UP(new Point2D(0.0, -1.0)),
    DOWN(new Point2D(0.0, 1.0));

    private final Point2D point;

    DirectionVector(Point2D point) {
        this.point = point;
    }

    public Point2D getPoint() {
        return this.point;
    }

    public Point2D multiply(double factor) {
        return this.point.multiply(factor);
    }
}
