package agh.cs.lab1;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    final int width;
    final int height;
    final int startEnergy;
    final int moveEnergy;
    final int plantEnergy;
    final double jungleratio;
    private Genes mostPolupar;

    protected int day;

    private int animalsAlive;


    final HashMap<Vector2d, LinkedList<Animal>> animalsMap = new HashMap<>();

    protected LinkedList<Animal> animalLinkedList = new LinkedList<>();

    final HashMap<Genes, LinkedList<Animal>> genesCount = new HashMap<>();

    protected LinkedList<Animal> animalGeneslist = new LinkedList<>();

    final MapVisualizer map;

    public AbstractWorldMap(int width, int height, int startEnergy, int moveEnergy, int plantEnergy, double junglesize) {
        this.map = new MapVisualizer(this);
        this.width = width;
        this.height = height;
        this.startEnergy = startEnergy;
        this.moveEnergy = moveEnergy;
        this.plantEnergy = plantEnergy;
        this.jungleratio = junglesize;
        this.animalsAlive = 0;
        this.day = 0;
    }


    @Override
    public HashMap<Vector2d, LinkedList<Animal>> getAnimalsMap() {
        return this.animalsMap;
    }


    @Override
    public void removeDeadAnimals() {
        LinkedList<Animal> l = getAnimals();
        for (int i = 0; i < l.size(); i++) {
            Animal a = animalLinkedList.get(i);
            if (a.isDead()) {
                this.animalsAlive--;
                removeAnimal(a, a.getPosition());
                a.removeObserver(this);
                animalLinkedList.remove(a);
            }
        }
    }

    @Override
    public int getMaxEnergy(){
        return this.startEnergy;
    }

    @Override
    public int getWidth(){
        return this.width;
    }

    @Override
    public int getHeight(){
        return this.height;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, Object b) {
        if (canMoveTo(newPosition)) {
            removeAnimal((Animal) b, oldPosition);
            addAnimal((Animal) b, newPosition);
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }

    @Override
    public String toString() {
        Vector2d lowerLeft = getLowerLeft();
        Vector2d upperRight = getUpperRight();
        return map.draw(lowerLeft, upperRight);
    }

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();

    public int getAnimalsAlive(){
        return this.animalsAlive;
    }

    @Override
    public boolean place(Animal animal) {
        addAnimal(animal, animal.getPosition());
        animalLinkedList.add(animal);
        animal.addObserver(this);
        animalGeneslist.add(animal);
        this.animalsAlive++;
        return true;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        if (animalsMap.containsKey(position)) {
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animalsMap.containsKey(position)) {
            return animalsMap.get(position);
        }
        return null;
    }

    @Override
    public void copulation() {
        LinkedList<Animal> childrenToAdd = new LinkedList<>();

        for (LinkedList<Animal> animalList : animalsMap.values()) {
            if (animalList != null) {
                if (animalList.size() >= 2) {
                    animalList.sort(Collections.reverseOrder());
                    Animal mother = animalList.get(0);
                    Animal anotherMother = animalList.get(1);
                    if (mother.getEnergy() > 0.5*this.startEnergy)
                        if (anotherMother.getEnergy() > 0.5*this.startEnergy) {
                            Vector2d childPos = mother.map.childPosition(mother);
                            Animal child = mother.copulation(anotherMother, childPos);
                            childrenToAdd.add(child);

                        }
                }
            }
        }

        for(Animal a:childrenToAdd){
            place(a);
        }

    }


    @Override
    public Animal getStrongest(LinkedList<Animal> animalList){
        animalList.sort(Collections.reverseOrder());
        return animalList.getFirst();
    }

    @Override
    public Vector2d childPosition(Animal a){
        return a.getPosition();
    }


    public LinkedList<Animal> getAnimals() {
        return animalLinkedList;
    }

    private boolean removeAnimal(Animal a, Vector2d position2) { ;
        LinkedList<Animal> l = animalsMap.get(position2);
        l.remove(a);
        if (l.size() == 0) {
            animalsMap.remove(position2);
        }

        LinkedList<Animal> g = genesCount.get(a.getGenes());
        g.remove(a);
        if (g.size() == 0) {
            genesCount.remove(a.getGenes());
        }
        return true;
    }

    public Genes getMostPoluparGene(){
        return mostPolupar;
    }

    public void mostPopularGene(){
        Genes g= null;
        int max = -1;
        for (LinkedList<Animal> animalGeneslist : genesCount.values()) {
            if (animalGeneslist != null) {
                if (animalGeneslist.size() > max) {
                    max = animalGeneslist.size();
                    g = animalGeneslist.getFirst().getGenes();
                }
            }
        }

        this.mostPolupar = g;
//        if(max!=-1) {
//            System.out.println("-------");
//            System.out.println("tyle jest zwierzat z najczestszym genem " + max);
//            g.printGens();
//            System.out.println("-------");
//        }
//        else {
//            System.out.println("zwierzeta umarly");
//        }

    }


    private boolean addAnimal(Animal a, Vector2d p) {
        if (a == null) return false;
        LinkedList<Animal> l = animalsMap.get(p);

        if (l == null) {
            LinkedList<Animal> tmp = new LinkedList<>();
            tmp.add(a);
            animalsMap.put(p, tmp);

        } else if (l != null) {
            l.add(a);
        }

        LinkedList<Animal> g = genesCount.get(a.getGenes());

        if (g == null) {
            LinkedList<Animal> tmp = new LinkedList<>();
            tmp.add(a);
            genesCount.put(a.getGenes(), tmp);

        } else if (g != null) {
            g.add(a);
        }

        return true;

    }

    public double avrageAnimalEnergy(){
        double result =0;
        for (LinkedList<Animal> animalList : animalsMap.values()) {
            if (animalList != null) {
                for(Animal a: animalList){
                    result += a.getEnergy();

                }
            }

        }

        result = Math.round(result/this.animalsAlive*100);
        result /= 100;
    return result;
    }


}
