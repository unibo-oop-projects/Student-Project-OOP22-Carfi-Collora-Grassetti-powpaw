package powpaw.view.api;

/**
 * GameStateView interface. Every method renderize a determinated state
 * 
 * @author Simone Collorà
 */
public interface GameStateView {

    void showStartMenu();

    void showCharacterCreation();

    void showGame();

    void showGameOver();
}
