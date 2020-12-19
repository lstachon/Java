package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimulationEngine{

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


    public void go() throws InterruptedException {
        if (animals.size() > 0) {
            int run = 0;

//            for (Animal a : this.animals) {
//                a.addObserver((IPositionChangeObserver) this.map);
//            }

            while(run ==1) {

                for(int i=0; i<animals.size(); i++){
                    Animal a = animals.get(i);
                    Vector2d prev = a.getPosition();
                    a.rotate();
                    a.positionChanged(prev, a.getPosition(),a);
                }
                map.subtractEnergy();
                map.removeDeadAnimals();
                this.map.addGrass();


                System.out.println(map.toString());
//                Thread.sleep(100);
                run++;
            }


        }
    }
}

