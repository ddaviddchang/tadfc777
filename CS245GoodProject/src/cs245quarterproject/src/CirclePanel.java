/**
 * *************************************************************
 * file: Credits.java 
 * author: Diaz Disciples (Group name)
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * purpose: Circle Panel game
 * **************************************************************
 *
 */
package cs245quarterproject.src;

import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Stream17
 */
public class CirclePanel extends javax.swing.JPanel implements ChangeListener, ActionListener {
    private ArrayList<JButton> buttonList = new ArrayList();
    private ArrayList<JLabel> labelList = new ArrayList();
    private String[]Colors = {"Red","Yellow","Blue","Purple","Green"};
    private Color[]fontColors = {Color.red, Color.yellow, Color.blue, Color.magenta, Color.green};
    private final int TOTAL_CIRCLES = 10;
    private final int TOTAL_LABELS = 8;
    private String actualColor;
    private int rounds = 0;
    private int gameScore;
    /**
     * Creates new form CirclePanel
     */
    public CirclePanel(String score) {
        
        
        gameScore = Integer.parseInt(score);
        initComponents();
        setVisible(true);
        setOpaque(true);
        
        //Load Date and Time
        showDate();
        showTime();
        
        buttonList.add(CircleButton1);
        buttonList.add(CircleButton2);
        buttonList.add(CircleButton3);
        buttonList.add(CircleButton4);
        buttonList.add(CircleButton5);
        buttonList.add(CircleButton6);
        buttonList.add(CircleButton7);
        buttonList.add(CircleButton8);
        buttonList.add(CircleButton9);
        buttonList.add(CircleButton10);
        labelList.add(colorLabel1);
        labelList.add(colorLabel2);
        labelList.add(colorLabel3);
        labelList.add(colorLabel4);
        labelList.add(colorLabel5);
        labelList.add(colorLabel6);
        labelList.add(colorLabel7);
        labelList.add(colorLabel8);
        spawnLabel();
        initCircleButtons();
        spawnButtons();
    }
    
