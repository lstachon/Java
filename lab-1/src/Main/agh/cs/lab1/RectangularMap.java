package agh.cs.lab1;

import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private ArrayList<Animal> animals;
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            ArrayList<Animal> animals = new ArrayList<Animal>();
            this.height = height;
            this.width = width;
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x < this.width && position.x >= 0 && position.y >= 0 && position.y <= this.height) {
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()) && isOccupied(animal.getPosition())) {
            animals.add(animal);
        }

        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            this.animals.get(i % animals.size()).move(directions[i]);
        }
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