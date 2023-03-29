package powpaw.model.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;

public class WeaponImpl {

    private Hitbox hitbox;
    private Point2D position;
    public static double WIDTH = ScreenController.SIZE_HD_W / 50;
    public static double HEIGHT = ScreenController.SIZE_HD_H / 30;
    private final TransitionFactory transition = new TransitionFactory();

    public WeaponImpl(Point2D position) {
        this.position = position;
        this.hitbox = new WeaponHitboxImpl(position, WIDTH, HEIGHT);
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void update() {
        this.position = transition.fallTransition(position);
        hitbox.updateCenter(position);
    }

}
