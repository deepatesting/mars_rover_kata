package com.techreturners.marsrover;

public class Direction {

    private String directionValue = "";

    public Direction(String directionValue){
        this.directionValue = directionValue;
    }

    public String getDirectionValue() {
        return directionValue;
    }

    public void setDirectionValue(String directionValue) {
        this.directionValue =  directionValue;
    }

    public Position moveForward(Position position){

        int x = position.getX();
        int y = position.getY();


        switch(directionValue)
        {
            case "NORTH":
                y++;
                break;
            case "EAST":
                x++;
                break;
            case "SOUTH":
                y--;
                break;
            case "WEST":
                x--;
                break;
            default:
                throw new RuntimeException("Should not get here!");
        }
        return new Position(x,y);
    }

    public Direction moveRight(){

        switch(directionValue)
        {
            case "NORTH":
                directionValue = "EAST";
                break;
            case "EAST":
                directionValue = "SOUTH";
                break;
            case "SOUTH":
                directionValue = "WEST";
                break;
            case "WEST":
                directionValue = "NORTH";
                break;
            default:
                throw new RuntimeException("Should not get here!");
        }
        return new Direction(directionValue);
    }

    public Direction moveLeft(){

        switch(directionValue)
        {
            case "NORTH":
                directionValue = "WEST";
                break;
            case "EAST":
                directionValue = "NORTH";
                break;
            case "SOUTH":
                directionValue = "EAST";
                break;
            case "WEST":
                directionValue = "SOUTH";
                break;
            default:
                throw new RuntimeException("Should not get here!");
        }
        return new Direction(directionValue);
    }
}
