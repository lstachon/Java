package agh.cs.lab1;

import java.util.List;

public class RectangularMap implements IWorldMap{
    private int tab[][];

    public RectangularMap(int width, int height){
        if(width>0 && height>0) {
            tab = new int [width][height];
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
