package powpaw.controller.impl;

import powpaw.common.GameState;
import powpaw.controller.api.GameStateController;
/**
 * GameStateController implementation.The first state is Start.
 * 
 * @author Simone Collorà
 */
public class GameStateControllerImpl implements GameStateController {

    private GameState state = GameState.START;

    @Override
    public void start() {
        state.setCurrentState(GameState.START);
    }

    @Override
    public void characterCreation() {
        state.setCurrentState(GameState.STATS);
    }

    @Override
    public void game() {
        state.setCurrentState(GameState.GAME);
    }

    @Override
    public void gameOver() {
        state.setCurrentState(GameState.GAMEOVER);
    }
}
