package com.company;

public class Game {
    private int wrongGuess;
    private String movieName;
    private String hiddenMovieName;

    public Game(String movieName) {
        this.wrongGuess = 0;
        this.movieName = movieName;
        this.hiddenMovieName = getHiddenMovieName(movieName);
    }

    private String getHiddenMovieName(String movieName) {
        hiddenMovieName = movieName.replaceAll("[a-zA-Z]", "_");
        return hiddenMovieName;
    }

    public String HandlingSingleGuess(char guessLetter) {
        char[] letters = movieName.toCharArray();
        char[] hiddenLetters = hiddenMovieName.toCharArray();

        if (movieName.indexOf(guessLetter) >= 0) {
            for (int i = 0; i < movieName.length(); i++) {
                if (letters[i] == guessLetter) {
                    hiddenLetters[i] = guessLetter;
                }
            }
        } else {
            wrongGuess++;
        }

        hiddenMovieName = String.valueOf(hiddenLetters);
        return hiddenMovieName;
    }

    public int getWrongGuess() {
        return wrongGuess;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getHiddenMovieName() {
        return hiddenMovieName;
    }
}
