package powpaw.view.impl;

import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.GameLoop;
import powpaw.controller.api.GameStateController;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.GameStateControllerImpl;
import powpaw.view.api.GameOver;
import powpaw.view.api.GameStateView;
import powpaw.view.api.StartMenu;

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

    /**
     * show StartMenu and set GameState to START
     */
    @Override
    public void showStartMenu() {
        stage.show();
        gameStateController.start();
        stage.setScene(new Scene(new StartMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
        stage.show();
    }

    /**
     * show stats setting menu and set GameState to STATS
     */
    @Override
    public void showCharacterCreation() {
        gameStateController.characterCreation();
        stage.setScene(new Scene(new StatsSettingMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

    /**
     * show the game itself and set GameState to GAME. It also start the gameloop and inizialize the render.
     */
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
    /**
     * show GameOver and set GameState to GAMEOVER. It also stop the loop
     */
    @Override
    public void showGameOver() {
        loop.stop();
        gameStateController.gameOver();
        stage.setScene(new Scene(new GameOver(worldRender.getPlayerController()), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
    }

}
