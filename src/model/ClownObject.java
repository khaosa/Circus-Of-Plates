package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ClownObject extends AbstractGameObject implements GameObject {

    private static ClownObject ClownSingleton = null;

    private ClownObject() {
        super(1000 / 2 - 96, (int) (800 * 0.6), "/clown.png");
    }

    public static ClownObject getInstance() {
        // Check if an instance exists:
        if (ClownSingleton == null) {
            ClownSingleton = new ClownObject();  // Create a new instance
        }
        return ClownSingleton;
    }

    @Override
    public void setY(int y) {

    }

}
