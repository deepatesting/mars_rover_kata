package com.techreturners.marsrover;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private final int lowerBoundX = 0;
    private final int lowerBoundY = 0;
    private final int upperBoundX;
    private final int upperBoundY;

    public List<Rover> rovers = new ArrayList<Rover>();

    public Plateau(int upperBoundCoordinateX, int upperBoundCoordinateY) {
        this.upperBoundX = upperBoundCoordinateX;
        this.upperBoundY = upperBoundCoordinateY;
    }

    public void addRover(Rover rover) {
        rovers.add(rover);
    }

    public int getUpperBoundX() {
        return upperBoundX;
    }

    public int getUpperBoundY() {
        return upperBoundY;
    }

    public int getLowerBoundX() {
        return lowerBoundX;
    }

    public int getLowerBoundY() {
        return lowerBoundY;
    }

    public boolean isOccupied(Position position) {
        for (Rover r : rovers) {
            if ( (r.getPosition().getX() == position.getX()) &&
                    (r.getPosition().getY() == position.getY()) )
                return true;
        }
        return false;
    }

}
