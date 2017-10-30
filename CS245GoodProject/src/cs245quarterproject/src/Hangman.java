/**
 * *************************************************************
 * file: Hangman.java 
 * author: Diaz Disciples (Group name)
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * purpose: Hangman UI 
 * **************************************************************
 *
 */
package cs245quarterproject.src;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * @author david
 */
public class Hangman extends javax.swing.JPanel {
    
    public Point center;
    public Words wb;
    public char letter;
    public String wordToGuess;
    public String wordToGuessFormat;
    public String guessedString;
    private int numWrong = 0;
    private final int maxWrong = 6;
    private String score;
    public boolean guess;
    public WordChecker wordChecker;

    /**
     * Creates new form HangmanScreen
     */
    public Hangman() {
        //Load components
        initComponents();
        
        //Load Date and Time
        showDate();
        showTime();
        
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        wb = new Words();
        score = "100";
        displayWordFormat();
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

    public void displayGuessedString() throws InterruptedException {
        numWrong = wordChecker.numberOfWrongGuesses;
        jLabel6.setText(guessedString);
        if (numWrong > 0 && !guess) {
            if (numWrong <= maxWrong) {
                switch (numWrong) {
                    case 1:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_1.png"))); // NOI18N
                        score = "90";
                        labelWrongOrCorrect.setText("Incorrect!");
                        break;
                    case 2:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_2.png"))); // NOI18N
                        score = "80";
                        labelWrongOrCorrect.setText("Incorrect!");
                        break;
                    case 3:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_3.png"))); // NOI18N
                        score = "70";
                        labelWrongOrCorrect.setText("Incorrect!");
                        break;
                    case 4:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_4.png"))); // NOI18N
                        score = "60";
                        labelWrongOrCorrect.setText("Incorrect!");
                        break;
                    case 5:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_5.png"))); // NOI18N
                        score = "50";
                        labelWrongOrCorrect.setText("Incorrect!");
                        break;
                    case 6:
                        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_6.png"))); // NOI18N
                        score = "40";
                        labelWrongOrCorrect.setText("Incorrect!");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        endGame(score);
                        break;
                }
                scoreNumber.setText(score);
            }
        } else if (guess) {
            labelWrongOrCorrect.setText("Correct!");
            if (wordChecker.checkGuesses()) {
                endGame(score);
            }
        }
    }
    
    //method: performSomeTask
    //purpose: This method is used to take a letter from a button and then calls 
    //the checkLetter method to see if its found in the word. This method also
    //turns the button off and updates our guessed word string.
    private void performSomeTask(JButton b, char l) {
        b.setEnabled(false);
        guess = wordChecker.checkLetter(l);
        guessedString = wordChecker.guessCorrectlyFormat;
        try {
            displayGuessedString();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //method: displayWordFormat
    //purpose: This method gets the hint, or the "_ _ _" for each word and displays it to the screen.
    public void displayWordFormat() {
        wordToGuess = wb.getWord();
        wordToGuessFormat = wb.getWordFormat();
        wordChecker = new WordChecker(wordToGuess, wordToGuessFormat);
        jLabel5.setText(wordToGuessFormat);
    }
    
    public void endGame(String score){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.repaint();

        CirclePanel gg = new CirclePanel(score);
        frame.add(gg);
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        buttonG = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonA = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        hangmanPicture = new javax.swing.JLabel();
        skip = new javax.swing.JButton();
        scoreNumber = new javax.swing.JLabel();
        scoreTitle = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        labelWrongOrCorrect = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        title.setText("HANGMAN");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        buttonG.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonG.setText("G");
        buttonG.setAlignmentY(0.0F);
        buttonG.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonG.setIconTextGap(0);
        buttonG.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonG.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonG.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });
        add(buttonG, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 330, 31, 25));

        buttonV.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonV.setText("V");
        buttonV.setAlignmentY(0.0F);
        buttonV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonV.setIconTextGap(0);
        buttonV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonV.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonV.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });
        add(buttonV, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 362, 31, 25));

        buttonB.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonB.setText("B");
        buttonB.setAlignmentY(0.0F);
        buttonB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonB.setIconTextGap(0);
        buttonB.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonB.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonB.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });
        add(buttonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 330, 31, 25));

        buttonU.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonU.setText("U");
        buttonU.setAlignmentY(0.0F);
        buttonU.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonU.setIconTextGap(0);
        buttonU.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonU.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonU.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });
        add(buttonU, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 362, 31, 25));

        buttonY.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonY.setText("Y");
        buttonY.setAlignmentY(0.0F);
        buttonY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonY.setIconTextGap(0);
        buttonY.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonY.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonY.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });
        add(buttonY, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 362, 31, 25));

        buttonF.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonF.setText("F");
        buttonF.setAlignmentY(0.0F);
        buttonF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonF.setIconTextGap(0);
        buttonF.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonF.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonF.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });
        add(buttonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 330, 31, 25));

        buttonE.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonE.setText("E");
        buttonE.setAlignmentY(0.0F);
        buttonE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonE.setIconTextGap(0);
        buttonE.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonE.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonE.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });
        add(buttonE, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 330, 31, 25));

        buttonL.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonL.setText("L");
        buttonL.setAlignmentY(0.0F);
        buttonL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonL.setIconTextGap(0);
        buttonL.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonL.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonL.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });
        add(buttonL, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 330, 31, 25));

        buttonH.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonH.setText("H");
        buttonH.setAlignmentY(0.0F);
        buttonH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonH.setIconTextGap(0);
        buttonH.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonH.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonH.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });
        add(buttonH, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 330, 31, 25));

        buttonT.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonT.setText("T");
        buttonT.setAlignmentY(0.0F);
        buttonT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonT.setIconTextGap(0);
        buttonT.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonT.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonT.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });
        add(buttonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 362, 31, 25));

        buttonA.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonA.setText("A");
        buttonA.setAlignmentY(0.0F);
        buttonA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonA.setIconTextGap(0);
        buttonA.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonA.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonA.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });
        add(buttonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 330, 31, 25));

        buttonC.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonC.setText("C");
        buttonC.setAlignmentY(0.0F);
        buttonC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonC.setIconTextGap(0);
        buttonC.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonC.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonC.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });
        add(buttonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 330, 31, 25));

        buttonP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonP.setText("P");
        buttonP.setAlignmentY(0.0F);
        buttonP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonP.setIconTextGap(0);
        buttonP.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonP.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonP.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });
        add(buttonP, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 362, 31, 25));

        buttonX.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonX.setText("X");
        buttonX.setAlignmentY(0.0F);
        buttonX.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonX.setIconTextGap(0);
        buttonX.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonX.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonX.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });
        add(buttonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 362, 31, 25));

        buttonD.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonD.setText("D");
        buttonD.setAlignmentY(0.0F);
        buttonD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonD.setIconTextGap(0);
        buttonD.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonD.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonD.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });
        add(buttonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 330, 31, 25));

        buttonM.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonM.setText("M");
        buttonM.setAlignmentY(0.0F);
        buttonM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonM.setIconTextGap(0);
        buttonM.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonM.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonM.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });
        add(buttonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 330, 31, 25));

        buttonJ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonJ.setText("J");
        buttonJ.setAlignmentY(0.0F);
        buttonJ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonJ.setIconTextGap(0);
        buttonJ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonJ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonJ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });
        add(buttonJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 330, 31, 25));

        buttonI.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonI.setText("I");
        buttonI.setAlignmentY(0.0F);
        buttonI.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonI.setIconTextGap(0);
        buttonI.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonI.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonI.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });
        add(buttonI, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 330, 31, 25));

        buttonQ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonQ.setText("Q");
        buttonQ.setAlignmentY(0.0F);
        buttonQ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonQ.setIconTextGap(0);
        buttonQ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonQ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonQ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });
        add(buttonQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 362, 31, 25));

        buttonR.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonR.setText("R");
        buttonR.setAlignmentY(0.0F);
        buttonR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonR.setIconTextGap(0);
        buttonR.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonR.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonR.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });
        add(buttonR, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 362, 31, 25));

        buttonW.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonW.setText("W");
        buttonW.setAlignmentY(0.0F);
        buttonW.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonW.setIconTextGap(0);
        buttonW.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonW.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonW.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });
        add(buttonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 362, 31, 25));

        buttonK.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonK.setText("K");
        buttonK.setAlignmentY(0.0F);
        buttonK.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonK.setIconTextGap(0);
        buttonK.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonK.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonK.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });
        add(buttonK, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 330, 31, 25));

        buttonS.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonS.setText("S");
        buttonS.setAlignmentY(0.0F);
        buttonS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonS.setIconTextGap(0);
        buttonS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonS.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonS.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });
        add(buttonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 362, 31, 25));

        buttonZ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonZ.setText("Z");
        buttonZ.setAlignmentY(0.0F);
        buttonZ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonZ.setIconTextGap(0);
        buttonZ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonZ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonZ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });
        add(buttonZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 362, 31, 25));

        buttonN.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonN.setText("N");
        buttonN.setAlignmentY(0.0F);
        buttonN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonN.setIconTextGap(0);
        buttonN.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonN.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonN.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });
        add(buttonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 362, 31, 25));

        buttonO.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonO.setText("O");
        buttonO.setAlignmentY(0.0F);
        buttonO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonO.setIconTextGap(0);
        buttonO.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonO.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonO.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });
        add(buttonO, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 362, 31, 25));

        hangmanPicture.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hangmanPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hangmanPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/default.png"))); // NOI18N
        add(hangmanPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 42, -1, 225));

        skip.setText("Skip");
        skip.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });
        add(skip, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 100, 30));

        scoreNumber.setText("100");
        add(scoreNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 270, 50, 20));

        scoreTitle.setText("Score:");
        add(scoreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, 50, 20));

        date.setText("date");
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, -1, 20));

        time.setText("time");
        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 15, -1, 20));

        labelWrongOrCorrect.setForeground(new java.awt.Color(51, 204, 0));
        add(labelWrongOrCorrect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setToolTipText("");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonG, 'g');
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonV, 'v');
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonB, 'b');
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonU, 'u');
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonY, 'y');
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonF, 'f');
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonE, 'e');
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonL, 'l');
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonH, 'h');
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonT, 't');
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonA, 'a');
    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonC, 'c');
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonP, 'p');
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonX, 'x');
    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonD, 'd');
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonM, 'm');
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonJ, 'j');
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonI, 'i');
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonQ, 'q');
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonR, 'r');
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonW, 'w');
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonK, 'k');
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonS, 's');
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonZ, 'z');
    }//GEN-LAST:event_buttonZActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonN, 'n');
    }//GEN-LAST:event_buttonNActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonO, 'o');
    }//GEN-LAST:event_buttonOActionPerformed

    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        //endGame("0");
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.repaint();

        CirclePanel nextPanel = new CirclePanel("0");
        frame.add(nextPanel);
        frame.setVisible(true);
    }//GEN-LAST:event_skipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JButton buttonD;
    private javax.swing.JButton buttonE;
    private javax.swing.JButton buttonF;
    private javax.swing.JButton buttonG;
    private javax.swing.JButton buttonH;
    private javax.swing.JButton buttonI;
    private javax.swing.JButton buttonJ;
    private javax.swing.JButton buttonK;
    private javax.swing.JButton buttonL;
    private javax.swing.JButton buttonM;
    private javax.swing.JButton buttonN;
    private javax.swing.JButton buttonO;
    private javax.swing.JButton buttonP;
    private javax.swing.JButton buttonQ;
    private javax.swing.JButton buttonR;
    private javax.swing.JButton buttonS;
    private javax.swing.JButton buttonT;
    private javax.swing.JButton buttonU;
    private javax.swing.JButton buttonV;
    private javax.swing.JButton buttonW;
    private javax.swing.JButton buttonX;
    private javax.swing.JButton buttonY;
    private javax.swing.JButton buttonZ;
    private javax.swing.JLabel date;
    private javax.swing.JLabel hangmanPicture;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelWrongOrCorrect;
    private javax.swing.JLabel scoreNumber;
    private javax.swing.JLabel scoreTitle;
    private javax.swing.JButton skip;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
