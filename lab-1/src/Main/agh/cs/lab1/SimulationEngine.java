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
        int n = this.directions.length;
        int k = this.animals.size();
        Animal a;
        for(int i=0; i<n; i++){
            a = this.animals.get(i%k);
            a.move(this.directions[i]);
        }
        System.out.println(this.map.toString());
    }
}
