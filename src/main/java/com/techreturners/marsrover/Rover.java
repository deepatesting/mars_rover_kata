package com.techreturners.marsrover;


public class Rover {

    private Plateau plateau;
    private Rover_copy rover;
    public Position position;
    public Direction direction;

    private String name = "";
    private String initialPosition = "";

    public Rover(String name, Plateau plateau, String initialPosition){
        this.name = name;
        this.plateau = plateau;
        this.initialPosition = initialPosition;
    }

    public String getName() {
        return name;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public String getInitialPosition(){
        return initialPosition;
    }

    public void validateLocation() {
        if (position.getX() > plateau.getUpperBoundX()
                || position.getY() > plateau.getUpperBoundY()
                || position.getX() < plateau.getLowerBoundX()
                || position.getY() < plateau.getLowerBoundY()) {
            throw new RoverNotPlacedException();
        }
    }

   /* public boolean hasPosition(Position pos) {
        return position.isEqual(pos);
    }*/

    public void placeRover() {
        String[] initialState = initialPosition.split(":");
        int x = Integer.parseInt(initialState[0]);
        int y = Integer.parseInt(initialState[1]);
        String currentDirection = initialState[2];

        position = new Position(x, y);

        //Get Name by Code - DirectionList - For each direction
        String currentDirectionName = DirectionList.getNameByCode(currentDirection);

        //Create Direction object with current direction name 'NORTH';
        direction = new Direction(currentDirectionName);

        validateLocation();

        System.out.println("Rover size" + plateau.rovers.size());

        if (plateau.isOccupied(position)) {
            System.out.println("HHH");
            throw new PositionOccupiedException();
        }

        plateau.addRover(this);
    }

    public String ExecuteMoves(String stringCommands){

        placeRover();
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

