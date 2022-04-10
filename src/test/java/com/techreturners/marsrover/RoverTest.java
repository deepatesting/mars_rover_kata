package com.techreturners.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @CsvSource( {"0:0:N, 0:1:N",
                "0:1:N, 0:2:N",
                "0:1:E, 1:1:E",
                "1:1:W, 0:1:W",
                "2:2:S, 2:1:S"} )
    public void checkWithMoveForwardMoreTests(String initialPosition, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.moveToDirection("M");

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }


    @ParameterizedTest
    @MethodSource("inputInstructions")
    public void checkWithCommandToMoveRight(String initialPosition, String command, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.moveToDirection(command);

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }

    private static Stream<Arguments> inputInstructions() {
        return Stream.of(
                Arguments.of("0:1:N", "R", "0:1:E"),
                Arguments.of("0:1:E", "R", "0:1:S"),
                Arguments.of("0:1:S", "R", "0:1:W")
        );
    }
}
