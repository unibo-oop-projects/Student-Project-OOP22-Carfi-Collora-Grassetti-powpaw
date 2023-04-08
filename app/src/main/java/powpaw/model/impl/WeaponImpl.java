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

    /**
     * Getter of the hitbox of a weapon.
     * 
     * @return The weapon hitbox (WeaponHitbox)
     */
    @Override
    public WeaponHitbox getHitbox() {
        return this.hitbox;
    }

    /**
     * Getter of the position of a weapon.
     * 
     * @return The weapon position (Point2D)
     */
    @Override
    public Point2D getPosition() {
        return this.position;
    }

    /**
     * Getter of the attack of a weapon.
     * 
     * @return The weapon attack (double)
     */
    @Override
    public void setAttack(double attack) {
        this.attack = attack;
    }

    /**
     * Getter of the durability of a weapon.
     * 
     * @return The weapon durability (int)
     */
    @Override
    public int getDurability() {
        return durability;
    }


    /**
     * Method that decrements the durability of an object by one.
     */
    @Override
    public void decrementDurability(){
        this.durability--;
    }

    /**
     * Method that reset the durability of an object to its maximum value.
     */
    @Override
    public void resetDurability() {
        this.durability = MAX_DURABILITY;
    }


    /**
     * Getter for the ID of an object.
     * 
     * @return The weapon id (int)
     */
    @Override
    public int getId() {
        return this.id;
    }

   /**
    * Method that check id a weapon has been picked or not.
    * 
    * @return True if the weapon has been picked, false otherwise
    */
    @Override
    public boolean isPicked() {
        return isPicked;
    }

   /**
    * Setter for the value isPicked.
    * 
    * @param isPicked boolean that set the property isPicked
    */
    @Override
    public void setPicked(boolean isPicked) {
        this.isPicked = isPicked;
    }

    /**
     * Method that adds the attack value of a weapon to a player's stats and decreases the weapon's
     * durability, resetting the attack value if the durability reaches zero.
     * 
     * @param ps PlayerStats that contains the statistics of the player
     */
    @Override
    public void addAttack(PlayerStats ps) {
        double oldAttack = ps.getAttack();
        ps.setAttack(oldAttack + this.attack);
        System.out.println("WEAPON ATK PLUS: " + ps.getAttack());
        if(this.durability == 0) {
            ps.setAttack(oldAttack);
        }
    }

    /**
     * Setter for the visibility of a shape and updates a boolean flag accordingly.
     * 
     * @param b boolean value indicating whether the object should be visible or not.
     */
    @Override
    public void setVisible(boolean b) {
        this.isVisible = b;
        this.hitbox.getShape().setVisible(b);
    }

    /**
     * This function returns the value of the boolean variable "isVisible".
     * 
     * @return The method is returning a boolean value, specifically the value of the instance variable
     * `isVisible`.
     */
    @Override
    public boolean getIsVisible() {
        return this.isVisible;
    }

    /**
     * The update function updates the position and hitbox of a weapont using a fall transition (TransitionImpl).
     */
    @Override
    public void update() {
        this.position = transition.fallTransition(position);
        hitbox.updateCenter(position);
    }

}
