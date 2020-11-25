package agh.cs.lab1;

import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;


public class GrassField extends AbstractWorldMap {

    final int grass_amount;
    final HashMap<Vector2d, Grass> grassMap = new HashMap<>();  // to powinno być prywatne
    final int size;

    public GrassField(int grass_a) {
        super();
        this.grass_amount = grass_a;
        double wrap = Math.sqrt(grass_amount * 10);
        int n = (int) wrap;
        this.size = n;
        for (int i = 0; i < n; i++) {
            Vector2d v = new Vector2d((int) (Math.random() * n + 1), (int) (Math.random() * n + 1));
            while (isOccupied(v)) {
                v = new Vector2d((int) (Math.random() * n + 1), (int) (Math.random() * n + 1));
            }
            Grass g = new Grass(v);
            grassMap.put(g.getPosition(),g);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
    }

    @Override
    public Vector2d getLowerLeft(){
      int  min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;    // lepiej operować na całych wektorach
        for (Animal a : this.animalsMap.values()) {
            for (Grass g : this.grassMap.values()) {
                if (g.getPosition().equals(a.getPosition())) {
                    this.grassMap.remove(g.getPosition(),g);
                    break;
                }
            }
        }
        for (Grass g : this.grassMap.values()) {
            if (g.getPosition().x < min_x) {
                min_x = g.getPosition().x;
            }
            if (g.getPosition().y < min_y) {
                min_y = g.getPosition().y;
            }
        }
        for (Animal a : this.animalsMap.values()) {
            if (a.getPosition().x < min_x) {
                min_x = a.getPosition().x;
            }
            if (a.getPosition().y < min_y) {
                min_y = a.getPosition().y;
            }
        }
    return new Vector2d(min_x, min_y);
    }


    @Override
    public Vector2d getUpperRight(){
        int max_x = 0, max_y = 0;

        for (Grass g : this.grassMap.values()) {
            if (g.getPosition().x > max_x) {
                max_x = g.getPosition().x;
            }
            if (g.getPosition().y > max_y) {
                max_y = g.getPosition().y;
            }
        }

        for (Animal a : this.animalsMap.values()) {
            if (a.getPosition().x > max_x) {
                max_x = a.getPosition().x;
            }
            if (a.getPosition().y > max_y) {
                max_y = a.getPosition().y;
            }
        }

        return new Vector2d(max_x, max_y);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {   // nie ma sensu przesłaniać metody, jeśli zamierza Pan tylko wywołać wersję odziedziczoną
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean ani = super.isOccupied(position);
        if (!ani) {
            if(grassMap.containsKey(position)){
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
            if(grassMap.containsKey(position)){
                return grassMap.get(position);
            }
            return null;
        }
        return obj;
    }
}
