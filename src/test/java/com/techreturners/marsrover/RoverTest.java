package com.techreturners.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoverTest {

    @ParameterizedTest
    @ValueSource(strings = {"0:0:N",
                            "0:1:N"})
    public void checkFirstTest(String initialPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.getPosition();

        //Assert
        Assertions.assertEquals(initialPosition, result);
    }

}
