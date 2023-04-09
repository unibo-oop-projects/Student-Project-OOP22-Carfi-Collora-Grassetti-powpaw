package powpaw.model.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Block;
import powpaw.model.api.BlockHitbox;

/**
 * Class representing the block (terrain) entity.
 * 
 * @author Giacomo Grassetti
 */

public class BlockImpl implements Block {

    private BlockHitbox hitbox;
    private Point2D position;
    public double width;
    public double height;

    /**
     * Constructor of the BlockImpl class.
     * 
     * @param pos    position of the block
     * @param width  width of the block
     * @param height height of the block
     */
    public BlockImpl(Point2D pos, double width, double height) {
        this.position = new Point2D(pos.getX() * ScreenController.SIZE_HD_W / 30,
                pos.getY() * ScreenController.SIZE_HD_H / 10);
        this.hitbox = new BlockHitboxImpl(position, width * ScreenController.SIZE_HD_W / 30,
                height * ScreenController.SIZE_HD_H / 10);
    }

    /**
     * Getter for position of the block.
     * 
     * @return position of the block (Point2D)
     */
    @Override
    public Point2D getPosition() {
        return this.position;
    }

    /**
     * Setter for X axis position of the block.
     * 
     * @param x double value of X axis
     */
    @Override
    public void setX(double x) {
        this.position = new Point2D(x, this.position.getY());
    }

    /**
     * Setter for Y axis position of the block.
     * 
     * @param y double value of X axis
     */
    @Override
    public void setY(double y) {
        this.position = new Point2D(this.position.getX(), y);
    }

    /**
     * Getter for hitbox of the block.
     * 
     * @return hitbox of the block (BlockHitbox)
     */
    @Override
    public BlockHitbox getHitbox() {
        return this.hitbox;
    }

    /**
     * Getter for width of the block.
     * 
     * @return width of the block (double)
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Setter for width of the block.
     * 
     * @param width block width value (double)
     */
    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Getter for height of the block.
     * 
     * @return height of the block (double)
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Setter for heigth of the block.
     * 
     * @param width block heigth value (double)
     */
    @Override
    public void setHeight(double height) {
        this.height = height;
    }
}
