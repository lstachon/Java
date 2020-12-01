import agh.cs.lab1.*;
import agh.cs.lab1.MapDirection;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MapDirectionTest {

    @Test
    public void nextNorth() {
        MapDirection d = MapDirection.NORTH;
        assertEquals(d.next(), MapDirection.EAST);
    }

    @Test
    public void nextSouth() {
        MapDirection d = MapDirection.SOUTH;
        assertEquals(d.next(), MapDirection.WEST);

    }

    @Test
    public void nextEast() {
        MapDirection d = MapDirection.EAST;
        assertEquals(d.next(), MapDirection.SOUTH);
    }

    @Test
    public void nextWest() {
        MapDirection d = MapDirection.WEST;
        assertEquals(d.next(), MapDirection.NORTH);
    }


    @Test
    public void prevNorth() {
        MapDirection d = MapDirection.NORTH;
        assertEquals(d.previous(), MapDirection.WEST);
    }

    @Test
    public void prevSouth() {
        MapDirection d = MapDirection.SOUTH;
        assertEquals(d.previous(), MapDirection.EAST);

    }

    @Test
    public void prevEast() {
        MapDirection d = MapDirection.EAST;
        assertEquals(d.previous(), MapDirection.NORTH);
    }

    @Test
    public void prevWest() {
        MapDirection d = MapDirection.WEST;
        assertEquals(d.previous(), MapDirection.SOUTH);
    }


}