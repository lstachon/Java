package agh.cs.lab1;

import java.util.Set;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    public TreeSet<Vector2d> xsetVectors = new TreeSet<>((o1, o2) -> {
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

    public TreeSet<Vector2d> ysetVectors = new TreeSet<>((o1, o2) -> {
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
        for (Vector2d a : this.xsetVectors) {
            System.out.println(a.toString());
        }
        System.out.println("=====");
        for (Vector2d a : this.ysetVectors) {
            System.out.println(a.toString());
        }

        return "";
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.xsetVectors.remove(oldPosition);
        this.xsetVectors.add(newPosition);
        this.ysetVectors.remove(oldPosition);
        this.ysetVectors.add(newPosition);
    }

    public Vector2d getlowest(TreeSet<Vector2d> S){
        return  S.first();
    }

    public Vector2d gethighest(TreeSet<Vector2d> S){
        return  S.last();
    }


}






