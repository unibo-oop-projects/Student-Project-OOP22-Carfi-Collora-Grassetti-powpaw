package powpaw.view.impl;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class PlayerRender {

    final List<Image> sprites = new ArrayList<>();
    final Image idleSprite;
    final Image attackSprite;
    final Image swordSprite;
    final Image hammerSprite;
    final ImageView sprite;
    private ImageView armSprite;
    private Player player;

    public PlayerRender(Player player) {
        this.player = player;
        int playerNum = player.getNumber();
        this.idleSprite = new Image("p" + playerNum + "_idle.png");
        this.attackSprite = new Image("p" + playerNum + "_attack.png");
        this.swordSprite = new Image("swordPlayer.png");
        this.hammerSprite = new Image("hammerPlayer.png");
        this.armSprite = new ImageView();
        this.sprite = new ImageView(this.idleSprite);
        if (playerNum % 2 == 0) {
            this.rotate(sprite, 180);
        }

    }

    public ImageView getSprite() {
        return this.sprite;
    }

    public ImageView getArmSprite() {
        return this.armSprite;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void renderPlayer() {
        if (this.player.getState() == PlayerState.WALK_RIGHT) {
            rotate(this.sprite, 0);
            this.armSprite.setRotate(0);
            this.armSprite.setTranslateX(0);
            this.player.getArmHitbox().setRotate(0);
            this.player.getArmHitbox().setTranslateX(0);
        }
        if (this.player.getState() == PlayerState.WALK_LEFT) {
            rotate(this.sprite, 180);
            this.player.getArmHitbox().setTranslateX(-this.player.getArmHitbox().getWidth());
            this.armSprite.setRotate(180);
            this.armSprite.setTranslateX(-this.player.getArmHitbox().getWidth());
        }
        this.sprite.setImage(this.player.getState() == PlayerState.ATTACK ? attackSprite : idleSprite);
        this.sprite.setLayoutX(this.player.getPosition().getX());
        this.sprite.setLayoutY(this.player.getPosition().getY());
        this.sprite.setFitWidth(this.player.getWidth());
        this.sprite.setFitHeight(this.player.getHeight());
        setArmSprite();
    }

    private void setArmSprite() {
        if (player.getWeapon().isPresent()) {
            this.armSprite.setVisible(true);
            this.armSprite.setImage(this.player.getWeapon().get().getId() == 0 ? this.swordSprite
                    : this.hammerSprite);
        } else {
            this.armSprite.setVisible(false);
        }
        this.armSprite.setLayoutX(this.player.getArmHitbox().getX());
        this.armSprite.setLayoutY(this.player.getArmHitbox().getY());
        this.armSprite.setFitWidth(this.player.getArmHitbox().getWidth());
        this.armSprite.setFitHeight(this.player.getArmHitbox().getHeight());
    }

    private ImageView rotate(ImageView sprite, int angle) {
        sprite.setTranslateZ(sprite.getBoundsInLocal().getWidth() / 2.0);
        sprite.setRotationAxis(Rotate.Y_AXIS);
        sprite.setRotate(angle);
        return sprite;
    }

}
