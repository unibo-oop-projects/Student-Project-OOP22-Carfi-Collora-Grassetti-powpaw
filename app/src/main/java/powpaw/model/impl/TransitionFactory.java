package powpaw.model.impl;


import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class TransitionFactory {

    private CreateMap map;

    public TransitionFactory(){
        this.map = new CreateMap(); 
    }

    public Point2D verticalTransition(Point2D pos) {
        if (!checkCollision(pos)) {
            return pos.add(0, 2);
        }
        return pos;
    }

    private boolean checkCollision(Point2D pos) {
        Rectangle tmp = new Rectangle(pos.getX(), pos.getY(), WeaponImpl.WIDTH, WeaponImpl.HEIGHT);
        for (BlockImpl obs : this.map.getTerrains()) {
            if (tmp.getBoundsInParent().intersects(obs.getHitbox().getHitbox().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}
