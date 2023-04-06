package powpaw.view.impl;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.GameLoop;
import powpaw.controller.api.GameStateController;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.GameStateControllerImpl;
import powpaw.view.api.GameOver;
import powpaw.view.api.GameStateView;
import powpaw.view.api.StartMenu;

public class GameStateViewImpl implements GameStateView {

    Stage stage = new Stage();
    GameStateController gameStateController = new GameStateControllerImpl();
    GameLoop loop = new GameLoop();

    public GameStateViewImpl() {
        stage.setTitle("PowPaw");
        stage.setResizable(false);
    }

    @Override
    public void showStartMenu() {
        stage.show();
        gameStateController.start();
        stage.setScene(new Scene(new StartMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

    @Override
    public void showCharacterCreation() {
        gameStateController.characterCreation();
        stage.setScene(new Scene(new StatsSettingMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

    @Override
    public void showGame() {
        gameStateController.game();
        WorldRenderImpl worldRender = new WorldRenderImpl();
        stage.setScene(worldRender.render());
        worldRender.playersCommands();
        loop.setPlayerController(worldRender.getPlayerController());
        loop.setWeaponController(worldRender.getWeaponController());
        loop.setPowerUpController(worldRender.getPowerUpController());
        loop.setDamageMeterController(worldRender.getDamageMeterController());
        loop.start();
    }

    @Override
    public void showGameOver() {
        loop.stop();
        gameStateController.gameOver();
        stage.setScene(new Scene(new GameOver(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

}
