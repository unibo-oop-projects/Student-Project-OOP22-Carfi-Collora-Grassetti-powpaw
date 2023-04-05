package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.WeaponImpl;

public class WeaponRender {

    private WeaponImpl weapons;
    private ArrayList<BlockImpl> terrains;
    private Image image;
    private ImageView weaponSprite = new ImageView();
    private int id;

    public void setTerrains(ArrayList<BlockImpl> terrains) {
        this.terrains = terrains;
    }

    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }

    public ImageView getWeaponSprite() {
        return this.weaponSprite;
    }

    public void setWeapon(WeaponImpl weapon, int id) {
        this.weapons = weapon;
        this.id = id;
        setSpriteImage();
    }

    public void render() {
        this.weaponSprite.setLayoutX(weapons.getPosition().getX());
        this.weaponSprite.setLayoutY(weapons.getPosition().getY());
        this.weaponSprite.setFitWidth(WeaponImpl.WIDTH);
        this.weaponSprite.setFitHeight(WeaponImpl.HEIGHT);
        setSpriteImage();
        this.weaponSprite.setVisible(this.weapons.getIsVisible());
    }

    private void setSpriteImage() {
        this.image = this.weapons.getId() == 0 ? new Image("/sword.png")
                : new Image("/hammer3.png");
        this.weaponSprite.setImage(image);
    }

}
