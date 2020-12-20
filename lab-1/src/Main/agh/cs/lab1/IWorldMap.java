package agh.cs.lab1;

import java.util.HashMap;
import java.util.LinkedList;

public interface IWorldMap {
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    /**
     * Place a animal on the map.
     *
     * @param animal The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    boolean place(Animal animal);

    int getWidth();

    int getHeight();

    void addGrass();

    void eatGrass();

    int getMaxEnergy();

    void removeDeadAnimals();

    void subtractEnergy();

    void copulation();

    Vector2d childPosition(Animal animal);

    Animal getStrongest(LinkedList<Animal> animalList);

    HashMap<Vector2d, LinkedList<Animal>> getAnimalsMap();

    HashMap<Vector2d, Grass> getGrassMap();

    int getGrass_amount();

    boolean isInJungle(Vector2d v);

    void moveAll();

    void nextDay();

    void changego();


    String mapParametersToString();
    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     * @param directions
     *            Array of move directions.
     */

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an object at a given position.
     *
     * @param position The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector2d position);
}