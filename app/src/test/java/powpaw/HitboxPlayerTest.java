package powpaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import javafx.geometry.Point2D;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl;

public class HitboxPlayerTest {

    @Test
    void updateCenterTest() {
        /* Player player = new PlayerImpl(new Point2D(0, 0), 1);
        player.setHeight(20);
        player.setWidth(10);

        player.moveRight();
        player.update(Duration.ofMillis(1));
        assertEquals(new Point2D(15.0, 10.0), player.getHitbox().getCenter());

        player.moveLeft();
        player.update(Duration.ofMillis(1));
        assertEquals(new Point2D(5.0, 10.0), player.getHitbox().getCenter());

        player.idle();
        player.update(Duration.ofMillis(1));
        assertEquals(new Point2D(5.0, 10.0), player.getHitbox().getCenter());

        player.jump();
        player.update(Duration.ofMillis(1));
        assertEquals(new Point2D(5.0, 0.0), player.getHitbox().getCenter()); */
    }

}
