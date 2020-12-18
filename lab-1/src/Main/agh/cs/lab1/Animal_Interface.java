package agh.cs.lab1;

public interface Animal_Interface {
    Vector2d getPosition();


    /**
     * Its
     *
     * @return true if elements will use move function to move, else should return false.
     */


    /**
     * If element is not movable you should implement empty move function.
     *
     * @param d to specialize direction to move
     */
    void move(MoveDirection d);

    void addObserver(IPositionChangeObserver observer);
}
