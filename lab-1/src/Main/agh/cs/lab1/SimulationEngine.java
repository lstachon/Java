package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.map=map;
        this.directions = directions;
        for(int i=0; i < positions.length; i++){
            Animal nanimal = new Animal(map, positions[i]);
            this.map.place(nanimal);
            animals.add(nanimal);


//            map.map_Bound.ysetAnimals.add(nanimal.getPosition());
//            System.out.println(map_Bound.toString());
        }

    }
    @Override
    public void run() {
        if(animals.size() > 0) {
            int i = 0;
            for(Animal a:this.animals) {
                a.addObserver((IPositionChangeObserver) this.map);
            }

            for (MoveDirection direction : directions) {
                Animal a = animals.get(i);
                Vector2d prev = a.getPosition();
                a.move(direction);
                a.positionChanged(prev,a.getPosition());
                i++;
                i = i % animals.size();

            }

            for(Animal a: this.animals){
                a.removeObserver((IPositionChangeObserver) this.map);
            }
            System.out.println(map);
        }
        else{
            System.out.println("nic tu nie ma");
        }
    }
}

