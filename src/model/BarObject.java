package model;

import controller.BarState;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import eg.edu.alexu.csd.oop.game.GameObject;

public class BarObject extends AbstractGameObject implements GameObject {

    private final boolean horizontalOnly; 
      public BarObject(int posX, int posY, String path) {
        super(posX, posY, path);
        this.horizontalOnly = true;
    }
}
