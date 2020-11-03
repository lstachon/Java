package agh.cs.lab1;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.map=map;
        this.directions = directions;
        for(int i=0; i < positions.length; i++){
            this.map.place(new Animal(map, positions[i]));
        }
    }

    @Override
    public void run() {
    this.map.run(this.directions);
    }
}
