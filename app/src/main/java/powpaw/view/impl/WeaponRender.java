package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.api.Weapon;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.WeaponImpl;

public class WeaponRender {

    private Weapon weapon;
    private ArrayList<BlockImpl> terrains;
    private Image image;
    private ImageView weaponSprite = new ImageView();

    public void setTerrains(ArrayList<BlockImpl> terrains) {
        this.terrains = terrains;
    }

    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }

    public ImageView getWeaponSprite() {
        return this.weaponSprite;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        setSpriteImage();
    }

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
