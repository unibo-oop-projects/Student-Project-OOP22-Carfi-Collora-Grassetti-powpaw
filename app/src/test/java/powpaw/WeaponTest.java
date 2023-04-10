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

class WeaponTest {

    @Test
    void weaponOptionalTest() {
        final Player player = new PlayerImpl(new Point2D(0, 0), 0);
        final Weapon sword = WeaponFactory.createWeapon(0);
        player.setWeapon(Optional.of(sword));
        assertTrue(player.getWeapon().isPresent());
        final Weapon hammer = WeaponFactory.createWeapon(1);
        player.setWeapon(Optional.of(hammer));
        assertTrue(player.getWeapon().isPresent());
    }

    @Test
    void weaponDurabilityTest() {
        final Weapon sword = WeaponFactory.createWeapon(0);
        final int maxDurability = sword.getDurability();
        for (int i = 1; i < maxDurability; i++) {
            sword.decrementDurability();
        }
        assertEquals(1, sword.getDurability());
    }

    @Test
    void weaponFactoryTest() {
        final Weapon sword = WeaponFactory.createWeapon(0);
        assertEquals(0, sword.getId());
        final Weapon hammer = WeaponFactory.createWeapon(1);
        assertEquals(1, hammer.getId());
    }
}
