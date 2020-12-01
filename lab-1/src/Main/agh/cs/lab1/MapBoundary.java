package agh.cs.lab1;

import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    public TreeSet<Vector2d> xSetVectors = new TreeSet<>((o1, o2) -> {
        if (o1.x == o2.x) {
            return Integer.compare(o1.y, o2.y);
        } else {
            if (o1.x > o2.x) {
                return 1;
            } else {
                return -1;
            }
        }
    });

    public TreeSet<Vector2d> ySetVectors = new TreeSet<>((o1, o2) -> {
        if (o1.y == o2.y) {
            return Integer.compare(o1.x, o2.x);
        } else {
            if (o1.y > o2.y) {
                return 1;
            } else {
                return -1;
            }
        }
    });


    @Override
    public String toString() {
        for (Vector2d a : this.xSetVectors) {
            System.out.println(a.toString());
        }
        System.out.println("=====");
        for (Vector2d a : this.ySetVectors) {
            System.out.println(a.toString());
        }

        return "";
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.xSetVectors.remove(oldPosition);
        this.xSetVectors.add(newPosition);
        this.ySetVectors.remove(oldPosition);
        this.ySetVectors.add(newPosition);
    }

    public Vector2d getLowest(TreeSet<Vector2d> S) {
        return S.first();
    }

    public Vector2d getHighest(TreeSet<Vector2d> S) {
        return S.last();
    }


}






