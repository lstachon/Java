//import agh.cs.lab1.*;
//
//import org.junit.Test;
//
//import static junit.framework.TestCase.*;
//
//public class SimulationEngineTestAndIllegalArgumentExeption {
//
//    @Test
//    public void test1() {
//        String[] moves = {"r", "r", "r", "r"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3), new Vector2d(5, 3), new Vector2d(4, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | |E| | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | |E| | |E| | | | | |\n" +
//                "  2: | | |E| | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(), expected);
//    }
//
//    @Test
//    public void test2() {
//        String[] moves = {"r", "r", "r", "r", "f", "f", "r", "r", "f", "f", "l", "l", "f", "f", "b", "b"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3), new Vector2d(5, 3), new Vector2d(4, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | |E| | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | | | |E|E| | | | | |\n" +
//                "  2: | | | | | |E| | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(), expected);
//    }
//
//
//    @Test(expected = IllegalArgumentException.class)
//    public void illegalArgumentException_place() {
//        String[] moves = {"r", "r", "r", "r", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2), new Vector2d(5, 3), new Vector2d(4, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void IllegalArgumentException_place2() {
//        String[] moves = {"r", "r", "r", "r", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(3, 5), new Vector2d(2, 3), new Vector2d(5, 3), new Vector2d(3, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void IllegalArgumentException_moves() {
//        String[] moves = {"r", "r", "strzelba", "r", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3), new Vector2d(5, 3), new Vector2d(4, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void IllegalArgumentException_moves2() {
//        String[] moves = {"r", "w", "f", "r", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(moves);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3), new Vector2d(5, 3), new Vector2d(4, 5)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }
//
//
//}
