package model;



import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

public class GameObjectIterator implements Iterator<GameObject> {

    private int index = 0;
    private List<GameObject> list;

    public GameObjectIterator(List<GameObject> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GameObject next() {
        return list.get(index++);
    }
}
