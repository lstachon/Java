import agh.cs.lab1.*;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;


public class OptionsParserTest {

    @Test
    public void test1() {
        String input[] = {"f", "r"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.RIGHT};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test2() {
        String input[] = {"f", "r", "forward"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test3() {
        String input[] = {"f", "right", "forward"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test4() {
        String input[] = {"b", "r", "forward"};
        MoveDirection result[] = {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test5() {
        String input[] = {"f", "r", "b"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test6() {
        String input[] = {"forward", "l", "forward"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

    @Test
    public void test7() {
        String input[] = {"f", "r", "left"};
        MoveDirection result[] = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        Assert.assertArrayEquals(OptionsParser.parse(input), result);
    }

}
