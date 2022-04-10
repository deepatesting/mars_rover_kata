package com.techreturners.marsrover;

public class Rover {

    private String initialPosition = "";
    private Position position;

    public Rover(String initialPosition){
        this.initialPosition = initialPosition;
    }

    public String getPosition(){
        return initialPosition;
    }

    public String moveToDirection(String command){
        String[] initialState= initialPosition.split(":");
        int x = Integer.parseInt(initialState[0]);
        int y = Integer.parseInt(initialState[1]);
        position = new Position(x, y);
        Direction direction = new Direction();
        String currentDirection = initialState[2];

        if(command == "M") {
            position = direction.moveForward(position,  currentDirection);
            return (position.getX() + ":" + position.getY() + ":" + currentDirection);
        }

        return "";
    }
}
