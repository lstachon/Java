package agh.cs.lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;

public class propertiesLoader {

    private int width;
    private int height;
    private int startEnergy;
    private int moveEnergy;
    private int plantEnergy;
    private double jungleRatio;
    private int startAnimals;

    static public propertiesLoader loadPropFromFile() throws FileNotFoundException,IllegalArgumentException {
        Gson gson = new Gson();
        File f = new File("");
        System.out.println(f.getAbsolutePath());
        return gson.fromJson(new FileReader("src\\Main\\agh\\cs\\lab1\\\\parameters.json"), propertiesLoader.class);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getJungleRatio() {
        return jungleRatio;
    }

    public void setJungleRatio(int jungleRatio) {
        this.jungleRatio = jungleRatio;
    }

    public int getPlantEnergy() {
        return plantEnergy;
    }

    public void setPlantEnergy(int plantEnergy) {
        this.plantEnergy = plantEnergy;
    }

    public int getMoveEnergy() {
        return moveEnergy;
    }

    public void setMoveEnergy(int moveEnergy) {
        this.moveEnergy = moveEnergy;
    }

    public int getStartEnergy() {
        return startEnergy;
    }

    public void setStartEnergy(int startEnergy) {
        this.startEnergy = startEnergy;
    }

    public int getStartAnimals() {
        return startAnimals;
    }

    public void setStartAnimals(int startAnimals) {
        this.startAnimals = startAnimals;
    }




}
