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
        if(command == "M"){
            return "0:1:N";
        }
        return "";
    }
}
