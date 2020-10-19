package agh.cs.lab1;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String tostring() {
        switch (this) {
            case NORTH:
                return "Polnoc";
            case SOUTH:
                return "Poludnie";
            case WEST:
                return "Zachod";
            case EAST:
                return "Wschod";
        }
        return null;
    }
    public String next(){
        switch (this) {
            case NORTH:
                return "Wschod";
            case SOUTH:
                return "Zachod";
            case WEST:
                return "Polnoc";
            case EAST:
                return "Poludnie";
        }
        return null;
    }
    public String previous(){
        switch (this) {
            case NORTH:
                return "Zachod";
            case SOUTH:
                return "Wschod";
            case WEST:
                return "Poludnie";
            case EAST:
                return "Polnoc";
        }
        return null;
    }
    public Vector2d toUnitVector(){
        switch (this) {
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
            case WEST:
                return new Vector2d(0,-1);
            case EAST:
                return new Vector2d(0,1);
        }
        return null;
    }

}
