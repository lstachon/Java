package agh.cs.lab1;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    private Vector2d startPosition;

    public void Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.startPosition = initialPosition;
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
        return "error";
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
                if(this.map.canMoveTo(position)) {
                    Vector2d newVector = this.direction.toUnitVector();
                    Vector2d check = this.position.add(newVector);
                    if (check.x > 0 && check.y > 0 && check.x <= 4 && check.y <= 4) {
                        this.position = this.position.add(newVector);
                    }
                }
                break;

            case BACKWARD:
                if(this.map.canMoveTo(position)) {
                Vector2d newVector1 = this.direction.toUnitVector();
                Vector2d check1 = this.position.subtract(newVector1);
                if(check1.x >= 0 && check1.y >=0 && check1.x<=4 && check1.y<=4) {
                    this.position = this.position.subtract(newVector1);
                }}

                break;
        }
    }

}
