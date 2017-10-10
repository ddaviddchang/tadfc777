package cs245quarterproject.src;
/**
 * *************************************************************
 * file: Words.java
 * author: Tomik Aghajanian 
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 *
 * assignment: Program 1 date last modified: 10/09/2017
 *
 * purpose: Defines a word bank class
 * **************************************************************
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

//class: WordBank
//purpose of class: This class returns a word to the PlayScreen and it also creates the format of the hint.
public class Words {
    private Random random;
    private final int SIZE;
    public int iterator;
    private final List<String> wordBank;
    private String word;
    private ArrayList<Integer> list;
    
    //constructor: WordBank
    //purpose: This class initiliazes the ArrayList with the words the user should be guessing from.
    //It also initalizes the randomizer to try keep the game a litte more interesting.
    public Words() {
        wordBank = new ArrayList<>();
        wordBank.add("abstract");
        wordBank.add("cemetery");
        wordBank.add("nurse");
        wordBank.add("pharmacy");
        wordBank.add("climbing");
        
        SIZE = wordBank.size(); 
        iterator = 0;
        randomNumList();
    }
    
    //method: getWord
    //purpose: This method returns a random word from the word bank.
    public String getWord() {
        String word = "";
        if(iterator > SIZE) {
            iterator = 0;
        } else {
            this.word = wordBank.get(randomNum());
            iterator++;
            word = this.word;
        }
        return word;
    }

    //method: getWordFormat
    //purpose: This method returns the hint from the word that gets chosen from the word bank.
    public String getWordFormat() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                builder.append(s);
            } else if (i != word.length() -1) {
                builder.append("_ ");
            } else {
                builder.append("_");
            }
        }
        return builder.toString();
    }
       
    //method: randomNumList
    //purpose: This creates a unique random list with number rangn from 0 to the size of the word bank.
    public void randomNumList() {
       list = new ArrayList<Integer>();
        for (int i=0; i<SIZE; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
    }
    
    //method: randomNum
    //pupose: This method gets a random number from the randomNumList.
    public int randomNum() {
        return list.get(iterator);
    }
}