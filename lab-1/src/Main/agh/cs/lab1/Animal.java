package agh.cs.lab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Animal implements  Animal_Interface, Comparable<Animal>{

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    final IWorldMap map;
    private Genes genes;
    private List<IPositionChangeObserver> observers;
    private int energy;
    private int daysAlive;
    private LinkedList<Animal> chidren = new LinkedList<>();
    private int Deathday=0;


    public Animal(IWorldMap map, Vector2d initialPosition, int energy) {
        int randomRotation = (int) (Math.random() * (8));
        for (int i = 0; i < randomRotation; i++) {
            this.move(MoveDirection.RIGHT);
        }

        this.observers = new ArrayList<>();
        this.map = map;
        this.position = initialPosition;
        genes = new Genes();
        this.energy= energy;
        this.daysAlive = 0;
    }

    public Animal(IWorldMap map, Vector2d initialPosition, int energy, Genes g1, Genes g2) {

        int randomRotation = (int) (Math.random() * (8));
        for (int i = 0; i < randomRotation; i++) {
            this.move(MoveDirection.RIGHT);
        }

        this.observers = new ArrayList<>();
        this.map = map;
        this.position = initialPosition;
        genes = new Genes(g1,g2);
        this.energy= energy;
        this.daysAlive = 0;
    }


    public void addEnergy(int energy, int maxEnergy){
        this.energy += energy;
        if(this.energy>maxEnergy){
            this.energy = maxEnergy;
        }
    }

    public void subtract(int moveCost){
        this.energy = this.energy - moveCost;
    }

    public void rotate() {
        int numOfRotation = genes.returnRandomGen();

        for (int i = 0; i < numOfRotation; i++) {
            this.move(MoveDirection.RIGHT);
        }
        this.move(MoveDirection.FORWARD);
        this.daysAlive++;
    }

    public int getDaysAlive(){
        return this.daysAlive;
    }

    public int getNumberOfChildren(){
        return this.chidren.size();
    }

    public int getNumberofProgeny(){
        int result =0;
        return result;
    }

//    private int progenyreq(){}

    public int getDeathDay(){
        return this.Deathday;
    }

    public String AnimalInfo(){
        String result ="";
        return result;
    }

    public Animal copulation(Animal anotherAnimal, Vector2d childPos){
        int childEnergy = (int) (0.25 * this.energy) + (int) (0.25 * anotherAnimal.energy);
        anotherAnimal.subtract((int) (0.25 * anotherAnimal.energy));
        this.subtract((int) (this.energy * 0.25));
        Animal baby = new Animal(map, childPos , childEnergy, this.genes ,anotherAnimal.genes);
        this.chidren.add(baby);
        anotherAnimal.chidren.add(baby);
        return baby;
    }

    public int getEnergy(){
        return this.energy;
    }

    public boolean isDead(int currentday){
        if(this.energy >0){
            return false;
        }
        this.Deathday =currentday;
        return true;
    }

    public Vector2d getPosition() {
        return position;
    }

    public Genes getGenes(){
        return this.genes;
    }

    @Override
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    public void positionChanged(Vector2d old, Vector2d n, Object a) {
        for (IPositionChangeObserver o : observers) {
            o.positionChanged(old, n, a);
        }
    }

    @Override
    public String toString() {
        switch (this.direction) {
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
            case NORTH_EAST:
                return "NE";
            case SOUTH_EAST:
                return "SE";
            case NORTH_WEST:
                return "NW";
            case SOUTH_WEST:
                return "SW";
        }

        return null;
    }


    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;

            case RIGHT:
                this.direction = this.direction.next();
                break;

            case FORWARD:
                Vector2d newVector = this.direction.toUnitVector();
                    this.position = this.position.add(newVector);


                    if(this.getPosition().x<0){
                        Vector2d v = new Vector2d(map.getWidth(),0);
                        this.position = this.position.add(v);
                    }
                if(this.getPosition().x>map.getWidth()-1){
                    Vector2d v = new Vector2d(-map.getWidth(),0);
                    this.position = this.position.add(v);
                }

                if(this.getPosition().y<0){
                    Vector2d v = new Vector2d(0, map.getHeight());
                    this.position = this.position.add(v);
                }
                if(this.getPosition().y> map.getHeight()-1){
                    Vector2d v = new Vector2d(0,-map.getHeight());
                    this.position = this.position.add(v);
                }

                break;

            case BACKWARD:
                break;
        }
    }

    @Override
    public int compareTo(Animal o) {
        if(this.getEnergy()>o.getEnergy()){
            return 1;
        }
        if(this.getEnergy() == o.getEnergy()) {
            return 0;
        }
        else{
            return -1;
        }
    }
}
