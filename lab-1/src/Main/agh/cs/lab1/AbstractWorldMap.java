package agh.cs.lab1;

import java.util.List;
import java.util.ArrayList;

public class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animalList = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x < 0 || position.y <0){
        return false;
        }

        for(Animal a: this.animalList){
            if(a.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean place(Animal animal) {
        if(animalList == null && animal != null){
            this.animalList.add(animal);
        }
        if(animalList != null) {
            if (animal.getPosition().x < 0 || animal.getPosition().y < 0) {
                return false;
            }
            for (Animal a : this.animalList) {
                if (a.getPosition().equals(animal.getPosition())) {
                    return false;
                }
            }
            this.animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(animalList!=null){
            for (int i = 0; i < directions.length; i++) {
                this.animalList.get(i % animalList.size()).move(directions[i]);
            }}
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(animalList != null){
        for(Animal a:this.animalList){
            if(a.getPosition().equals(position)){
                return true;
            }
        }
            return false;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a: this.animalList){
            if(a.getPosition().equals(position)){
                return a;
            }
        }
        return null;
    }
}
