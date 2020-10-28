package agh.cs.lab1;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString(){
        return this.position.toString()+" "+this.direction;
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
                Vector2d newVector = this.direction.toUnitVector(); // słabe nazwy; co jest nowego w newVector?
                Vector2d check = this.position.add(newVector);
                if(check.x > 0 && check.y >0 && check.x<=4 && check.y<=4) { // po co Pan pisał Vector2d.precedes?
                    this.position = this.position.add(newVector);
                }
                break;

            case BACKWARD:
                Vector2d newVector1 = this.direction.toUnitVector();
                Vector2d check1 = this.position.subtract(newVector1);
                if(check1.x >= 0 && check1.y >=0 && check1.x<=4 && check1.y<=4) {
                    this.position = this.position.subtract(newVector1);
                }
                break;
        }
    }

}
