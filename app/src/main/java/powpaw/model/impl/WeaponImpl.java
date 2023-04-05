package powpaw.model.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Weapon;

public class WeaponImpl implements Weapon {

    
    public static double WIDTH = ScreenController.SIZE_HD_W / 50;
    public static double HEIGHT = ScreenController.SIZE_HD_H / 30;

    private Hitbox hitbox;
    private Point2D position;
    private double attack;
    private double speed;

    private final TransitionImpl transition = new TransitionImpl();

    public WeaponImpl(Point2D position) {
        this.position = position;
        this.hitbox = new WeaponHitboxImpl(position, WIDTH, HEIGHT);
    }

    @Override
    public Hitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setAttack(double attack){
        this.attack = attack;
    }

    @Override
    public void setSpeed(double speed){
        this.speed = speed;
    }
    @Override
    public void update() {
        this.position = transition.fallTransition(position);
        hitbox.updateCenter(position);
    }

}
