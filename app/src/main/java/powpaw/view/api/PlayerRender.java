package powpaw.view.api;

import javafx.scene.image.ImageView;
import powpaw.model.api.Player;

/**
 * 
 * @author Giacomo Grassetti
 */
public interface PlayerRender {

    ImageView getSprite();

    /**
     * Getter fo an ImageView representing the armSprite.
     * 
     * @return An ImageView armSprite
     */
    ImageView getArmSprite();

    Player getPlayer();

    void renderPlayer();

}