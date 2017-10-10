/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245quarterproject.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class: CheckWord
//purpose of class: This class checks to see if the user guesses the word and letters correctly.
public class CheckWord {

    public int numWrongGuesses;
    public int numGuesses;
    public Words wb;
    public String wordToGuess;
    public List guessedLettersList;
    public char[] charsToGuessFormat;
    public String currentGuessedFormat = "";
    public String correctlyGuessedFormat = "";

    //constructor: CheckWord
    //purpose: Initializes the WordBank Object, along with the number of guesses and wrong guesses, as well as the format of the 
    //hint in order to check if the user guesses correctly.
    public CheckWord(String word, String format) {
        wb = new Words();
        guessedLettersList = new ArrayList<Character>();
        wordToGuess = word;
        numGuesses = 0;
        numWrongGuesses = 0;
        String wordToGuessFormat = format;

        charsToGuessFormat = wordToGuessFormat.toCharArray();
        for (int i = 0; i < charsToGuessFormat.length; i++) {
            if (charsToGuessFormat[i] == '_') {
                charsToGuessFormat[i] = ' ';
            }
        }
    }

    //method: checkLetter
    //purpose: This method checks to see if the letter the user entered is correct at not. If it is,
    //it updates the playscreen with the correctly guessed letter above the "_". If the user guesses incorrectly,
    //it returns false, which is how PlayScreen alerts the user if their choice is incorrect.
    public boolean checkLetter(char guessedLetter) {
        boolean result = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                int index = i * 2;
                guessedLettersList.add(guessedLetter);
                charsToGuessFormat[index] = guessedLetter;
                result = true;
            }
        }

        if (result) {
            numGuesses++;
            correctlyGuessedFormat = String.valueOf(charsToGuessFormat);
            currentGuessedFormat = correctlyGuessedFormat;
        } else {
            numGuesses++;
            numWrongGuesses++;
            correctlyGuessedFormat = currentGuessedFormat;
        }
        return result;
    }

    //method: checkGuesses
    //purpose: This method takes what the user has guessed along with what's correct and converts the 2 into char arrays.
    //Then, it sorts the arrays and checks to see if all of the letters are the same. If it is, the user wins, else, the user loses.
    public boolean checkGuesses() {
        char[] charsToGuess = wordToGuess.toCharArray();
        int size = guessedLettersList.size();
        char[] guessedLetters = new char[size];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = (char) guessedLettersList.get(i);
        }

        Arrays.sort(guessedLetters);
        Arrays.sort(charsToGuess);
        return Arrays.equals(charsToGuess, guessedLetters);
    }
}
