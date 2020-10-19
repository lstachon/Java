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
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int len = str.length()/2+1;
    Direction moves[] = new Direction[len];
    int j=0;
    for(int i=0; i<str.length(); i++){
        char c = str.charAt(i);
                    switch(c){
                case 'f':
                    moves[j]=Direction.Forward;
                    j++;
                    break;
                case 'b':
                    moves[j]=Direction.Backward;
                    j++;
                    break;
                case 'l':
                    moves[j]=Direction.Left;
                    j++;
                    break;
                case 'r':
                    moves[j]=Direction.Right;
                    j++;
                    break;
            }

    }
    World.run(moves);

    System.out.println("end");

    }

}
