package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine{  // ta klasa właściwie nic nie robi, nie zasługuje na swoją nazwę

    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();

    public SimulationEngine( IWorldMap map, int animalStartNumber) {

        this.map = map;

        for (int i = 0; i < animalStartNumber; i++) {

            int x = map.getWidth();
            int y = map.getHeight();

            Vector2d randomPostion = new Vector2d((int) (Math.random() * x), (int) (Math.random() * y));
            while (map.isOccupied(randomPostion)) {
                randomPostion = new Vector2d((int) (Math.random() * x), (int) (Math.random() * y));
            }

            Animal nanimal = new Animal(map, randomPostion, map.getMaxEnergy());
            this.map.place(nanimal);
            animals.add(nanimal);

        }
    }

}

