package com.techreturners.marsrover;

public class Rover_copy {

    private Plateau plateau;
    private Position position;
    private Direction direction;
    private String name = "";

    public Rover_copy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
