package agh.cs.lab1;

import java.util.List;
import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {

    private int width;
    private int height;


    public RectangularMap(int width, int height){
        super();
        if (width > 0 && height > 0) {
            this.height = height;
            this.width = width;
        }
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
         super.positionChanged(oldPosition, newPosition);
    }


//    public String toString(){
////        Vector2d v1 = new Vector2d(0,0);
////        Vector2d v2 = new Vector2d(width,height);
////        MapVisualizer map = new MapVisualizer(this);
////        return map.draw(v1,v2);
//    }

    @Override
    public Vector2d getLowerLeft(){
        return new Vector2d(0,0);
    }

    @Override
    public Vector2d getUpperRight(){
        return (new Vector2d(this.width, this.height));
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
       if(position.x > this.width || position.x < 0 || position.y < 0 || position.y > this.height){
           return false;
       }
       return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) throws  IllegalArgumentException{
        if(animal.getPosition().x > this.width || animal.getPosition().y > this.height){
            throw new IllegalArgumentException(animal.getPosition().toString() + "is wrong");
        }
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
    return super.objectAt(position);
    }
}