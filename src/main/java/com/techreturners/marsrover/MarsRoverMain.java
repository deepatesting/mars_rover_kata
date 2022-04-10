package com.techreturners.marsrover;


public class MarsRoverMain {

    private Plateau plateau;
    private Rover rover;
    public Position position;
    public Direction direction;

    private String initialPosition = "";

    public MarsRoverMain(Plateau plateau, String initialPosition){
        this.plateau = plateau;
        this.initialPosition = initialPosition;
    }

    public String getPosition(){
        return initialPosition;
    }


    public String ExecuteMoves(String stringCommands){

        String[] initialState = initialPosition.split(":");
        int x = Integer.parseInt(initialState[0]);
        int y = Integer.parseInt(initialState[1]);
        String currentDirection = initialState[2];

        position = new Position(x, y);

        //Get Name by Code - DirectionList - For each direction
        String currentDirectionName = DirectionList.getNameByCode(currentDirection);

        //Create Direction object with current direction name 'NORTH';
        direction = new Direction(currentDirectionName);

        char[] commands = stringCommands.toCharArray();

        for(char c : commands) {

            if ( c == 'M' ) {
                position = direction.moveForward(position);
            }
            if (c == 'R') {
                direction = direction.moveRight();
            }
            if (c == 'L') {
                direction = direction.moveLeft();
            }
        }

        //Get Code by Name - DirectionList - For directions
        DirectionList directionList1 = DirectionList.valueOf(direction.getDirectionValue());

        return (position.getX() + ":" + position.getY() + ":"
                + directionList1.getValue());
    }
}

