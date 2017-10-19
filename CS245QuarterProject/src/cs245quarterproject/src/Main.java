/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245quarterproject.src;
/**
 * *************************************************************
 * file: Main.java 
 * author: Diaz Disciples (Group name)
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * purpose: Defines the Driver of the entire program
 * **************************************************************
 **/
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author fabian
 */
public class Main {
    public static ArrayList<Score> SCORES = new ArrayList<Score>(); //used later for highscores

    public static void main(String[] args) {
        new TitleScreen();
        new Menu();        
    }
}
