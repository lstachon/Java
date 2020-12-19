package agh.cs.lab1;

import java.io.*;

import com.google.gson.JsonParser;

import org.json.simple.*;


import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class propertiesLoader {

    final int width;
    final int height;
    final int startEnergy;
    final int moveEnergy;
    final int plantEnergy;
    final double jungleRatio;
    final int startAnimals;

     public propertiesLoader() throws IOException, IllegalArgumentException, ParseException {
        JSONParser json = new JSONParser();
        String path = new File("").getAbsolutePath();
        JSONObject data  = (JSONObject) json.parse(new FileReader(path+"/lab-1/src/Main/agh/cs/lab1/json/parameters.json"));
        this.width = Integer.parseInt(data.get("width").toString());
        this.height = Integer.parseInt(data.get("height").toString());
        this.startEnergy = Integer.parseInt(data.get("startEnergy").toString());
        this.moveEnergy = Integer.parseInt(data.get("moveEnergy").toString());
        this.plantEnergy = Integer.parseInt(data.get("plantEnergy").toString());
        this.jungleRatio = Double.valueOf(data.get("jungleRatio").toString());
        this.startAnimals = Integer.parseInt(data.get("startAnimals").toString());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getJungleRatio() {
        return jungleRatio;
    }

    public int getPlantEnergy() {
        return plantEnergy;
    }
    public int getMoveEnergy(){
         return moveEnergy;
    }

    public int getStartEnergy() {
        return startEnergy;
    }

    public int getStartAnimals() {
        return startAnimals;
    }

}
