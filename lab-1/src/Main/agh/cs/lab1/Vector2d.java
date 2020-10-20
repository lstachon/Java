package agh.cs.lab1;

public class Vector2d {
    private int x;
    private int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ToString(){
        System.out.println("("+x+","+y+")");
    }
    public boolean precedes(Vector2d other){
        if( other.x <= this.x){
            if(other.y <= this.y){
                return  true;
            }
        }
        return false;
    }
    public boolean follows(Vector2d other){
        if(other.x >= this.x){
            if(other.y >= this.y){
                return true;
            }
        }
        return false;
    }
    public Vector2d upperRight(Vector2d other){
        int newx=Math.max(other.x , this.x);
        int newy=Math.max(other.y, this.y);
        return new Vector2d(newx,newy);
    }

    public Vector2d lowerLeft(Vector2d other){
        int newx=Math.min(other.x , this.x);
        int newy=Math.min(other.y, this.y);
        return new Vector2d(newx,newy);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+ other.x , this.y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x- other.x, this.y-other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if(this.x == that.x && this.y == that.y){
            return true;
        }
        return false;
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }

}