    //Show "date"
    void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
        date.setText(s.format(d));
    }
    
    //Show "time"
    void showTime(){
        new Timer(0, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                time.setText(s.format(d));
            }
        }).start();
    }
    
    /**
     * Incomplete method
     * spawnButtons() shuffles the contents of the buttonList which contains
     * all of this panels circle buttons. It then sets the action commands and icons 
     * of the first five buttons in the shuffled collection to their designated color from
     * Colors[]
     */
    private void spawnButtons(){
        Collections.shuffle(buttonList);
        for(int i = 0; i < 5; i++){
            buttonList.get(i).setActionCommand(Colors[i]);
            buttonList.get(i).setIcon(new ImageIcon(Colors[i] + "Button.png"));
        }
        
        for(int i = 5; i < TOTAL_CIRCLES; i++){
            buttonList.get(i).setActionCommand("Nothing");
            buttonList.get(i).setIcon(null);
        }
    }
    
    /**
     * spawnLabel starts by setting the text of all labels to null
     * then it shuffles the list of labels
     * it generates a random number and then picks the color and text based on that number
     */
    private void spawnLabel(){
        initColorLabels();
        Collections.shuffle(labelList);
        Random random = new Random();
        
        //generate first random number for the text to be displayed and set the font of the button
        //set the text for the first button in the arraylist
        int textNumber = random.nextInt(5);
        labelList.get(0).setText(Colors[textNumber]);
        labelList.get(0).setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
        
        //get another random number for and use that one to set the text color for the label;
        textNumber = random.nextInt(5);
        labelList.get(0).setForeground(fontColors[textNumber]);
        
        //Set the string for actualColor equal to the color that was used from fontColors;
        switch (textNumber) {
            case 0:
                actualColor = "Red";
                break;
            case 1:
                actualColor = "Yellow";
                break;
            case 2:
                actualColor = "Blue";
                break;
            case 3:
                actualColor = "Purple";
                break;
            case 4:
                actualColor = "Green";
                break;
        }
    }
    
    /**
     * This method gets rid of the backgrounds of all the buttons in 
     * buttonList and also registers this panel as their action and change
     * listeners.
     */
    private void initCircleButtons(){
        for(int i = 0; i < TOTAL_CIRCLES; i++){
            buttonList.get(i).addActionListener(this);
            buttonList.get(i).addChangeListener(this);
            buttonList.get(i).setContentAreaFilled(false);
            buttonList.get(i).setBorderPainted(false);
            buttonList.get(i).setBorder(BorderFactory.createEmptyBorder());
        }
    }
    
    private void initColorLabels(){
        for(int i = 0; i < TOTAL_LABELS; i++){
            labelList.get(i).setText(null);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CircleButton1 = new javax.swing.JButton();
        CircleButton2 = new javax.swing.JButton();
        CircleButton3 = new javax.swing.JButton();
        CircleButton4 = new javax.swing.JButton();
        CircleButton5 = new javax.swing.JButton();
        CircleButton6 = new javax.swing.JButton();
        CircleButton7 = new javax.swing.JButton();
        CircleButton8 = new javax.swing.JButton();
        CircleButton9 = new javax.swing.JButton();
        CircleButton10 = new javax.swing.JButton();
        colorLabel1 = new javax.swing.JLabel();
        colorLabel2 = new javax.swing.JLabel();
        colorLabel3 = new javax.swing.JLabel();
        colorLabel4 = new javax.swing.JLabel();
        colorLabel5 = new javax.swing.JLabel();
        colorLabel6 = new javax.swing.JLabel();
        colorLabel7 = new javax.swing.JLabel();
        colorLabel8 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(CircleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, 100));

        CircleButton2.setContentAreaFilled(false);
        CircleButton2.setBorderPainted(false);
        CircleButton2.setBorder(BorderFactory.createEmptyBorder());
        CircleButton2.addChangeListener(this);
        CircleButton2.addActionListener(this);
        add(CircleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, 100));
        add(CircleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 100));
        add(CircleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 100, 100));
        add(CircleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 100, 100));
        add(CircleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 100, 100));
        add(CircleButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 100, 100));
        add(CircleButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 100, 100));
        add(CircleButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 100, 100));
        add(CircleButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 100));

        colorLabel1.setText("fdsaf");
        add(colorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 90, 25));

        colorLabel2.setText("test");
        add(colorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 90, 25));

        colorLabel3.setText("fdasfads");
        add(colorLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, 25));

        colorLabel4.setText("fdsafdsa");
        add(colorLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 90, 25));

        colorLabel5.setText("fdas");
        add(colorLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 70, 25));

        colorLabel6.setText("jLabel1");
        add(colorLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 80, 25));

        colorLabel7.setText("jLabel1");
        add(colorLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 80, 25));

        colorLabel8.setText("jLabel1");
        add(colorLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 70, 25));

        date.setText("date");
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, -1, 20));

        time.setText("time");
        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 15, -1, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CircleButton1;
    private javax.swing.JButton CircleButton10;
    private javax.swing.JButton CircleButton2;
    private javax.swing.JButton CircleButton3;
    private javax.swing.JButton CircleButton4;
    private javax.swing.JButton CircleButton5;
    private javax.swing.JButton CircleButton6;
    private javax.swing.JButton CircleButton7;
    private javax.swing.JButton CircleButton8;
    private javax.swing.JButton CircleButton9;
    private javax.swing.JLabel colorLabel1;
    private javax.swing.JLabel colorLabel2;
    private javax.swing.JLabel colorLabel3;
    private javax.swing.JLabel colorLabel4;
    private javax.swing.JLabel colorLabel5;
    private javax.swing.JLabel colorLabel6;
    private javax.swing.JLabel colorLabel7;
    private javax.swing.JLabel colorLabel8;
    private javax.swing.JLabel date;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    @Override
    /**
     * The method stateChanged is used to swap the pictures of a button when the mouse is rolled over it.
     * It gets the color by getting the source of the change event ce and getting the action command of
     * its source.
     * 
     * It then gets the source's ButtonModel and checks to see if the mouse is rolled over it.
     * The sources icon is then set to the appropriate picture.
     * @param ce the changeEvent passed into this method
     */
    public void stateChanged(ChangeEvent ce) {
        String color = ((JButton)ce.getSource()).getActionCommand();
        ButtonModel mod = ((JButton)ce.getSource()).getModel();
        if(mod.isRollover())
             ((JButton)ce.getSource()).setIcon(new ImageIcon(color + "ButtonRollover.png"));
        
        if(!mod.isRollover())
            ((JButton)ce.getSource()).setIcon(new ImageIcon(color + "Button.png"));
    }

    @Override
    /**
     * this method respawns the labels and buttons
     * after 5 rounds it goes to the next panel
     */
    public void actionPerformed(ActionEvent ae) {
        if(!((JButton)ae.getSource()).getActionCommand().equals("Nothing")){
            checkColor(((JButton)ae.getSource()).getActionCommand());
            spawnButtons();
            spawnLabel();
        }
    }
    
    private void checkColor(String buttonColor){
        if(buttonColor.equals(actualColor)){
            gameScore += 100;
        }
        rounds++;
        if(rounds == 5)
            endGame();
        
    }
    
    public void endGame(){
        String endScore = "";
        endScore += gameScore;
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.repaint();

        Sudoku game = new Sudoku(endScore);
        frame.add(game);
        frame.setVisible(true);
    }    
}
