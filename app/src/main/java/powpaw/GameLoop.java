package powpaw;

import java.time.Duration;
import java.time.Instant;
import javafx.animation.AnimationTimer;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.WeaponController;

public class GameLoop extends AnimationTimer {

    private Instant lastFrameTime;
    private PlayerController playerController;
    private WeaponController weaponController;

    // serve una classe per la view dove si istanziano le scene e cose varie.

    @Override
    public void start() {
        super.start();
        lastFrameTime = Instant.now();

    }

    @Override
    public void handle(long now) {
        Instant currentFrameTime = Instant.now();
        Duration deltaTime = Duration.between(lastFrameTime, currentFrameTime);
        lastFrameTime = currentFrameTime;
        update(deltaTime);
    }

    private void update(Duration deltaTime) {
        playerController.getPlayerObservable().update(deltaTime);
        // for (final var player : world.getPlayers()) {
        // player.getRenderComponent().render();
        // }
        playerController.getRender().forEach(player -> player.renderPlayer());
        weaponController.getRender().render();
        weaponController.getWeapons().update();
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void setWeaponController(WeaponController weaponController) {
        this.weaponController = weaponController;
    }
}
