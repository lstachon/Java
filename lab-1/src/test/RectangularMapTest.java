//import agh.cs.lab1.*;
//import org.junit.Assert;
//import org.junit.Test;
//import static junit.framework.TestCase.assertEquals;
//
//public class RectangularMapTest {
//
//    @Test
//    public void map1() {
//        String s1[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | |N| | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | | | | | | | | | | |\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | |S| | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(), expected);
//
//    }
//
//    @Test
//    public void map2(){
//        String s1[] = {"f", "b", "r" ,"l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "b", "b"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | | | | | | | | |\n" +
//                "  4: | | | |N| | | | | | | |\n" +
//                "  3: | | | | | | | | | | | |\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | |S| | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(),expected);
//
//    }
//
//    @Test
//    public void map3(){
//        String s1[] = {"f", "b", "r" ,"l"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | | | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | |E|W| | | | | | | |\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(),expected);
//
//    }
//
//    @Test
//    public void map4occupied(){
//        String s1[] = {"f", "b", "r" ,"l","f"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | | | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | |E|W| | | | | | | |\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(),expected);
//
//    }
//
//    @Test
//    public void map5outofmap(){
//        String s1[] = {"f", "b", "r" ,"l","b","b","b","b","b","b","b","b","b","b","b","b","b","b"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        //jest dobrze bo nie moze byc na 10 bo wielkosc mapy ma byc 10 pol
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | | | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: |E| | | | | | | | | |W|\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: | | | | | | | | | | | |\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(),expected);
//
//    }
//
//    @Test
//    public void map6outofmap(){
//        String s1[] = {"f", "b", "r" ,"l","b","b","b","b","b","b","b","b","b","b","b","b","b","b","r","l","f","f","f","f","f","f","f","f"};
//        MoveDirection[] directions = new OptionsParser().parse(s1);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        //jest dobrze bo nie moze byc na 10 bo wielkosc mapy ma byc 10 pol
//        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
//                "  6: -----------------------\n" +
//                "  5: | | | | | | | | | | | |\n" +
//                "  4: | | | | | | | | | | | |\n" +
//                "  3: | | | | | | | | | | | |\n" +
//                "  2: | | | | | | | | | | | |\n" +
//                "  1: | | | | | | | | | | | |\n" +
//                "  0: |S| | | | | | | | | |S|\n" +
//                " -1: -----------------------\n";
//        assertEquals(map.toString(),expected);
//
//    }
//
//
//
//
//}
