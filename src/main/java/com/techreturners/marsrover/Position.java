package com.techreturners.marsrover;

public class Position {
    private int X;
    private int Y;

     public Position(int x, int y){
        this.X = x;
        this.Y = y;
    }

    /*public Position(Position other) {
        this.X = other.X;
        this.Y = other.Y;
    }

    public boolean isEqual(Position other) {
        return X == other.X && Y == other.Y;
    }*/

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
         this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

}
