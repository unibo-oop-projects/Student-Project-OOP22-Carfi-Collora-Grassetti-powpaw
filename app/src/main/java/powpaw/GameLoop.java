package powpaw;

import java.time.Duration;
import java.time.Instant;

import javafx.animation.AnimationTimer;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl;

public class GameLoop extends AnimationTimer {

    private Instant lastFrameTime;

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
        PlayerImpl.update(deltaTime);
    }

}
