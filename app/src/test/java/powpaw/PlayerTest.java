package powpaw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.geometry.Point2D;

import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class PlayerTest {

    private Player player = new PlayerImpl(new Point2D(0, 0), 1);

    @Test
    void getNumberTest() {
        assertEquals(this.player.getNumber(), 1);
    }

    @Test
    void initialPositionTest() {
        assertEquals(this.player.getPosition(), new Point2D(0, 0));
    }

    @Test
    void setSizeTest() {
        this.player.setHeight(10);
        assertEquals(this.player.getHeight(), 10);

        this.player.setWidth(5);
        assertEquals(this.player.getWidth(), 5);

    }

    @Test
    void setDirectionTest() {
        Point2D direction = new Point2D(1, 0);

        this.player.setDirection(direction);
        assertEquals(this.player.getDirection(), direction);
    }

    @Test
    void setStateTest() {
        this.player.setCurrentState(PlayerState.ATTACK);
        assertEquals(this.player.getState(), PlayerState.ATTACK);

        this.player.setCurrentState(PlayerState.IDLE);
        assertEquals(this.player.getState(), PlayerState.IDLE);
    }
}
