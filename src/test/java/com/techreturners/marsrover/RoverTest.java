package com.techreturners.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
        String result = rover.ExecuteMoves("M");

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }


    @ParameterizedTest
    @MethodSource("inputInstructionsForRIGHT")
    public void checkWithCommandToMoveRight(String initialPosition, String command, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.ExecuteMoves(command);

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }

    private static Stream<Arguments> inputInstructionsForRIGHT() {
        return Stream.of(
                Arguments.of("0:1:N", "R", "0:1:E"),
                Arguments.of("0:1:E", "R", "0:1:S"),
                Arguments.of("0:1:S", "R", "0:1:W")
        );
    }

    @ParameterizedTest
    @MethodSource("inputInstructionsForLEFT")
    public void checkWithCommandToMoveLeft(String initialPosition, String command, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.ExecuteMoves(command);

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }

    private static Stream<Arguments> inputInstructionsForLEFT() {
        return Stream.of(
                Arguments.of("0:1:N", "L", "0:1:W"),
                Arguments.of("0:1:E", "L", "0:1:N"),
                Arguments.of("0:1:S", "LLL", "0:1:W")
        );
    }

    @ParameterizedTest
    @MethodSource("input1InstructionsForMIXED")
    public void checkWithCommandToMoveDIFF1(String initialPosition, String command, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.ExecuteMoves(command);

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }

    private static Stream<Arguments> input1InstructionsForMIXED() {
        return Stream.of(
                Arguments.of("1:2:N", "L", "1:2:W"),
                Arguments.of("1:2:N", "LM", "0:2:W"),
                Arguments.of("1:2:N", "LML", "0:2:S"),
                Arguments.of("1:2:N", "LMLM", "0:1:S"),
                Arguments.of("1:2:N", "LMLML", "0:1:E"),
                Arguments.of("1:2:N", "LMLMLM", "1:1:E"),
                Arguments.of("1:2:N", "LMLMLML", "1:1:N"),
                Arguments.of("1:2:N", "LMLMLMLM", "1:2:N"),
                Arguments.of("1:2:N", "LMLMLMLMM", "1:3:N")
        );
    }

    @ParameterizedTest
    @MethodSource("input2InstructionsForMIXED")
    public void checkWithCommandToMoveDIFF2(String initialPosition, String command, String expectedPosition){
        //Arrange
        Rover rover = new Rover(initialPosition);

        //Act
        String result = rover.ExecuteMoves(command);

        //Assert
        Assertions.assertEquals(expectedPosition, result);
    }

    private static Stream<Arguments> input2InstructionsForMIXED() {
        return Stream.of(
                Arguments.of("3:3:E", "M", "4:3:E"),
                Arguments.of("3:3:E", "MM", "5:3:E"),
                Arguments.of("3:3:E", "MMR", "5:3:S"),
                Arguments.of("3:3:E", "MMRM", "5:2:S"),
                Arguments.of("3:3:E", "MMRMM", "5:1:S"),
                Arguments.of("3:3:E", "MMRMMR", "5:1:W"),
                Arguments.of("3:3:E", "MMRMMRM", "4:1:W"),
                Arguments.of("3:3:E", "MMRMMRMR", "4:1:N"),
                Arguments.of("3:3:E", "MMRMMRMRR", "4:1:E"),
                Arguments.of("3:3:E", "MMRMMRMRRM", "5:1:E")
        );
    }
}
