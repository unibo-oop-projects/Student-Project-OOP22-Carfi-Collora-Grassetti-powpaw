package powpaw.common;

/**
 * 
 * GameState enum. It have the four state of the game: START for start menu, STATS for char
 *  stats customize, GAME and GAMEOVER. It also have a setter and a getter
 * 
 * @author Simone Collorà
 */
public enum GameState {
    START, STATS, GAME, GAMEOVER;

    private GameState currentState;

    
    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

    public GameState getGameState() {
        return this.currentState;
    }
}