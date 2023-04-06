package powpaw.controller.impl;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.model.impl.WeaponFactory;
import powpaw.model.impl.WeaponImpl;
import powpaw.view.impl.WeaponRender;

public class WeaponController {

    private WeaponImpl weapon;
    private WeaponRender weaponRender;
    private boolean isCollected = false;
    private int weaponIndex;
    private Random rand = new Random();

    public WeaponController() {
        weaponRender = new WeaponRender();
        createWeapon();
    }

    public void pickWeapon(PlayerController playerController) {
        playerController.getPlayerObservable().getPlayers().forEach(player -> {
            if (weapon.getHitbox().getShape().getBoundsInParent()
                    .intersects(player.getHitbox().getShape().getBoundsInParent())) {
                if (!isCollected) {
                    weapon.addAttack(player.getNumber() == 1
                            ? playerController.getPlayerObservable().getPlayers().get(0).getPlayerStats()
                            : playerController.getPlayerObservable().getPlayers().get(1).getPlayerStats());
                    if (player.getNumber() == 1) {
                        playerController.getPlayerObservable().getPlayers().get(0).increaseArmHitbox();
                    } else {
                        playerController.getPlayerObservable().getPlayers().get(1).increaseArmHitbox();
                    }

                    isCollected = true;
                    weapon.setVisible(false);
                    weaponRender.getWeaponSprite().setVisible(false);
                    new Timeline(new KeyFrame(Duration.seconds(10), event -> {
                        isCollected = false;
                        if (player.getNumber() == 1) {
                            playerController.getPlayerObservable().getPlayers().get(0).reduceArmHitbox();
                        } else {
                            playerController.getPlayerObservable().getPlayers().get(1).reduceArmHitbox();
                        }
                        this.createWeapon();
                        weapon.setVisible(true);
                        weaponRender.getWeaponSprite().setVisible(true);
                    })).play();
                }
            }
        });
    }

    public boolean isCollected() {
        return this.isCollected;
    }

    private void createWeapon() {
        weaponIndex = rand.nextInt(2);
        this.weapon = WeaponFactory.createWeapon(weaponIndex);
        this.weaponRender.setWeapon(weapon);
    }

    public WeaponImpl getWeapon() {
        return this.weapon;
    }

    public WeaponRender getRender() {
        return this.weaponRender;
    }

}
