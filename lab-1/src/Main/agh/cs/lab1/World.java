package agh.cs.lab1;

public class World {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");


            IWorldMap map = new GrassField(20,20, 25, 1, 20, 5, 3);
            System.out.println(map.toString());
            int animalStartNumber = 20;
            SimulationEngine engine = new SimulationEngine(map, animalStartNumber);
            System.out.println(map.toString());
            engine.go();
            System.out.println(map.toString());



        System.out.println("end");

    }

}
