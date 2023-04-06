package powpaw.view.api;

import powpaw.model.api.Player;

public interface GameStateView {

    void showStartMenu();

    void showCharacterCreation();

    void showGame();

    void showGameOver(Player player);
}
