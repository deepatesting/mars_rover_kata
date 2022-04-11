package com.techreturners.marsrover;

public class RoverNotPlacedException extends RuntimeException {
    public RoverNotPlacedException() {
        super("Rover cannot be placed out of Bounds of the plateau!");
    }
}
