package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.api.Weapon;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.WeaponImpl;
import powpaw.view.api.WeaponRender;

/**
 * Class that implement WeaponRender interface and is responsible for rendering
 * the weapon sprite image based on the current
 * weapon and its position.
 * 
 * @author Giacomo Grassetti
 */
public class WeaponRenderImpl implements WeaponRender {

    private Weapon weapon;
    private ArrayList<BlockImpl> terrains;
    private Image image;
    private ImageView weaponSprite = new ImageView();

    /**
     * Setter for the terrains.
     * 
     * @param terrains An ArrayList of BlockImpl representing the terrains in a
     *                 game.
     */
    @Override
    public void setTerrains(ArrayList<BlockImpl> terrains) {
        this.terrains = terrains;
    }

    /**
     * Getter for an ArrayList of BlockImpl representing terrains.
     * 
     * @return An ArrayList of BlockImpl
     */
    @Override
    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }

    /**
     * Getter for an ImageView representing a weapon sprite.
     * 
     * @return An ImageView
     */
    @Override
    public ImageView getWeaponSprite() {
        return this.weaponSprite;
    }

    /**
     * Setterfor the Weapon and updates its sprite image.
     * 
     * @param weapon The weapon to set
     */
    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        setSpriteImage();
    }

    /**
     * Method for updates the position, size, image, and visibility of a weapon
     * sprite.
     */
    @Override
    public void render() {
        this.weaponSprite.setLayoutX(weapon.getPosition().getX());
        this.weaponSprite.setLayoutY(weapon.getPosition().getY());
        this.weaponSprite.setFitWidth(WeaponImpl.WIDTH);
        this.weaponSprite.setFitHeight(WeaponImpl.HEIGHT);
        setSpriteImage();
        this.weaponSprite.setVisible(this.weapon.getIsVisible());
    }

    private void setSpriteImage() {
        this.image = this.weapon.getId() == 0 ? new Image("/swordPlayer.png")
                : new Image("/hammerPlayer.png");
        this.weaponSprite.setImage(image);
    }

}
