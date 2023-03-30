package powpaw.common;

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