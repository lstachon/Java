package agh.cs.lab1;


public class OptionsParser {

    public static MoveDirection[] parse(String[] moveArr) throws java.lang.IllegalArgumentException {
        int size = 0;

        for (int i = 0; i < moveArr.length; i++) {  // czy to jest potrzebne, skoro rzucamy wyjątek przy błędnym kierunku?
            if (moveArr[i].equals("f") || moveArr[i].equals("forward") || moveArr[i].equals("b") || moveArr[i].equals("backward")
                    || moveArr[i].equals("l") || moveArr[i].equals("left") || moveArr[i].equals("r") || moveArr[i].equals("right")) {
                size++;
            }

        }

        MoveDirection result[] = new MoveDirection[size];
        int j = 0;
        for (int i = 0; i < moveArr.length; i++) {

            switch (moveArr[i]) {
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

                default:
                    throw new java.lang.IllegalArgumentException(moveArr[i] + " is not legal move specification");
            }

        }

        return result;
    }

}