import agh.cs.lab1.MapDirection;
import org.junit.Test;
import agh.cs.lab1.Vector2d;
import static junit.framework.TestCase.assertEquals;
public class Vector2dTest {
    @Test
    public void equals(){
        Vector2d dir = new Vector2d(1,1);
        Vector2d dir2 = new Vector2d(1,1);
        assertEquals(dir.equals(dir2), true);
    }
}
