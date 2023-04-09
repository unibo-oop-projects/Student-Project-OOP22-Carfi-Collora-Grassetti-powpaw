package powpaw.controller.impl;

import powpaw.view.api.GameStateView;
import powpaw.view.impl.GameStateViewImpl;

public class StaticGameState {

    private static GameStateView state = new GameStateViewImpl();

    public static GameStateView getGameStateView(){
        return state;
    }
    
}
