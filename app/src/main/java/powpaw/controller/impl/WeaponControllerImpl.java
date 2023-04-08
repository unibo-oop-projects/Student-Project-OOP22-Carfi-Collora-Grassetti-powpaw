package powpaw.controller.impl;

import java.util.Optional;
import java.util.Random;

import powpaw.controller.api.PlayerController;
import powpaw.controller.api.WeaponController;
import powpaw.model.api.Player;
import powpaw.model.api.Weapon;
import powpaw.model.impl.WeaponFactory;
import powpaw.view.impl.WeaponRender;

public class WeaponControllerImpl implements WeaponController {

    private Weapon weapon;
    private WeaponRender weaponRender;
    private int weaponIndex;
    private PlayerController playerController;
    private Random rand = new Random();

    public WeaponControllerImpl(PlayerController playerController) {
        this.playerController = playerController;
        weaponRender = new WeaponRender();
        spownWeapons();
    }

    @Override
    public void pickWeapon() {
        playerController.getPlayerObservable().getPlayers().forEach(player -> {
            if (player.getHitbox().checkCollision(weapon.getHitbox().getShape())) {
                setWeaponToPlayer(player);
            }
            dropWeapon(player);
        });
    }

    private void setWeaponToPlayer(Player player) {
        if (player.getWeapon().isEmpty() && !this.weapon.isPicked()) {
            this.weapon.setPicked(true);
            player.setWeapon(Optional.of(weapon));
            player.increaseArmHitbox();
            this.weapon.addAttack(player.getPlayerStats());
            this.weapon.setVisible(false);
            this.weaponRender.getWeaponSprite().setVisible(false);
        }
    }

    private void dropWeapon(Player player) {
        if (player.getWeapon().isPresent()) {
            if (player.getWeapon().get().getDurability() == 0) {
                player.setWeapon(Optional.empty());
                player.reduceArmHitbox();
                spownWeapons();
            }
        }
    }

    private void spownWeapons() {
        this.createNewWeapon();
        weapon.setPicked(false);
        weapon.setVisible(true);
        weaponRender.getWeaponSprite().setVisible(true);

    }

    private void createNewWeapon() {
        weaponIndex = rand.nextInt(2);
        this.weapon = WeaponFactory.createWeapon(weaponIndex);
        this.weaponRender.setWeapon(weapon);
    }

    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public WeaponRender getRender() {
        return this.weaponRender;
    }

}
