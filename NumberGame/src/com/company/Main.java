package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        int randomNumber = rnd.nextInt(100) + 1;
        boolean hasWon = false;
        System.out.println("I have randomly chosen a number between [1 , 100]\nTry to guess it.");


        try {

            for (int i = 10; i>0; i-- ) {
                System.out.println("You have " + i + " guesses left :");
                int chosenNumber = scanner.nextInt();

                if (chosenNumber > randomNumber) {
                    System.out.println("It's smaller than " + chosenNumber);
                }
                else if (chosenNumber < randomNumber) {
                    System.out.println("It's greater than " + chosenNumber);
                }
                else{
                    hasWon = true;
                    break;
                }
            }

            if (hasWon) {
                System.out.println("\nCORRECT... YOU WIN!");
            } else {
                System.out.println("\nGAME OVER... YOU LOSE!\nThe number was " + randomNumber);
            }

        } catch (InputMismatchException e) {
            System.out.println("You entered bad data.\nRun the program again." );
        }

    }
}
