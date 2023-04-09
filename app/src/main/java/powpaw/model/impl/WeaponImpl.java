package powpaw.model.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Weapon;
import powpaw.model.api.WeaponHitbox;

/**
 * Class that implements the Weapon interface and defines the properties and methods of a
 * weapon object in a game.
 * 
 * @author Giacomo Grassetti
 */
public class WeaponImpl implements Weapon {

    public static double WIDTH = ScreenController.SIZE_HD_W / 50;
    public static double HEIGHT = ScreenController.SIZE_HD_H / 30;
    public static int MAX_DURABILITY = 10;
    

    private WeaponHitbox hitbox;
    private Point2D position;
    private double attack;
    private boolean isVisible = true;
    private int id;
    private int durability = MAX_DURABILITY;
    private boolean isPicked;

    private final TransitionImpl transition = new TransitionImpl();
 
    /**
     * Constructor for the WeaponImpl
     * 
     * @param position
     * @param id
     */
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
    public int getDurability() {
        return durability;
    }

    @Override
    public void decrementDurability(){
        this.durability--;
    }

    @Override
    public void resetDurability() {
        this.durability = MAX_DURABILITY;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isPicked() {
        return isPicked;
    }

    @Override
    public void setPicked(boolean isPicked) {
        this.isPicked = isPicked;
    }

    @Override
    public void addAttack(PlayerStats ps) {
        double oldAttack = ps.getAttack();
        ps.setAttack(oldAttack + this.attack);
        if(this.durability == 0) {
            ps.setAttack(oldAttack);
        }
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
