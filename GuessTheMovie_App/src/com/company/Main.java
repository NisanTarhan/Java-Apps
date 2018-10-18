package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<String> movieList = new ArrayList<>();
        int count = 0;
        boolean hasWon = false;


        try {
            FileReader movieFile = new FileReader("movieList.txt");
            BufferedReader br = new BufferedReader(movieFile);
            String line;
            while ((line = br.readLine()) != null) {
                movieList.add(line);
                count++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }

        // Choose a random movie
        Random rnd = new Random();
        int randomChoose = rnd.nextInt(count);
        String movieName = movieList.get(randomChoose);
        String movieNameWithoutSpace = movieName.trim().replaceAll("\\s+", "");

        Game game = new Game(movieNameWithoutSpace);
        Scanner scanner = new Scanner(System.in);

        // Guess the letter
        while (game.getWrongGuess() < 10) {
            System.out.println("\nYou are guessing: " + game.getHiddenMovieName());
            System.out.println("You have guessed(" + game.getWrongGuess() + ") wrong letters: ");
            System.out.print("Guess a letter: ");

            while (scanner.hasNextInt()) {
                System.out.println("That's not a letter!");
                System.out.print("Guess a letter: ");
                scanner.next();
            }

            char guessLetter = scanner.next().charAt(0);

            String result = game.HandlingSingleGuess(guessLetter);

            if (result.equals(movieNameWithoutSpace)) {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("You Won!\nYou have guessed '" + movieName + "' correctly.");
        } else {
            System.out.println("You Lose!\nMove's name is " + movieName);
        }
    }
}
