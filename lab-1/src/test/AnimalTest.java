import agh.cs.lab1.*;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class AnimalTest {
    @Test
    public void Test1(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        assertEquals(a1.toString(), "(1,2) WEST");
    }

    @Test
    public void Test2(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.BACKWARD);
        assertEquals(a1.toString(), "(2,2) WEST");
    }

    @Test
    public void Test3(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        assertEquals(a1.toString(), "(1,1) SOUTH");
    }

    @Test
    public void Test4(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.FORWARD);
        assertEquals(a1.toString(), "(2,1) WEST");
    }


    @Test
    public void Test5(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        assertEquals(a1.toString(), "(1,4) SOUTH");
    }

    @Test
    public void Test6(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        assertEquals(a1.toString(), "(3,1) NORTH");
    }

    @Test
    public void Test7(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        assertEquals(a1.toString(), "(2,4) NORTH");
    }

    @Test
    public void Test8(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        assertEquals(a1.toString(), "(4,4) EAST");
    }

    @Test
    public void Test9(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        assertEquals(a1.toString(), "(2,0) NORTH");
    }

    @Test
    public void Test10(){
        Animal a1 = new Animal();
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.RIGHT);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        a1.move(MoveDirection.BACKWARD);
        assertEquals(a1.toString(), "(0,0) EAST");
    }




}
