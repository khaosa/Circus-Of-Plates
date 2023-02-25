/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public abstract class AbstractGameObject implements GameObject{

    private static final int MAX_MSTATE = 1; 
    private BufferedImage[] spriteImages;
    private int x;
    protected int y;
    private boolean visible;

    public AbstractGameObject(int posX, int posY, String path) {
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.spriteImages = new BufferedImage[MAX_MSTATE];

        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {

        }
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {

        this.x = x;

    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {

        this.y = y;

    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
