package cs245quarterproject.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class: WordChecker
//purpose of class: This class checks for correct word and letters
public class WordChecker {

    public Words words;
    public String wordToGuess;
    public String currentGuessedFormat = "";
    public String guessCorrectlyFormat = "";
    public int numberOfWrongGuesses;
    public int numberOfGuesses;
    public List listOfGuessedLetters;
    public char[] charsToGuessFormat;

    //constructor: WordChecker
    //purpose: Initializes the WordBank Object
    public WordChecker(String word, String format) {
        words = new Words();
        listOfGuessedLetters = new ArrayList<Character>();
        wordToGuess = word;
        numberOfGuesses = 0;
        numberOfWrongGuesses = 0;
        String wordToGuessFormat = format;

        charsToGuessFormat = wordToGuessFormat.toCharArray();
        for (int i = 0; i < charsToGuessFormat.length; i++) {
            if (charsToGuessFormat[i] == '_') {
                charsToGuessFormat[i] = ' ';
            }
        }
    }

    //method: checkGuesses
    //purpose: This method takes what the user has guessed along with what's correct and converts the 2 into char arrays.
    //Then, it sorts the arrays and checks to see if all of the letters are the same. If it is, the user wins, else, the user loses.
    public boolean checkGuesses() {
        char[] charsToGuess = wordToGuess.toCharArray();
        int size = listOfGuessedLetters.size();
        char[] guessedLetters = new char[size];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = (char) listOfGuessedLetters.get(i);
        }

        Arrays.sort(guessedLetters);
        Arrays.sort(charsToGuess);
        return Arrays.equals(charsToGuess, guessedLetters);
    }

    //method: checkLetter
    //purpose: This method checks to see if letter is correct. If it is, it updates the hangman game screen with the 
    //correctly guessed letter above the "_". If the user guesses incorrectly, it returns false
    public boolean checkLetter(char guessedLetter) {
        boolean result = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                int index = i * 2;
                listOfGuessedLetters.add(guessedLetter);
                charsToGuessFormat[index] = guessedLetter;
                result = true;
            }
        }

        if (result) {
            numberOfGuesses++;
            guessCorrectlyFormat = String.valueOf(charsToGuessFormat);
            currentGuessedFormat = guessCorrectlyFormat;
        } else {
            numberOfGuesses++;
            numberOfWrongGuesses++;
            guessCorrectlyFormat = currentGuessedFormat;
        }
        return result;
    }

}
