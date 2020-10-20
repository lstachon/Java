
import agh.cs.lab1.MapDirection;
import org.junit.Test;
import agh.cs.lab1.Vector2d;
import static junit.framework.TestCase.assertEquals;

public class MapDirectionTest{

    @Test
    public  void Northn(){
        MapDirection dir = MapDirection.NORTH;
        assertEquals(dir.next(), MapDirection.EAST);
    }
    @Test
    public void Southn(){
        MapDirection dir = MapDirection.SOUTH;
        assertEquals(dir.next(), MapDirection.WEST);

    }


}