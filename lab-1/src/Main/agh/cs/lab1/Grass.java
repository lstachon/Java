package agh.cs.lab1;

public class Grass {
    private Vector2d position;
    public Grass(Vector2d position1) {
    position = position1;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return "*";
    }


}
