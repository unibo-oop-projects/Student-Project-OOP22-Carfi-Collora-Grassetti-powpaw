/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private GameLoop loop;

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.loop = new GameLoop(primaryStage);
        loop.start();
        /*Scene worldScene = worldRender.createScene();
         worldScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                world.getKeyObservable().notifyObservers(event);
                System.out.println(event.getCode());
            }
        }); 
        primaryStage.setTitle("PowPaw");
        primaryStage.setScene(worldScene);
        primaryStage.setResizable(false);
        primaryStage.show();*/
    }
}
