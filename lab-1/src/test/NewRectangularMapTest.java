import agh.cs.lab1.*;

import org.junit.Test;
import org.junit.Assert;
import java.util.HashMap;

import static junit.framework.TestCase.*;

public class NewRectangularMapTest {

    @Test
    public  void mapTest(){
        IWorldMap map = new RectangularMap(5,10);
        Animal a1 = new Animal(map,new Vector2d(2,2));
        Animal a2 = new Animal(map,new Vector2d(6,10));
        Animal a3 = new Animal(map,new Vector2d(4,9));
        Animal a4 = new Animal(map,new Vector2d(5,1));

        IWorldMap maptest = new RectangularMap(5, 10);
        assertEquals(map.toString(),maptest.toString());
        map.place(a1);
        maptest.place(a1);
        assertEquals(map.toString(),maptest.toString());
        map.place(a2);
        maptest.place(a2);
        assertEquals(map.toString(),maptest.toString());
        assertEquals(map.toString(),maptest.toString());
        map.place(a3);
        maptest.place(a3);
        assertEquals(map.toString(),maptest.toString());
        map.place(a4);
        maptest.place(a4);
        assertEquals(map.toString(),maptest.toString());
    }

    @Test
    public void isOccTest(){
        IWorldMap map = new RectangularMap(10,10);
        Animal a1 = new Animal(map, new Vector2d(4,3));
        Animal a2 = new Animal(map, new Vector2d(3,4));
        Animal a3 = new Animal(map, new Vector2d(5,5));
        Animal a4 = new Animal(map, new Vector2d(2,3));

        map.place(a1);
        map.place(a2);
        map.place(a3);
        map.place(a4);

        assertEquals(map.isOccupied(new Vector2d(3,3)),false);
        assertEquals(map.isOccupied(new Vector2d(3,4)),true);
        assertEquals(map.isOccupied(new Vector2d(1,2)),false);
        assertEquals(map.isOccupied(new Vector2d(5,5)),true);

    }

    @Test
    public void ObjAtTest(){
        IWorldMap map = new RectangularMap(10,10);
        Animal a1 = new Animal(map, new Vector2d(4,3));
        Animal a2 = new Animal(map, new Vector2d(3,4));
        Animal a3 = new Animal(map, new Vector2d(5,5));
        Animal a4 = new Animal(map, new Vector2d(2,3));

        map.place(a1);
        map.place(a2);
        map.place(a3);
        map.place(a4);

        assertEquals(a1, map.objectAt(new Vector2d(4,3)));
        assertNotSame(a2,map.objectAt(new Vector2d(4,3)));
        assertEquals(a3, map.objectAt(new Vector2d(5,5)));
        assertNotSame(a4,map.objectAt(new Vector2d(4,3)));
    }

    @Test
    public void CMTTest(){
        IWorldMap map = new RectangularMap(10,10);
        Animal a1 = new Animal(map, new Vector2d(4,3));
        Animal a2 = new Animal(map, new Vector2d(3,4));

        map.place(a1);
        map.place(a2);

        assertEquals(map.canMoveTo(new Vector2d(-1,0)),false);
        assertEquals(map.canMoveTo(new Vector2d(0,-1)),false);
        assertEquals(map.canMoveTo(new Vector2d(4,3)),false);
        assertEquals(map.canMoveTo(new Vector2d(3,4)),false);
        assertEquals(map.canMoveTo(new Vector2d(5,5)),true);
    }



}
