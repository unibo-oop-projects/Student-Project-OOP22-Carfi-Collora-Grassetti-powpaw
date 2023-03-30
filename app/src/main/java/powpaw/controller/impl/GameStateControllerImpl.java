package powpaw.controller.impl;

import powpaw.common.GameState;
import powpaw.controller.api.GameStateController;

public class GameStateControllerImpl implements GameStateController {

    GameState state = GameState.START;

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
