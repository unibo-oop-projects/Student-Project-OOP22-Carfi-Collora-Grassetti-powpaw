package powpaw.controller.impl;

import powpaw.view.api.GameStateView;
import powpaw.view.impl.GameStateViewImpl;

/**
 * Create a static GameState.
 * 
 * @author Simone Collorà
 */
public class StaticGameState {

    private static GameStateView state = new GameStateViewImpl();

    /**
     * Return state.
     * 
     * @return state.
     */
    public static GameStateView getGameStateView() {
        return state;
    }

}
