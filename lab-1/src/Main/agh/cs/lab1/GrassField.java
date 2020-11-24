package agh.cs.lab1;

import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrassField extends AbstractWorldMap {

    private int grass_amount;
    private List<Grass> grassList = new ArrayList<>();
    private int size;

    public GrassField(int grass_a) {
        this.grass_amount = grass_a;
        double wrap = Math.sqrt(grass_amount * 10);
        int n = (int) wrap;
        this.size = n;
        for (int i = 0; i < n; i++) {
            Vector2d v = new Vector2d((int) (Math.random() * n + 1), (int) (Math.random() * n + 1));
            while (isOccupied(v)) {
                v = new Vector2d((int) (Math.random() * n + 1), (int) (Math.random() * n + 1));
            }
            grassList.add(new Grass(v));
        }
    }

    public String toString() {
        int max_x = 0, max_y = 0, min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
        for (Animal a : this.animalList) {
            for (Grass g : this.grassList) {
                if (g.getPosition().equals(a.getPosition())) {
                    this.grassList.remove(g);
                    break;
                }
            }
        }
        for (Grass g : this.grassList) {
            if (g.getPosition().x > max_x) {
                max_x = g.getPosition().x;
            }
            if (g.getPosition().y > max_y) {
                max_y = g.getPosition().y;
            }
            if (g.getPosition().x < min_x) {
                min_x = g.getPosition().x;
            }
            if (g.getPosition().y < min_y) {
                min_y = g.getPosition().y;
            }

        }

        for (Animal a : this.animalList) {
            if (a.getPosition().x > max_x) {
                max_x = a.getPosition().x;
            }
            if (a.getPosition().y > max_y) {
                max_y = a.getPosition().y;
            }
            if (a.getPosition().x < min_x) {
                min_x = a.getPosition().x;
            }
            if (a.getPosition().y < min_y) {
                min_y = a.getPosition().y;
            }
        }
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(new Vector2d(min_x, min_y), new Vector2d(max_x, max_y));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean f = super.isOccupied(position);
        if (!f) {
            for (Grass g : this.grassList) {
                if (g.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj == null) {
            for (Grass g : this.grassList) {
                if (g.getPosition().equals(position)) {
                    return g;
                }
            }
            return null;
        }
        return obj;
    }
}
