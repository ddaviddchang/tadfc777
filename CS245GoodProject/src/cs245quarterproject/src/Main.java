/**
 * *************************************************************
 * file: Main.java 
 * author: Diaz Disciples (Group name)
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * purpose: Main, initiates program
 * **************************************************************
 *
 */
package cs245quarterproject.src;

import javax.swing.*;

/*
 */

public class Main {
    public static void main(String[] args) {
        //1) Create JFrame
        JFrame frame = new JFrame("The Gauntlet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        //2) Start "TitleScreen"
        TitleScreen title = new TitleScreen();
        frame.add(title);
        frame.setVisible(true);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        //Add 3 second delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
        //3) Start "Menu"
        frame.remove(title);
        frame.setVisible(false);
        
        
        Menu menu = new Menu();
        frame.add(menu);
        frame.setVisible(true);
    }
}
