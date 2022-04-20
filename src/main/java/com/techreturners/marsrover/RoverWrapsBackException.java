package com.techreturners.marsrover;

public class RoverWrapsBackException extends RuntimeException {
    public RoverWrapsBackException() {
        super("Rover can't move out of Plateau Bounds. Rover dropped!!!");
    }
}