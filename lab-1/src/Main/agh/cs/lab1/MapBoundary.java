package agh.cs.lab1;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class MapBoundary implements IPositionChangeObserver{

    public Set<Vector2d> xsetAnimals = new TreeSet<>((o1, o2) -> {
        if(o1.x == o2.x) {
            return Integer.compare(o1.y, o2.y);
        } else {
            if(o1.x > o2.x) {
                return 1;
            } else {
                return -1;
            }
        }
    });

    public Set<Vector2d> ysetAnimals = new TreeSet<>((o1, o2) -> {
        if(o1.y == o2.y) {
            return Integer.compare(o1.x, o2.x);
        } else {
            if(o1.y > o2.y) {
                return 1;
            } else {
                return -1;
            }
        }
    });


    @Override
    public String toString(){
        for (Vector2d a : this.xsetAnimals) {
            System.out.println(a.toString());
        }
        System.out.println("=====");
        for (Vector2d a : this.ysetAnimals) {
            System.out.println(a.toString());
        }

        return "";
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xsetAnimals.remove(oldPosition);
        xsetAnimals.add(newPosition);
        ysetAnimals.remove(oldPosition);
        ysetAnimals.add(newPosition);
    }
}






