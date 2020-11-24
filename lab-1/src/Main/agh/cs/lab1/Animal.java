package agh.cs.lab1;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition(){
        return position;
    }

    @Override
    public String toString(){
        switch (this.direction){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
        };
        return null;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT:
                this.direction = this.direction.previous();
                break;

            case RIGHT:
                this.direction = this.direction.next();
                break;

            case FORWARD:
                    Vector2d newVector = this.direction.toUnitVector();
                    if (this.map.canMoveTo(position.add(newVector)) && !this.map.isOccupied(position.add(newVector))){
                        this.position = this.position.add(newVector);
                    }
                break;

            case BACKWARD:
                Vector2d newVector1 = this.direction.toUnitVector();
                if(this.map.canMoveTo(position.subtract(newVector1)) && !this.map.isOccupied(position.subtract(newVector1))) {
                    this.position = this.position.subtract(newVector1);
                }

                break;
        }
    }

}
