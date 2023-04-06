package powpaw.model.impl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Weapon;
import powpaw.model.api.WeaponHitbox;

public class WeaponImpl implements Weapon {

    public static double WIDTH = ScreenController.SIZE_HD_W / 50;
    public static double HEIGHT = ScreenController.SIZE_HD_H / 30;

    private WeaponHitbox hitbox;
    private Point2D position;
    private double attack;
    private double speed;
    private boolean isVisible = true;
    private int id;
    private int count = 10;

    private final TransitionImpl transition = new TransitionImpl();

    public WeaponImpl(Point2D position, int id) {
        this.position = position;
        this.hitbox = new WeaponHitboxImpl(position, WIDTH, HEIGHT);
        this.id = id;
    }

    @Override
    public WeaponHitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setAttack(double attack) {
        this.attack = attack;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void addAttack(PlayerStats ps) {
        double oldAttack = ps.getAttack();
        ps.setAttack(oldAttack + this.attack);
        System.out.println("WEAPON ATK PLUS: " + ps.getAttack());
        new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            ps.setAttack(oldAttack);
            System.out.println("WEAPON ATK: " + ps.getAttack());
        })).play();
    }

    @Override
    public void setVisible(boolean b) {
        this.isVisible = b;
        this.hitbox.getShape().setVisible(b);
    }

    @Override
    public boolean getIsVisible() {
        return this.isVisible;
    }

    @Override
    public void update() {
        this.position = transition.fallTransition(position);
        hitbox.updateCenter(position);
    }

}
