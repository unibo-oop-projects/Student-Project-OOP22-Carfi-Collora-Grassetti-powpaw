package powpaw.view.impl;

// import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.api.Player;

public class PlayerRender {

    // oddio mi sa che l'hitbox la deve avere lo sprite e basta

    private final Player player;
    final Image image = new Image("/sprite_idle_right.png");
    final ImageView sprite = new ImageView(image);

    public PlayerRender(Player player) {
        this.player = player;
    }

    public ImageView getSprite() {
        return this.sprite;
    }

    public void render() {
        this.sprite.setLayoutX(player.getPosition().getX());
        this.sprite.setLayoutY(player.getPosition().getY());
        this.sprite.setFitWidth(player.getWidth());
        this.sprite.setFitHeight(player.getHeight());
    }

}
