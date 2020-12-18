package agh.cs.lab1;

public enum MapDirection {
    NORTH, NORTH_EAST , SOUTH, SOUTH_EAST,SOUTH_WEST, NORTH_WEST, WEST, EAST;

    public MapDirection next() {
        switch (this) {
            case NORTH:
                return NORTH_EAST;
            case SOUTH:
                return SOUTH_WEST;
            case WEST:
                return NORTH_WEST;
            case EAST:
                return SOUTH_EAST;
            case NORTH_EAST:
                return EAST;
            case SOUTH_EAST:
                return SOUTH;
            case SOUTH_WEST:
                return WEST;
            case NORTH_WEST:
                return NORTH;
        }
        return null;
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return NORTH_WEST;
            case SOUTH:
                return SOUTH_EAST;
            case WEST:
                return SOUTH_WEST;
            case EAST:
                return NORTH_EAST;
            case NORTH_EAST:
                return NORTH;
            case NORTH_WEST:
                return WEST;
            case SOUTH_EAST:
                return EAST;
            case SOUTH_WEST:
                return SOUTH;
        }
        return null;
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH:
                return new Vector2d(0, 1);
            case SOUTH:
                return new Vector2d(0, -1);
            case EAST:
                return new Vector2d(1, 0);
            case WEST:
                return new Vector2d(-1, 0);
            case SOUTH_WEST:
                return new Vector2d(-1, -1);
            case NORTH_WEST:
                return new Vector2d(-1, 1);
            case SOUTH_EAST:
                return new Vector2d(1, -1);
            case NORTH_EAST:
                return new Vector2d(1, 1);

        }
        return null;
    }

}
