package com.techreturners.marsrover;


public class Rover {

    private Plateau plateau;
    public Position position;
    public Direction direction;
    private Position finalPosition;

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

    public Position getFinalPosition() {
        return finalPosition;
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

        //Validate if Rover is within Plateau
        validateLocation();

        //Check if position for rover is already occupied
        if (plateau.isOccupied(position)) {
            throw new PositionOccupiedException();
        }

        //Add rover to plateau list.
        plateau.addRover(this);
    }

    public String ExecuteMoves(String stringCommands){

        //Call placeOrder() to drop rover on the plateau
        placeRover();

        //Execute commands
        char[] commands = stringCommands.toCharArray();

        for(char c : commands) {

            if ( c == 'M' ) {
                //Move Forward Position
                position = direction.moveForward(position);

                //Rover dropped if it reaches Plateau's Upper Boundary position
                if (position.getX() > plateau.getUpperBoundX()
                        || position.getY() > plateau.getUpperBoundY()
                        || position.getX() < plateau.getLowerBoundX()
                        || position.getY() < plateau.getLowerBoundY()) {
                    throw new RoverWrapsBackException();
                }

                //Move Backward Position if rover new position already occupied
                if(plateau.rovers.size() > 0) {
                    for (Rover r : plateau.rovers) {
                        if( (position.getX() == r.getPosition().getX()) &&
                                (position.getY() == r.getPosition().getY()) && (r.getName() != getName()) )
                            position = direction.moveBack(position);   //Move Backward Position if rover already occupied
                    }
                }
            }
            if (c == 'R') {
                //Turn Right
                direction = direction.moveRight();
            }
            if (c == 'L') {
                //Turn Left
                direction = direction.moveLeft();
            }
        }

        //Get Code by Name - DirectionList - For directions
        DirectionList directionList1 = DirectionList.valueOf(direction.getDirectionValue());

        finalPosition = position;

        return (position.getX() + ":" + position.getY() + ":"
                + directionList1.getValue());
    }

}

