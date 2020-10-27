package agh.cs.lab1;
import java.util.Arrays;
public class OptionsParser {

    public MoveDirection[] parse(String[] S){
        int size = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i].equals("f") || S[i].equals("forward") || S[i].equals("b") || S[i].equals("backwards")
                    || S[i].equals("l") || S[i].equals("left") || S[i].equals("r") || S[i].equals("right")) {
                size = size + 1;
            }
        }

        MoveDirection result[] = new MoveDirection[size];
        int j = 0;
        for (int i = 0; i < S.length; i++) {
            switch (S[i]) {
                case "f":
                    result[j] = MoveDirection.FORWARD;
                    j++;
                    break;

                case "forward":
                    result[j] = MoveDirection.FORWARD;
                    j++;
                    break;

                case "b":
                    result[j] = MoveDirection.BACKWARD;
                    j++;
                    break;

                case "backward":
                    result[j] = MoveDirection.BACKWARD;
                    j++;
                    break;

                case "l":
                    result[j] = MoveDirection.LEFT;
                    j++;
                    break;

                case "left":
                    result[j] = MoveDirection.LEFT;
                    j++;
                    break;

                case "r":
                    result[j] = MoveDirection.RIGHT;
                    j++;
                    break;

                case "right":
                    result[j] = MoveDirection.RIGHT;
                    j++;
                    break;
            }

        }

    return result;
    }

}