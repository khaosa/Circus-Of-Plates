package model;

import controller.BarState;
import controller.State;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ShapeObject extends AbstractGameObject implements GameObject {

    private int type;//0 moving 1 left 2 right
    private boolean horizontalOnly;
    private ClownObject clown;
    private String path;
    private int LeftOrRightBar;//0 Left 1 right
    private State currentState;

    public void setClown(ClownObject clown) {
        this.clown = clown;
    }

    public ShapeObject(int posX, int posY, String path) {
        this(posX, posY, path, 0);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ShapeObject(int posX, int posY, String path, int type) {
        super(posX, posY, path);
        this.type = type;
        this.path = path;
        this.currentState = new BarState(this);
    }

    public String getColor(String path) {
        if (path.equals("/shape1.png") || path.equals("/shape3.png")) {
            return "blue";
        } else {
            return "red";
        }
    }

    public boolean isHorizontalOnly() {
        return horizontalOnly;
    }

    public void setHorizontalOnly(boolean horizontalOnly) {
        this.horizontalOnly = horizontalOnly;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getLeftOrRightBar() {
        return LeftOrRightBar;
    }

    public void setLeftOrRightBar(int LeftOrRightBar) {
        this.LeftOrRightBar = LeftOrRightBar;
    }

    @Override
    public void setY(int y) {

        if (horizontalOnly) {

        } else {
            this.y = y;
        }
    }

    @Override
    public void setX(int x) {
        if(type==0)
        {
            super.setX(x);
        }
        if (type == 1) {
            super.setX(clown.getX());
        } else if (type == 2) {
            super.setX(clown.getX() + clown.getWidth() - 60);
        }

    }

}
