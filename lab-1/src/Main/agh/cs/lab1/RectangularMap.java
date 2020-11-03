package agh.cs.lab1;

import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private ArrayList<Animal> animals;
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            animals = new ArrayList<Animal>();
            this.height = height;
            this.width = width;
        }
    }

    public String toString(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(width,height);
    MapVisualizer map = new MapVisualizer(this);
    return map.draw(v1,v2);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x <=this.width && position.x >= 0 && position.y >= 0 && position.y <=this.height) {
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()) && !isOccupied(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }

        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(animals!=null){
        for (int i = 0; i < directions.length; i++) {
            this.animals.get(i % animals.size()).move(directions[i]);
        }}
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (position.equals(this.animals.get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (position.equals(this.animals.get(i).getPosition())) {
                return this.animals.get(i);
            }
        }
        return null;
    }
}