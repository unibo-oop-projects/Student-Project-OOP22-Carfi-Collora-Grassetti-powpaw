package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Transition;

/**
 * Class for checking collision and implementing transitions for a
 * game entity.
 * 
 * @author Giacomo Grassetti
 */
public class TransitionImpl implements Transition {

    private CreateMap map;

    /**
     * Constructor of TrasitionImpl.
     */
    public TransitionImpl() {
        this.map = new CreateMap();
    }

    @Override
    public Point2D fallTransition(Point2D pos) {
        if (!checkCollisionByPos(pos)) {
            return pos.add(0, 2);
        }
        return pos;
    }

    /**
     * This function checks if a given position collides with any of the terrain
     * blocks in a map.
     * 
     * @param pos pos is a Point2D object representing the position of a weapon in
     *            2D space. It
     *            contains the x and y coordinates of the weapon's position.
     * 
     * @return True if the given position intersect the terrains, false otherwise
     */
    private boolean checkCollisionByPos(Point2D pos) {
        Rectangle tmp = new Rectangle(pos.getX(), pos.getY(), WeaponImpl.WIDTH, WeaponImpl.HEIGHT);
        for (BlockImpl obs : this.map.getTerrains()) {
            if (tmp.getBoundsInParent()
                    .intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPlayerCollisionByHitbox(Hitbox hitbox) {
        for (BlockImpl obs : this.map.getTerrains()) {
            if (hitbox.getShape().getBoundsInParent()
                    .intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPlayerInTerrain(Shape feetBox) {
        for (BlockImpl obs : this.map.getTerrains()) {
            if (feetBox.getBoundsInParent()
                    .intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

}
