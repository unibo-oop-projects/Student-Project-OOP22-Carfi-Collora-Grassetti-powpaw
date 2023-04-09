package powpaw.controller.impl;

import java.util.Optional;
import java.util.Random;

import powpaw.controller.api.PlayerController;
import powpaw.controller.api.WeaponController;
import powpaw.model.api.Player;
import powpaw.model.api.Weapon;
import powpaw.model.impl.WeaponFactory;
import powpaw.view.api.WeaponRender;
import powpaw.view.impl.WeaponRenderImpl;

/**
 * Class WeaponControllerImpl class that controls the spawning, picking up, and
 * dropping of weapons for players in a game.
 * 
 * @author Giacomo Grassetti
 */
public class WeaponControllerImpl implements WeaponController {

    private Weapon weapon;
    private WeaponRender weaponRender;
    private int weaponIndex;
    private PlayerController playerController;
    private Random rand = new Random();

    /**
     * This is a constructor for the WeaponControllerImp class that initializes the
     * playerController field with
     * the passed object, creating a new WeaponRender object. Spawn automatically
     * the first weapon.
     * 
     * @param playerController
     */
    public WeaponControllerImpl(PlayerController playerController) {
        this.playerController = playerController;
        weaponRender = new WeaponRenderImpl();
        spownWeapons();
    }

    /**
     * The function checks if a player collides with a weapon and either sets the
     * weapon to the player
     * or drops it.
     */
    @Override
    public void pickWeapon() {
        playerController.getPlayerObservable().getPlayers().forEach(player -> {
            if (player.getHitbox().checkCollision(weapon.getHitbox().getShape())) {
                setWeaponToPlayer(player);
            }
            dropWeapon(player);
        });
    }

    /**
     * Method that sets a weapon to a player if the it doesn't already have a weapon
     * and the
     * weapon has not been picked up yet.
     * 
     * @param player Player in the game.
     * 
     */
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

    /**
     * The function drops a player's weapon if it has no durability left and spawns
     * new weapons.
     * 
     * @param player Player in the game.
     */
    private void dropWeapon(Player player) {
        if (player.getWeapon().isPresent()) {
            if (player.getWeapon().get().getDurability() == 0) {
                player.setWeapon(Optional.empty());
                player.reduceArmHitbox();
                spownWeapons();
            }
        }
    }

    /**
     * Method that spawns a new weapon and sets its visibility to true.
     */
    private void spownWeapons() {
        this.createNewWeapon();
        weapon.setPicked(false);
        weapon.setVisible(true);
        weaponRender.getWeaponSprite().setVisible(true);

    }

    /**
     * Method that creates a new weapon using a random index and sets it to the
     * weaponRender.
     */
    private void createNewWeapon() {
        weaponIndex = rand.nextInt(2);
        this.weapon = WeaponFactory.createWeapon(weaponIndex);
        this.weaponRender.setWeapon(weapon);
    }

    /**
     * Getter for weapon.
     * 
     * @return The Weapon
     */
    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * Getterfor the weapon render.
     * 
     * @return A WeaponRender
     */
    @Override
    public WeaponRender getRender() {
        return this.weaponRender;
    }

}
