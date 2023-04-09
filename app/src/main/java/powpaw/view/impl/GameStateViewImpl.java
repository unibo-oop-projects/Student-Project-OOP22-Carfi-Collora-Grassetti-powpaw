package powpaw.view.impl;

import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.GameLoop;
import powpaw.controller.api.GameStateController;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.GameStateControllerImpl;
import powpaw.view.api.GameStateView;

/**
 * GameStateView implementation
 * 
 * @author Simone Collorà
 */
public class GameStateViewImpl implements GameStateView {

    Stage stage = new Stage();
    GameStateController gameStateController = new GameStateControllerImpl();
    WorldRenderImpl worldRender;
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
        stage.show();
    }

    @Override
    public void showCharacterCreation() {
        gameStateController.characterCreation();
        stage.setScene(new Scene(new StatsSettingMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

    @Override
    public void showGame() {
        worldRender = new WorldRenderImpl();
        gameStateController.game();
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
        stage.setScene(new Scene(new GameOver(worldRender.getPlayerController()), ScreenController.SIZE_HD_W,
                ScreenController.SIZE_HD_H));
    }

}
