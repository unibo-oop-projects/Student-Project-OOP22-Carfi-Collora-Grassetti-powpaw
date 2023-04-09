package powpaw.controller.impl;

import powpaw.view.api.GameStateView;
import powpaw.view.impl.GameStateViewImpl;

/**
 * Create a static GameState.
 * 
 * @author Simone Collorà
 */
public final class StaticGameState {

    private static GameStateView state = new GameStateViewImpl();

    private StaticGameState() {

    }

    /**
     * Return state.
     * 
     * @return state.
     */
    public static GameStateView getGameStateView() {
        return state;
    }

}
