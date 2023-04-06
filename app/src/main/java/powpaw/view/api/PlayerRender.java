package powpaw.view.api;

import javafx.scene.image.ImageView;
import powpaw.model.api.Player;

public interface PlayerRender {

    ImageView getSprite();

    Player getPlayer();

    void renderPlayer();

}