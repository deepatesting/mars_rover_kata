package com.techreturners.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    public void checkFirstTest(){
        //Arrange
        Rover rover = new Rover("0:0:N");

        //Act
        String result = rover.getPosition();

        //Assert
        Assertions.assertEquals("0:0:N", result);
    }

    @Test
    public void checkSecondTest(){
        //Arrange
        Rover rover = new Rover("0:1:N");

        //Act
        String result = rover.getPosition();

        //Assert
        Assertions.assertEquals("0:1:N", result);
    }

}
