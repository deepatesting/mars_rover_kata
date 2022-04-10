package com.techreturners.marsrover;

public class Rover {

    public Position position;
    public Direction direction;

    private String name = "";

    public Rover(String name) {
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
