package com.techreturners.marsrover;

import java.util.Scanner;

public class Main {

    private Plateau plateau;
    private Rover rover;
    private Scanner scanner;
    private String[][] gameBoard = new String[7][7];

    public Main() {

    }

    /*
    public void grid() {
        int numRows = 25;

        for(int row=0; row < numRows; row++)
        {
            if(row == 0) {// if it is the first line we want to print size number of *
                for (int h = 0; h < numRows; h++)
                    if (h != numRows - 1)// prints it all the way to the last one
                        System.out.print("*");
                    else System.out.println("*");
            }
            else if (row == numRows-1) {
                for(int k = 0;k<numRows; k++)
                    System.out.print("*");
                System.out.println();
            }
            else if( (row == (numRows/6)) || (row == (numRows*2/6)) || (row == (numRows*3/6))
                    || (row == (numRows*4/6)) || (row == (numRows*5/6))  ) {
                for(int k = 0;k<numRows; k++)
                    System.out.print("*");
                System.out.println();
            }
            else {
                for (int x = 0; x < numRows; x++) {
                    if ((x == 0) || (x == (numRows/6)) || (x == (numRows*2/6)) || (x == (numRows*3/6))
                            || (x == (numRows*4/6)) || (x == (numRows*5/6)) ) // first column prints a * with print
                        System.out.print("*");
                    else if ((x == numRows - 1)) // last one uses println for the last one to set it to a new line
                        System.out.println("*");
                    else System.out.print(" "); // if it is not the first column or the last will print spaces
                }
            }
        }
    }
*/
    public void plateauGrid() {

        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println("---------------------------");
            for (int j = 0; j < gameBoard[i].length; j++) {
                if(j==0)
                    System.out.print("| ");
                if(gameBoard[i][j] == null)
                    System.out.printf("%s", " ");
                else
                    System.out.printf("%s", gameBoard[i][j]);
                if (j < gameBoard[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    public void marsRover() {
        Integer pValueX, pValueY;
        String rName;
        String rPos;
        String commands;
        String yesOrNo = "Y";
        int positionY = 0;

        scanner = new Scanner(System.in);

        System.out.println("Enter Plateau upper boundary X:");
        pValueX = scanner.nextInt();
        System.out.println("Enter Plateau upper boundary Y:");
        pValueY = scanner.nextInt();

        while( yesOrNo.equals("Y") ){
            System.out.println("Enter Rover name:");
            rName = scanner.next();

            System.out.println("Enter Rover initial position:");
            rPos = scanner.next();

            System.out.println("Enter Rover commands:");
            commands = scanner.next();

            plateau = new Plateau(pValueX, pValueY);
            rover = new Rover(rName, plateau, rPos);

            System.out.println("FinalPosition of Rover " + rover.getName() + " is: " + rover.ExecuteMoves(commands));

            System.out.println("Enter Y/N to continue:");
            yesOrNo = scanner.next();

            if (rover.getPosition().getX() >= 0) {
                for (int i = 6, j = 0; j < gameBoard.length; i--, j++) {
                    if (rover.getPosition().getY() == j)
                        positionY =  i ;
                }
            }
            gameBoard[positionY][rover.getPosition().getX()] = "R";
            plateauGrid();
        }

    }

    public static void main(String[] args) {
        Main userInput = new Main();
        userInput.marsRover();
    }
}
