import agh.cs.lab1.*;
import org.junit.Test;
import agh.cs.lab1.Vector2d;
import static junit.framework.TestCase.assertEquals;
public class Vector2dTest {
    @Test
    public void equals(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,1);
        assertEquals(v.equals(v2), true);
    }

    @Test
    public void tostring(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals(v1.toString(),"(1,1)");
    }
    @Test
    public void precedes(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.precedes(v2), false);
    }

    @Test
    public void follows(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.follows(v2), true);
    }
    @Test
    public void upperRight(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.upperRight(v2), new Vector2d(1,2));
    }

    @Test

    public void lowerLeft(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.lowerLeft(v2), new Vector2d(1,1));
    }

    @Test
    public void add(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.add(v2), new Vector2d(2,3));
    }

    @Test
    public void substract(){
        Vector2d v = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v.subtract(v2), new Vector2d(0,-1));
    }

    @Test
    public void opposite(){
        Vector2d v = new Vector2d(1,1);
        assertEquals(v.opposite(), new Vector2d(-1,-1));
    }


}
