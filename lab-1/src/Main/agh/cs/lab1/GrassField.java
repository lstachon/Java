package agh.cs.lab1;

import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class GrassField extends AbstractWorldMap {

    private int grass_amount;

    private HashMap<Vector2d, Grass> grassMap = new HashMap<>();

    protected LinkedList<Grass> grassList = new LinkedList<>();

    private boolean go = true;


    public GrassField( int width, int height, int startEnergy, int moveEnergy, int plantEnergy, double junglesize, int animalStart) {
        super(width, height, startEnergy,moveEnergy, plantEnergy, junglesize);
        this.grass_amount = 0;
    }


    public void addGrass(){

            boolean flag = false;

            for(int j =0; j<getWidth(); j++){
                for(int k = 0; k<getHeight() ; k++){
                    Vector2d v = new Vector2d(j,k);
                    if(isOccupied(v)==false && isInJungle(v)==false){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }

            if(flag){
            Vector2d v = new Vector2d((int) (Math.random() * super.getWidth()), (int) (Math.random() * super.getHeight()));
            while (isOccupied(v) || isInJungle(v)) {
                v = new Vector2d((int) (Math.random() * super.getWidth()), (int) (Math.random() * super.getHeight()));
            }
            Grass g = new Grass(v);
            grassMap.put(g.getPosition(), g);
            this.grass_amount++;
        }


            flag = false;

        for(int j =0; j<getWidth(); j++){
            for(int k = 0; k<getHeight() ; k++){
                Vector2d v = new Vector2d(j,k);
                if(isOccupied(v)==false && isInJungle(v)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        int junglexMin = (int)((super.width-super.width*super.jungleratio)/2);
        int junglesizex = (int) (super.width*super.jungleratio);
        int junglexMax= (int) junglexMin+junglesizex +1;

        int jungleyMin = (int)((super.height-super.height*super.jungleratio)/2);
        int junglesizey = (int) (super.height*super.jungleratio);
        int jungleyMax= (int) junglexMin+junglesizey+1;

        if(flag) {
            Vector2d v = new Vector2d((int) (Math.random() * (junglexMax - junglexMin) + junglexMin), (int) (Math.random() * (jungleyMax - jungleyMin) + jungleyMin));
            while (isOccupied(v) || isInJungle(v)==false) {
                v = new Vector2d((int) (Math.random() * (junglexMax - junglexMin) + junglexMin), (int) (Math.random() * (jungleyMax - jungleyMin) + jungleyMin));
            }
            Grass g = new Grass(v);
            grassMap.put(g.getPosition(), g);
            this.grass_amount++;
        }

    }


    @Override
    public void moveAll(){

        ArrayList<LinkedList> linkedsuperlist = new ArrayList<LinkedList>(super.getAnimalsMap().values());


        for (LinkedList<Animal> animalList : linkedsuperlist) {
            if (animalList != null) {
                ArrayList<Animal> animalArrayList = new ArrayList<Animal>(animalList);
                for(Animal a: animalArrayList){
                    Vector2d prev = a.getPosition();
                    a.rotate();
                    a.positionChanged(prev, a.getPosition(),a);
                }
            }

        }
    }

    @Override
    public boolean isInJungle(Vector2d v){

        int junglexMin = (int)((super.width-super.width*super.jungleratio)/2);
        int junglesizex = (int) (super.width*super.jungleratio);
        int junglexMax= (int) junglexMin+junglesizex;

        int jungleyMin = (int)((super.height-super.height*super.jungleratio)/2);
        int junglesizey = (int) (super.height*super.jungleratio);
        int jungleyMax= (int) junglexMin+junglesizey;

        if(v.x>junglexMin-1 && v.x<junglexMax){
            if(v.y>jungleyMin-1 && v.y<jungleyMax){
                return true;
            }
        }
        return false;
    }


    @Override
    public int getGrass_amount(){
        return this.grass_amount;
    }

    @Override
    public HashMap<Vector2d, Grass> getGrassMap(){
        return this.grassMap;
    }


    @Override
    public void subtractEnergy(){

        for (LinkedList<Animal> animalList : animalsMap.values()) {
            if (animalList != null) {
                if (animalList.size() > 0) {
                    for (Animal a : animalList) {
                        a.subtract(super.moveEnergy);

                    }
                }
            }
        }
    }


    @Override
    public int getMaxEnergy(){
        return super.getMaxEnergy();
    }

    @Override
    public void eatGrass(){
        LinkedList<Grass> toRemoveAfterEating = new LinkedList<>();

        for (Grass food : grassMap.values()) {
            LinkedList<Animal> l = animalsMap.get(food.getPosition());
            if (l != null) {
                if (l.size() > 0) {
                    LinkedList<Animal> strongestAnimals = new LinkedList<>();
                    int max = 0;
                    for (Animal a : l) {
                        if(a.getEnergy()>max){
                            max = a.getEnergy();
                        }
                    }
                    for(Animal a:l){
                        if(a.getEnergy() == max){
                            strongestAnimals.add(a);
                        }
                    }
                    for(Animal a:strongestAnimals){
                        a.addEnergy(super.plantEnergy / strongestAnimals.size(), super.startEnergy);
                    }
                    toRemoveAfterEating.add(food);
                    grass_amount--;
                }
            }
        }

        for (Grass g : toRemoveAfterEating) {
            grassMap.remove(g.getPosition());
            grassList.remove(g);

        }


    }

    @Override
    public void removeDeadAnimals(){
        super.removeDeadAnimals();
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, Object b) {
        super.positionChanged(oldPosition, newPosition, b);
    }

    @Override
    public Vector2d getUpperRight() {
        return new Vector2d(super.getWidth()-1, super.getHeight()-1);
    }

    @Override
    public Vector2d getLowerLeft() {
       Vector2d v = new Vector2d(0,0);
        return v;
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        boolean ani = super.isOccupied(position);
        if (!ani) {
            if (grassMap.containsKey(position)) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj == null) {
            if (grassMap.containsKey(position)) {
                return grassMap.get(position);
            }
            return null;
        }
        return obj;
    }

    @Override
    public Vector2d childPosition(Animal animal){
        boolean flag = false;
        Vector2d childpos;
        int randomX;
        int randomY;

        int maxX = animal.getPosition().x + 2;
        int minX = animal.getPosition().x - 1;
        int maxY = animal.getPosition().y + 2;
        int minY = animal.getPosition().y - 1;

        for(int i = animal.getPosition().x-1; i<(animal.getPosition().x+2); i++){
            for(int k = animal.getPosition().y-1; k<(animal.getPosition().y+2); k++){
                Vector2d v = new Vector2d(i,k);
                if(isOccupied(v)==false){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        if(flag) {
            randomX = (int) (Math.random() * (maxX - minX)) + minX;
            randomY = (int) (Math.random() * (maxY - minY)) + minY;

            while (isOccupied(new Vector2d(randomX, randomY))) {
                randomX = (int) (Math.random() * (maxX - minX)) + minX;
                randomY = (int) (Math.random() * (maxY - minY)) + minY;
            }
            childpos = new Vector2d(randomX,randomY);
        }
        else{
            randomX = (int) (Math.random() * (maxX - minX)) + minX;
            randomY = (int) (Math.random() * (maxY - minY)) + minY;
            childpos = new Vector2d(randomX,randomY);
        }


        if(childpos.x<0){
            Vector2d v = new Vector2d(getWidth(),0);
            childpos = childpos.add(v);
        }
        if(childpos.x>getWidth()-1){
            Vector2d v = new Vector2d(-getWidth(),0);
            childpos = childpos.add(v);
        }

        if(childpos.y<0){
            Vector2d v = new Vector2d(0, getHeight());
            childpos = childpos.add(v);
        }
        if(childpos.y> getHeight()-1){
            Vector2d v = new Vector2d(0,-getHeight());
            childpos = childpos.add(v);
        }

        return childpos;
    }

    @Override
    public boolean isAnimalFollowed(){
        if(isAnimalFollowed()){
            return true;
        }
        return false;
    }

    @Override
    public void followAnimal(Vector2d v){
        LinkedList<Animal> list = animalsMap.get(v);
        animalFollow = super.getStrongest(list);
    }

    @Override
    public String followedAnimalParameters(){
        if(animalFollow!=null) {
            String result = "";
            result += "Genom: " + animalFollow.getGenes().printGens() + "\n";
            result += "Children number: " + animalFollow.getNumberOfChildren() + "\n";
            result += "Died: " + animalFollow.getDeathDay() + "\n";
            return result;
        }
        return "Pick Animal";
    }

    @Override
    public void nextDay(){
        if(this.go){
            addGrass();
            copulation();
            eatGrass();
            removeDeadAnimals();
            subtractEnergy();
            moveAll();
            super.mostPopularGene();
            super.day++;
        }

    }

    @Override
    public void changego(){
        if(go){
            this.go=false;
        }
        else{
            this.go = true;
        }
    }

    @Override
    public String mapParametersToString(){
        String result ="";
        result+="Day: "+super.day+"\n";
        result+="Animals alive: "+super.getAnimalsAlive()+"\n";
        result+="Grass amount "+getGrass_amount()+"\n";
        result+="Most popular genom: "+super.getMostPoluparGene().printGens()+"\n";
        result+="Avrage animals energy"+super.avrageAnimalEnergy()+"\n";
        result+="Avrage life for dead: "+super.getAvrageLifefordead()+"\n";
        result+="Avrage child number: "+super.getAvrageNumberOfChildren();

        aimalsAliveSum  +=  super.getAnimalsAlive();
        grassAmmountSum +=  getGrass_amount();
        avrageEnergySum += super.avrageAnimalEnergy();
        avrageLifeForDead += super.getAvrageLifefordead();
        avrageChildrenNumber += super.getAvrageNumberOfChildren();

        return result;
    }

    @Override
    public String toFile(){
        String result = "";
        result+="avrage animals alive: "+(int)aimalsAliveSum/super.day+"\n";
        result+="avrage grass ammount: "+(int)grassAmmountSum/super.day+"\n";
        result+="most popular Genome: "+mostPoluparGenomfAllTime.printGens()+"\n";
        result+="avrage animals energy: "+avrageEnergySum/super.day+"\n";
        result+="avrage life for dead animals: "+avrageLifeForDead/super.day+"\n";
        result+="avrage children number: "+avrageChildrenNumber/super.day+"\n";
        return result;

    }

}
