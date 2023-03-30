package powpaw.view.impl;

import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.GameLoop;
import powpaw.view.api.GameStateView;
import powpaw.view.api.StartMenu;

public class GameStateViewImpl implements GameStateView {
    Stage stage = new Stage();
    @Override
    public void showStartMenu() {
        stage.setScene(new Scene(new StartMenu(),400,300));
        stage.setTitle("PowPaw");
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void showCharacterCreation() {
        stage.setScene(new Scene(new StatsSettingMenu(),400,300));
        stage.setTitle("PowPaw");
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void showGame() {
        WordRenderImpl wordRender = new WordRenderImpl();
        GameLoop loop = new GameLoop();
        stage.setScene(wordRender.render());
        stage.setTitle("PowPaw");
        stage.setResizable(false);
        stage.show();
        wordRender.setKeyCommands();
        loop.setPlayerController(wordRender.getPlayerController());
        loop.setWeaponController(wordRender.getWeaponController());
        loop.setPowerUpController(wordRender.getPowerUpController());
        loop.start();
    }

    @Override
    public void showGameOver() {

    }

}
