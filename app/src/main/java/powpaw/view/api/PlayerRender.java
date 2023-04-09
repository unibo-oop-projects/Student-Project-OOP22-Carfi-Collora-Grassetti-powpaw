package powpaw.view.api;

import javafx.scene.image.ImageView;

/**
 * Interface for rendering a player character in a game.
 * 
 * @author Alessia Carfì
 */
public interface PlayerRender {

    /**
     * Returns the current sprite for the player.
     * 
     * @return the current sprite for the player
     */
    ImageView getSprite();

    ImageView getArmSprite();

    /**
     * Renders the player based on their current state.
     */
    void renderPlayer();

}