package powpaw.controller.api;

import javafx.geometry.Point2D;
import powpaw.model.api.Hitbox;

public class ScreenController {

    public static final int SIZE_HD_W = 1280;
    public static final int SIZE_HD_H = 720;

    public void setScreenSize(int width, int height) {
        // TODO
    }

    public static boolean isOutOfScreen(Hitbox hitbox) {
        if (hitbox.getCenter().getX() >= SIZE_HD_W
                || hitbox.getCenter().getY() <= -SIZE_HD_H / 10) { // margine alto - destro
            System.out.println("GAME OVERRRR");
            return true;
        } else if (hitbox.getCenter().getX() <= 0 || hitbox.getCenter().getY() >= 720) { // margine basso - sinistro
            System.out.println("GAME OVERRRR");
            return true;
        }
        return false;
    }
}
