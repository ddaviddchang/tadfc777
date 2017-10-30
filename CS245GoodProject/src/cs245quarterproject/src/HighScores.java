/**
 * *************************************************************
 * file: HighScores.java 
 * author: Diaz Disciples (Group name)
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * purpose: Tracks the high scores
 * **************************************************************
 *
 */
package cs245quarterproject.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 */
public class HighScores extends javax.swing.JPanel {
    public HighScores() {
        initComponents();
        
        //Variable Declarations
        String[] array = new String[5];
        int i = 0;
        Scanner input;
        
        //Open "data.text" and save into array
        try {
            input = new Scanner(new File("data.text"));
            while(input.hasNextLine()){
                array[i] = input.nextLine();
                i++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //Set JLabel values 
        one.setText(array[0]);
        two.setText(array[1]);
        three.setText(array[2]);
        four.setText(array[3]);
        five.setText(array[4]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        highscoreText = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        five = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("Back");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.setPreferredSize(new java.awt.Dimension(85, 25));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 40));

        highscoreText.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        highscoreText.setForeground(new java.awt.Color(0, 51, 255));
        highscoreText.setText("HIGHSCORES");
        add(highscoreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        one.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        one.setText("ABC ..... 00000");
        add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        two.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        two.setText("ABC ..... 00000");
        add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        three.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        three.setText("ABC ..... 00000");
        add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        four.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        four.setText("ABC ..... 00000");
        add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        five.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        five.setText("ABC ..... 00000");
        add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        //Remove current JPanel and add new one
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.repaint();
        
        Menu m = new Menu();
        frame.add(m);
        frame.setVisible(true);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JLabel highscoreText;
    private javax.swing.JLabel one;
    private javax.swing.JLabel three;
    private javax.swing.JLabel two;
    // End of variables declaration//GEN-END:variables
}
