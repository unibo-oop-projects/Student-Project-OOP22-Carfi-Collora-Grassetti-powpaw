package powpaw.common;

/**
 * 
 * GameState enum. It have the four state of the game: START for start menu,
 * STATS for char
 * stats customize, GAME and GAMEOVER. It also have a setter and a getter
 * 
 * @author Simone Collorà
 */
public enum GameState {
    START, STATS, GAME, GAMEOVER;

    private GameState currentState;

    /**
     * Set new state
     * 
     * @param newState
     */
    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

    /**
     * return state
     * 
     * @return state
     */
    public GameState getGameState() {
        return this.currentState;
    }
}
