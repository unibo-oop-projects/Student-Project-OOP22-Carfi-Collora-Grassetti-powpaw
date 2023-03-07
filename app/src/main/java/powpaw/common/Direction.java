package powpaw.common;

public enum Direction {
    RIGHT(1.0, 0.0),
    LEFT(-1.0, 0.0),
    UP(0.0, -1.0),
    DOWN(0.0, 1.0);

    private final double x;
    private final double y;

    Direction(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
