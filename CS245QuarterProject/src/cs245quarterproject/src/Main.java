/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245quarterproject.src;

import javax.swing.*;

/**
 *
 * @author fabian
 */
public class Main {
    public static void main(String[] args) {
        HangmanGameUI hman = new HangmanGameUI();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        TitleScreen title = new TitleScreen();
        frame.add(title);
        frame.setVisible(true);
    }
}
