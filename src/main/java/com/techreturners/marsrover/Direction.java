package com.techreturners.marsrover;

public class Direction {


    public Direction(){

    }
    public Position moveForward(Position position, String currentDirection){

        int x = position.getX();
        int y = position.getY();
        String name = "";

        DirectionList[] directionList = DirectionList.values();

        for (DirectionList value : directionList)
        {
            if ( value.equals(currentDirection) ) {
                name = value.name();
                System.out.println();
            }
        }

        switch(name)
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
}
