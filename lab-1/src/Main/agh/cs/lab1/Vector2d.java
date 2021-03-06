package agh.cs.lab1;

import java.util.Objects;

public class Vector2d {
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }


    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other) {
        if (other.x <= this.x) {
            if (other.y <= this.y) {
                return true;
            }
        }
        return false;
    }

    public boolean follows(Vector2d other) {
        if (other.x >= this.x) {
            if (other.y >= this.y) {
                return true;
            }
        }
        return false;
    }

    public Vector2d upperRight(Vector2d other) {
        int newX = Math.max(other.x, this.x);
        int newY = Math.max(other.y, this.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int newX = Math.min(other.x, this.x);
        int newY = Math.min(other.y, this.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y == that.y) {
            return true;
        }
        return false;
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

}
