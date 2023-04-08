package powpaw.controller.api;

public interface GameStateController {

    /**
     * GameStateController. Every method set a determinated state:
     * Start,Character Creation, Game and Game over
     * 
     * @author Simone Collorà
     */

    void start();

    void characterCreation();

    void game();

    void gameOver();
}
