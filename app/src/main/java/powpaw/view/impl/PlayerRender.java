package powpaw.view.impl;

import java.util.ArrayList;
import java.util.List;

// import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class PlayerRender {

    final List<Image> sprites = new ArrayList<>();
    final Image idleSprite;
    final Image attackSprite;
    final ImageView sprite;
    private Player player;

    public PlayerRender(Player player) {
        this.player = player;
        int playerNum = player.getNumber();
        this.idleSprite = new Image("p" + playerNum + "_idle.png");
        this.attackSprite = new Image("p" + playerNum + "_attack.png");
        this.sprite = new ImageView(this.idleSprite);
        if (playerNum % 2 == 0) {
            this.rotate(sprite, 180);
        }
    }

    public ImageView getSprite() {
        return this.sprite;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void renderPlayer() {
        if (this.player.getState() == PlayerState.WALK_RIGHT) {
            rotate(this.sprite, 0);

        }
        if (this.player.getState() == PlayerState.WALK_LEFT) {
            rotate(this.sprite, 180);
        }
        this.sprite.setImage(this.player.getState() == PlayerState.ATTACK ? attackSprite : idleSprite);
        this.sprite.setLayoutX(this.player.getPosition().getX());
        this.sprite.setLayoutY(this.player.getPosition().getY());
        this.sprite.setFitWidth(this.player.getWidth());
        this.sprite.setFitHeight(this.player.getHeight());
    }

    private ImageView rotate(ImageView sprite, int angle) {
        sprite.setTranslateZ(sprite.getBoundsInLocal().getWidth() / 2.0);
        sprite.setRotationAxis(Rotate.Y_AXIS);
        sprite.setRotate(angle);
        return sprite;
    }

}
