package com.techreturners.marsrover;

public class Direction {


    public Direction(){

    }
    public Position moveForward(Position position, String currentDirection){

        int x = position.getX();
        int y = position.getY();
        String name = "";

        DirectionList[] directionList = DirectionList.values();

        for (DirectionList valueList : directionList)
        {
            //System.out.println(valueList);

            if ( (valueList.getValue()).equals(currentDirection) ) {
                name = valueList.name();
                System.out.println(name);
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
