package com.techreturners.marsrover;

public class Plateau {
    private final int lowerBoundX = 0;
    private final int lowerBoundY = 0;
    private final int upperBoundX;
    private final int upperBoundY;

    public Plateau(int upperBoundCoordinateX, int upperBoundCoordinateY) {
        this.upperBoundX = upperBoundCoordinateX;
        this.upperBoundY = upperBoundCoordinateY;
    }

    public int getUpperBoundX() {
        return upperBoundX;
    }

    public int getUpperBoundY() {
        return upperBoundY;
    }

    public int getLowerBoundCoordinateX() {
        return lowerBoundX;
    }

    public int getLowerBoundCoordinateY() {
        return lowerBoundY;
    }
}
