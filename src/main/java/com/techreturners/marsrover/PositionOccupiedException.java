package com.techreturners.marsrover;

public class PositionOccupiedException extends RuntimeException {
    public PositionOccupiedException() {
        super("Position already occupied by a rover!");
    }
}
