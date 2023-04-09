package powpaw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;
import powpaw.model.api.Player;
import powpaw.model.api.Weapon;
import powpaw.model.impl.PlayerImpl;
import powpaw.model.impl.WeaponFactory;

public class WeaponTest {

    @Test
    void weaponOptionalTest() {
        Player player = new PlayerImpl(new Point2D(0, 0), 0);
        Weapon sword = WeaponFactory.createWeapon(0);
        player.setWeapon(Optional.of(sword));
        assertEquals(true, player.getWeapon().isPresent());
        Weapon hammer = WeaponFactory.createWeapon(1);
        player.setWeapon(Optional.of(hammer));
        assertTrue(player.getWeapon().isPresent());
    }

    @Test
    void weaponDurabilityTest() {
        Weapon sword = WeaponFactory.createWeapon(0);
        sword.decrementDurability();
        assertEquals(9, sword.getDurability());
    }

    @Test
    void weaponFactoryTest() {
        Weapon sword = WeaponFactory.createWeapon(0);
        assertEquals(0, sword.getId());
        Weapon hammer = WeaponFactory.createWeapon(1);
        assertEquals(1, hammer.getId());
    }
}
