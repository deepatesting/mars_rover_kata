package com.techreturners.marsrover;

public class Rover {

    private String position = "";

    public Rover(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public String moveToDirection(String command){
        String[] initialPosition = position.split(":");
        int x = Integer.parseInt(initialPosition[0]);
        int y = Integer.parseInt(initialPosition[1]);
        String direction = initialPosition[2];

        if(command == "M") {
            switch(direction)
            {
                case "N":
                    y++;
                    break;
                case "E":
                    x++;
                    break;
                case "S":
                    y--;
                    break;
                case "W":
                    x--;
                    break;
            }
            return (x + ":" + y + ":" + direction);
        }

        return "";
    }
}
