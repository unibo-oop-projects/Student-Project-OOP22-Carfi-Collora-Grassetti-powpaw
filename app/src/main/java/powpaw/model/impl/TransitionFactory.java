package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import powpaw.model.api.Hitbox;

public class TransitionFactory {

    private CreateMap map;

    public TransitionFactory(){
        this.map = new CreateMap(); 
    }

    public Point2D verticalTransition(Point2D pos) {
        if (!checkCollisionByPos(pos)) {
            return pos.add(0, 2);
        }
        return pos;
    }

    public boolean checkCollisionByPos(Point2D pos) {
        Rectangle tmp = new Rectangle(pos.getX(), pos.getY(), WeaponImpl.WIDTH, WeaponImpl.HEIGHT);
        for (BlockImpl obs : this.map.getTerrains()) {
            if (tmp.getBoundsInParent().intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCollisionByHitbox(Hitbox hitbox){
        for (BlockImpl obs : this.map.getTerrains()) {
            if (hitbox.getShape().getBoundsInParent().intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}
