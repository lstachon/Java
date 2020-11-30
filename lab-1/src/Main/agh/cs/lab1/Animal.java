package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    final IWorldMap map;

    private List<IPositionChangeObserver> observers;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.observers = new ArrayList<>();
        this.map = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition(){
        return position;
    }

    public void addObserver(IPositionChangeObserver observer){this.observers.add(observer);}


    public void removeObserver(IPositionChangeObserver observer){this.observers.remove(observer);}


    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.observers.forEach(observer->observer.positionChanged(oldPosition, newPosition));
    }

    @Override
    public String toString(){
        switch (this.direction){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
        };
        return null;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT:
                this.direction = this.direction.previous();
                break;

            case RIGHT:
                this.direction = this.direction.next();
                break;

            case FORWARD:
                    Vector2d newVector = this.direction.toUnitVector();
                    if (this.map.canMoveTo(position.add(newVector)) /*&& !this.map.isOccupied(position.add(newVector))*/){
                        this.position = this.position.add(newVector);
                    }
                break;

            case BACKWARD:
                Vector2d newVector1 = this.direction.toUnitVector();
                if(this.map.canMoveTo(position.subtract(newVector1)) /*&& !this.map.isOccupied(position.subtract(newVector1))*/) {
                    this.position = this.position.subtract(newVector1);
                }

                break;
        }
    }

}
