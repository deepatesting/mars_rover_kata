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

    public String moveToDirection(String stringCommands){

        String[] initialState= initialPosition.split(":");
        int x = Integer.parseInt(initialState[0]);
        int y = Integer.parseInt(initialState[1]);

        String currentDirection = initialState[2];

        position = new Position(x, y);
        Direction direction = new Direction(currentDirection);

        //Get Name by Code - DirectionList - For each direction
        String currentDirectionName = DirectionList.getNameByCode(currentDirection);

        char[] commands = stringCommands.toCharArray();

        for(char c : commands) {

            if ( c == 'M' ) {
                position = direction.moveForward(position, currentDirectionName);
                return (position.getX() + ":" + position.getY() + ":" + currentDirection);
            }
            else if (c == 'R') {
                direction = direction.moveRight(currentDirectionName);

                //Get Code by Name - DirectionList - For directions
                DirectionList directionList1 = DirectionList.valueOf(direction.getDirectionValue());

                return (position.getX() + ":" + position.getY() + ":"
                        + directionList1.getValue());
            }
            else if (c == 'L') {
                direction = direction.moveLeft(currentDirectionName);

                //Get Code by Name - DirectionList - For directions
                DirectionList directionList1 = DirectionList.valueOf(direction.getDirectionValue());

                return (position.getX() + ":" + position.getY() + ":"
                        + directionList1.getValue());
            }
        }
        return "";
    }
}
