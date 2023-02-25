package model;


import eg.edu.alexu.csd.oop.game.GameObject;

public class GameObjectFactory {

    public static GameObject getShape( int x, int y,String type) {
        if (type == null) {
            return null;
        }
        if (type.equals("shape")) {
            return new ShapeObject(x, y, "/shape"+(((int) (Math.random() * 1000) % 4) +1)+".png");
        }
         else  if (type.equals("bomb")) {
            return new ShapeObject(x, y, "/bomb" + ".png");
        }
           else  if (type.equals("gift")) {
            return new ShapeObject(x, y, "/gift" + ".png");
        }
        return null;
    }
}
