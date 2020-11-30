package agh.cs.lab1;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    //    protected List<Animal> animalList = new ArrayList<>();
    final HashMap<Vector2d, Animal> animalsMap = new HashMap<>();
    private MapVisualizer map;

    public AbstractWorldMap() {
        MapVisualizer map = new MapVisualizer(this);
        this.map = map;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal a = this.animalsMap.get(oldPosition);
        this.animalsMap.remove(oldPosition);
        this.animalsMap.put(newPosition, a);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (animalsMap.containsKey(position)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Vector2d lowerLeft = getLowerLeft();
        Vector2d upperRight = getUpperRight();
        return map.draw(lowerLeft, upperRight);
    }

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();

    @Override
    public boolean place(Animal animal) throws  IllegalArgumentException {
        if (animalsMap.containsKey(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition().toString() + "is wrong");
        }
//        if (isOccupied(animal.getPosition())) {
//            throw new IllegalArgumentException(animal.getPosition().toString() + "is wrong");
//        }
        if (animal.getPosition().x < 0 || animal.getPosition().y < 0) {
            throw new IllegalArgumentException(animal.getPosition().toString() + "is wrong");
        }
        animalsMap.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (animalsMap.containsKey(position)) {
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animalsMap.containsKey(position)) {
            return animalsMap.get(position);
        }
        return null;
    }
}
