package powpaw;

import java.time.Duration;
import java.time.Instant;
import javafx.animation.AnimationTimer;

import powpaw.controller.impl.PlayerController;

public class GameLoop extends AnimationTimer {

    private Instant lastFrameTime;
    private PlayerController playerController;

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
        playerController.getWorld().update(deltaTime);
        // for (final var player : world.getPlayers()) {
        // player.getRenderComponent().render();
        // }
        playerController.getRender().render();
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }
}
