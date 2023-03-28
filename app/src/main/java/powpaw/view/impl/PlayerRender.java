package powpaw.view.impl;

// import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.api.Player;

public class PlayerRender {

    // oddio mi sa che l'hitbox la deve avere lo sprite e basta

    private final Player playerOne;
    private final Player playerTwo;
    final Image idleOne = new Image("/spritep1_idle_right.png");
    final Image idleTwo = new Image("/spritep2_idle_left.png");
    final ImageView spriteP1 = new ImageView(idleOne);
    final ImageView spriteP2 = new ImageView(idleTwo);

    public PlayerRender(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public ImageView getSpritePlayerOne() {
        return this.spriteP1;
    }

    public ImageView getSpritePlayerTwo() {
        return this.spriteP2;
    }

    public void renderPlayerOne() {
        this.spriteP1.setLayoutX(playerOne.getPosition().getX());
        this.spriteP1.setLayoutY(playerOne.getPosition().getY());
        this.spriteP1.setFitWidth(playerOne.getWidth());
        this.spriteP1.setFitHeight(playerOne.getHeight());
    }

    public void renderPlayerTwo() {
        this.spriteP2.setLayoutX(playerTwo.getPosition().getX());
        this.spriteP2.setLayoutY(playerTwo.getPosition().getY());
        this.spriteP2.setFitWidth(playerTwo.getWidth());
        this.spriteP2.setFitHeight(playerTwo.getHeight());
    }

}
