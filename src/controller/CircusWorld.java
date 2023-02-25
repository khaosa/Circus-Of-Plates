package controller;

import model.BarObject;
import model.ShapeObject;
import model.ClownObject;
import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import model.GameObjectFactory;
import model.GameObjectIterator;

public class CircusWorld implements World {

    private static final int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private int score = 0;
    private final long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private final int MAX = 120;
    private final int MAX_OBJECTS = 10;
    private final int LIVES_LOST = 3;
   // private final int GIFT = 10;
    private final int PLUS = 5;
    private int BOMBCounter = 0;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private List<GameObject> left = new LinkedList<GameObject>();
    private List<GameObject> right = new LinkedList<GameObject>();
    private Strategy gameStrategy;

    public CircusWorld(int screenWidth, int screenHeight, Strategy gameStrategy) {
        this.gameStrategy = gameStrategy;
        width = screenWidth;
        height = screenHeight;
        constant.add(new ShapeObject(0, 0, "/background.png"));
        // control objects (hero)   

        control.add(ClownObject.getInstance());    ///SINGLETON PATTERN 
        constant.add(new BarObject(0, 50, "/shelf.png"));
        constant.add(new BarObject(width - 250, 50, "/shelf.png"));

        // moving objects (enemy)
        ShapeObject p; //dropping object reference 
     //   AudioPlayer BACKGROUNDMUSIC= AudioPlayer.getInstance("D:\\Term 5\\Programming 2\\Final project\\Circus_Of_Plates\\res\\backgroundmusic.wav");
      //                  BACKGROUNDMUSIC.play();
        for (int i = 0; i < MAX; i++) {   //objects dropping from left bar             
            if ((float) Math.random() > 0.80) // drop a bomb
            {
                p = (ShapeObject) GameObjectFactory.getShape(-150 * i, 25, "bomb");
                p.setLeftOrRightBar(0);
                moving.add(p);
            } else if ((float) Math.random() > 0.95) // drop a gift
            {
                p = (ShapeObject) GameObjectFactory.getShape(-150 * i, 25, "gift");
                p.setLeftOrRightBar(0);
                moving.add(p);
            } else {    //car or shoe
                p = (ShapeObject) GameObjectFactory.getShape(-150 * i, 25, "shape");
                p.setLeftOrRightBar(0);
                moving.add(p);
            }
        }

        for (int i = 0; i < MAX; i++) {   //objects dropping from right bar             
            if ((float) Math.random() > 0.80) // drop a bomb
            {
                p = (ShapeObject) GameObjectFactory.getShape(width + 150 * i, 25, "bomb");
                p.setLeftOrRightBar(1);
                moving.add(p);
            } else if ((float) Math.random() > 0.95) // drop a gift
            {
                p = (ShapeObject) GameObjectFactory.getShape(width + 150 * i, 25, "gift");
                p.setLeftOrRightBar(1);
                moving.add(p);
            } else {    //car or shoe
                p = (ShapeObject) GameObjectFactory.getShape(width + 150 * i, 25, "shape");
                p.setLeftOrRightBar(1);
                moving.add(p);
            }
        }
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())
                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        GameObject clown = control.get(0);
        // moving starts
        GameObjectIterator iterator = new GameObjectIterator(moving);   //ITERATOR
        while (iterator.hasNext()) {
            GameObject m = iterator.next();
            ShapeObject p = (ShapeObject) m;
            int x = m.getX();
            int y = m.getY();
            y = y + (int) (Math.random() * 1000) % (4 + gameStrategy.getSpeed());

            if (p.getLeftOrRightBar() == 0) {
                x = x + gameStrategy.getSpeed();
                if (m.getX() + 250 > width / 2) {
                    p.setCurrentState(new MovingState(p));
                }
            } else {
                x = x - gameStrategy.getSpeed();
                if (m.getX() < width - 310) {
                    p.setCurrentState(new MovingState(p));
                }
            }

            p.getCurrentState().move(x, y);

            if (left.isEmpty()) {
                if (clownIntersectleft(m)) {
                    moving.remove(m);
                    if (p.getPath().equals("/bomb.png")) {
                        AudioPlayer BOMB = AudioPlayer.getInstance("D:\\Circus_Of_Plates\\res\\bomb_sounds_effect");
                        BOMB.play();
                        BOMBCounter++;
                    } else if (p.getPath().equals("/gift.png" )) {
                        if(BOMBCounter>0)
                        BOMBCounter--;
                    } else {
                        p.setClown((ClownObject) clown);
                        p.setType(1);
                        //p.getCurrentState().move(clown.getX(), clown.getY() - p.getHeight());
                        if (clown.getX() != 0) {
                            p.setX(clown.getX());
                        }
                        p.setY(clown.getY() - p.getHeight());
                        p.setHorizontalOnly(true);
                        control.add(m);
                        left.add(m);
                    }
                }
            } else {
                if (intersect(m, left.get(left.size() - 1))) {
                    moving.remove(m);
                    if (p.getPath().equals("/bomb.png")) {
                        AudioPlayer BOMB = AudioPlayer.getInstance("D:\\Circus_Of_Plates\\res\\bomb_sounds_effect");
                        BOMB.play();
                        BOMBCounter++;
                    } else if (p.getPath().equals("/gift.png")) {
                        if(BOMBCounter>0)
                       BOMBCounter--;
                    } else {
                        p.setClown((ClownObject) clown);
                        p.setX(clown.getX());
                        p.setY(left.get(left.size() - 1).getY() - p.getHeight());
                        p.setHorizontalOnly(true);
                        p.setType(1);
                        control.add(m);
                        left.add(m);
                    }
                }
            }

            if (right.isEmpty()) {
                if (clownIntersectRight(m)) {
                    moving.remove(m);
                    if (p.getPath().equals("/bomb.png")) {
                         AudioPlayer BOMB = AudioPlayer.getInstance("D:\\Term 5\\Programming 2\\Final project\\Circus_Of_Plates\\res\\bomb_sound_effect.wav");
                        BOMB.play();
                        BOMBCounter++;
                    } else if (p.getPath().equals("/gift.png")) {
                        if(BOMBCounter>0)
                        BOMBCounter--;
                    } else {
                        p.setType(2);
                        p.setClown((ClownObject) clown);
                        p.setX(clown.getX() + clown.getWidth() - p.getWidth());
                        p.setY(clown.getY() - p.getHeight());
                        p.setHorizontalOnly(true);
                        control.add(m);
                        right.add(m);
                    }
                }
            } else {
                if (intersect(m, right.get(right.size() - 1))) {
                    moving.remove(m);
                    if (p.getPath().equals("/bomb.png")) {
                        AudioPlayer BOMB = AudioPlayer.getInstance("D:\\Term 5\\Programming 2\\Final project\\Circus_Of_Plates\\res\\bomb_sound_effect.wav");
                        BOMB.play();
                        BOMBCounter++;
                    } else if (p.getPath().equals("/gift.png")) {
                        if(BOMBCounter>0)
                        BOMBCounter--;
                    } else {
                        p.setClown((ClownObject) clown);
                        p.setType(2);
                        p.setX(clown.getX() + clown.getWidth() - p.getWidth());
                        p.setY(right.get(right.size() - 1).getY() - p.getHeight());
                        p.setHorizontalOnly(true);
                        control.add(m);
                        right.add(m);
                    }
                }
            }
            updateLeft();
            updateRight();
            if (score < 0) {
                score = 0;
            }
            if (left.size() == MAX_OBJECTS || right.size() == MAX_OBJECTS || BOMBCounter == LIVES_LOST) {
                return false;
            }
        }
        return !timeout;
    }

    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public String loselife() {
        if (BOMBCounter == 0) {
            return "\u2764"+"\u2764"+"\u2764";
        } else if (BOMBCounter == 1) {
            return "\u2764"+"\u2764";
        } else if (BOMBCounter == 2) {
            return "\u2764";
        } else {
            return "";
        }

    }

    @Override
    public String getStatus() {
        return "Score=" + score + " | Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000)+" "+ loselife();	// update status
    }

    private boolean clownIntersectleft(GameObject o) {
        ClownObject clown = (ClownObject) control.get(0);
        return (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - 10
                && o.getY() >= clown.getY() - 25 && clown.getY() - o.getY() > -10);
    }

    private boolean clownIntersectRight(GameObject o) {
        ClownObject clown = (ClownObject) control.get(0);
        return (Math.abs(clown.getX() + clown.getWidth() - o.getWidth() - o.getX()) <= o.getWidth() - 10
                && o.getY() >= clown.getY() - 25 && clown.getY() - o.getY() > -10);
    }

    private void updateLeft() {
        if (left.size() >= 3) {
            ShapeObject p1 = (ShapeObject) left.get(left.size() - 1);
            ShapeObject p2 = (ShapeObject) left.get(left.size() - 2);
            ShapeObject p3 = (ShapeObject) left.get(left.size() - 3);
            if (p1.getColor(p1.getPath()).equals(p2.getColor(p2.getPath())) && p1.getColor(p1.getPath()).equals(p3.getColor(p3.getPath()))) {
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                score += PLUS;
            }

        }
    }

    private void updateRight() {
        if (right.size() >= 3) {
            ShapeObject p1 = (ShapeObject) right.get(right.size() - 1);
            ShapeObject p2 = (ShapeObject) right.get(right.size() - 2);
            ShapeObject p3 = (ShapeObject) right.get(right.size() - 3);
            if (p1.getColor(p1.getPath()).equals(p2.getColor(p2.getPath())) && p1.getColor(p1.getPath()).equals(p3.getColor(p3.getPath()))) {
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                score += PLUS;
            }

        }
    }

}
