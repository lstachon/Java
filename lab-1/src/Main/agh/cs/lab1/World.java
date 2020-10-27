package agh.cs.lab1;
import java.util.Scanner;
public class World {

//    static void run(String str){
//        for(int i=0; i<str.length(); i++){
//            char c = str.charAt(i);
//            switch(c){
//                case 'f':
//                    System.out.println("zwierzak idzie do przodu");
//                    break;
//                case 'b':
//                    System.out.println("zwierzak idzie do tyłu");
//                    break;
//                case 'l':
//                    System.out.println("zwierzak idzie w lewo");
//                    break;
//                case 'r':
//                    System.out.println("zwierzak idzie w prawo");
//                    break;
//            }
//        }
//    }

    static void run(Direction arr[]){
        for(int i=0; i<arr.length; i++){
            switch(arr[i]){
                case Forward:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case Backward:
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case Left:
                    System.out.println("zwierzak idzie w lewo");
                    break;
                case Right:
                    System.out.println("zwierzak idzie w prawo");
                    break;
            }
        }
    }

    public static void main(String[] args){
    System.out.println("start");
    Animal a1 = new Animal();
    System.out.println(a1);
    for (MoveDirection d: OptionsParser.parse(args)){
        a1.move(d);
        System.out.println(a1);
    }

//manualne testy MapDirection
//    System.out.println(MapDirection.NORTH.next());
//    System.out.println(MapDirection.SOUTH.previous());
//    System.out.println(MapDirection.EAST.toUnitVector());
//    System.out.println(MapDirection.WEST.tostring());
//



//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//    Scanner sc = new Scanner(System.in);
//    String str = sc.next();
//    int len = str.length()/2+1;
//    Direction moves[] = new Direction[len];
//    int j=0;
//    for(int i=0; i<str.length(); i++){
//        char c = str.charAt(i);
//                    switch(c){
//                case 'f':
//                    moves[j]=Direction.Forward;
//                    j++;
//                    break;
//                case 'b':
//                    moves[j]=Direction.Backward;
//                    j++;
//                    break;
//                case 'l':
//                    moves[j]=Direction.Left;
//                    j++;
//                    break;
//                case 'r':
//                    moves[j]=Direction.Right;
//                    j++;
//                    break;
//            }
//
//    }
//    World.run(moves);

    System.out.println("end");

    }

}
