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
            this.map.place(new Animal(map, positions[i]));
        }

    }
    @Override
    public void run() {
        if(animals.size() > 0) {
            int i = 0;
            for (MoveDirection direction : directions) {

                Animal animal = animals.get(i);
                animal.move(direction);
                i++;
                i = i % animals.size();
            }
        }
    }
}

