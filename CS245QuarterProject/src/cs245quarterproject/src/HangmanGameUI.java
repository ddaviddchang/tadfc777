package cs245quarterproject.src;

/**
 * *************************************************************
 * file: HangmanGameUI.java 
 * author: Tomik Aghajanian 
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 * assignment: Program 1 date last modified: 10/09/2017
 * purpose: Defines the GUI of the hangman game as well as the logic.
 * **************************************************************
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class HangmanGameUI extends javax.swing.JFrame {

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
     * Creates new form HangmanGameUI
     */
    public HangmanGameUI() {

        initComponents();
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wb = new Words();
        score = "100";
        currentDateAndTime();
        displayWordFormat();
        this.pack();

        this.setVisible(true);
    }

    //method: currentDateAndTime()
    //purpose: Updates the time and date and puts it in the appropriate label
    public void currentDateAndTime() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMMMMMMMM dd, yyyy");
                    Date today = new Date();
                    String date = dateFormat.format(today);

                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    labelDateTime.setText(date + "  " + hour + ":" + minute + ":" + second);
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        };
        clock.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanGameUI().setVisible(true);
            }
        });
    }

    /*
    method: displayGuessedString
    purpose: Checks the user key input and compares with the actual letter. If 
    correct, updates the letter in screen if not reduces the score and disables the keys
    */
    public void displayGuessedString() throws InterruptedException {
        numWrong = wordChecker.numberOfWrongGuesses;
        jLabel6.setText(guessedString);
        if (numWrong > 0 && !guess) {
            if (numWrong <= maxWrong) {
                switch (numWrong) {
                    case 1:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_1.png"))); // NOI18N
                        score = "90";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        break;
                    case 2:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_2.png"))); // NOI18N
                        score = "80";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        break;
                    case 3:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_3.png"))); // NOI18N
                        score = "70";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        break;
                    case 4:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_4.png"))); // NOI18N
                        score = "60";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        break;
                    case 5:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_5.png"))); // NOI18N
                        score = "50";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        break;
                    case 6:
                        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/r_6.png"))); // NOI18N
                        score = "40";
                        labelWrongOrCorrect.setText("Incorrect!!!");
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        new GameOverGUI(score);
                        dispose();
                        break;
                }
                scoreLabel.setText(score);
            }
        } else if (guess) {
            labelWrongOrCorrect.setText("Correct!!!");
            if (wordChecker.checkGuesses()) {
                new GameOverGUI(score);
                dispose();
            }
        }
    }

     /*
    method: performSomeTask
    purpose: repetetive work made into a method. This is something that is done
    everytime a key is hit.
    */
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonG = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        labelPictureHangman = new javax.swing.JLabel();
        labelDateTime = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelWrongOrCorrect = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTitle.setText("HANGMAN");
        getContentPane().add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        buttonA.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonA.setText("A");
        buttonA.setAlignmentY(0.0F);
        buttonA.setIconTextGap(0);
        buttonA.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonA.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonA.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });
        getContentPane().add(buttonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 300, 31, 25));

        buttonB.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonB.setText("B");
        buttonB.setAlignmentY(0.0F);
        buttonB.setIconTextGap(0);
        buttonB.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonB.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonB.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });
        getContentPane().add(buttonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 300, 31, 25));

        buttonC.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonC.setText("C");
        buttonC.setAlignmentY(0.0F);
        buttonC.setIconTextGap(0);
        buttonC.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonC.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonC.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });
        getContentPane().add(buttonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 300, 31, 25));

        buttonD.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonD.setText("D");
        buttonD.setAlignmentY(0.0F);
        buttonD.setIconTextGap(0);
        buttonD.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonD.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonD.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });
        getContentPane().add(buttonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 300, 31, 25));

        buttonE.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonE.setText("E");
        buttonE.setAlignmentY(0.0F);
        buttonE.setIconTextGap(0);
        buttonE.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonE.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonE.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });
        getContentPane().add(buttonE, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 300, 31, 25));

        buttonF.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonF.setText("F");
        buttonF.setAlignmentY(0.0F);
        buttonF.setIconTextGap(0);
        buttonF.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonF.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonF.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });
        getContentPane().add(buttonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 300, 31, 25));

        buttonG.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonG.setText("G");
        buttonG.setAlignmentY(0.0F);
        buttonG.setIconTextGap(0);
        buttonG.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonG.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonG.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });
        getContentPane().add(buttonG, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 300, 31, 25));

        buttonH.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonH.setText("H");
        buttonH.setAlignmentY(0.0F);
        buttonH.setIconTextGap(0);
        buttonH.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonH.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonH.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });
        getContentPane().add(buttonH, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 300, 31, 25));

        buttonJ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonJ.setText("J");
        buttonJ.setAlignmentY(0.0F);
        buttonJ.setIconTextGap(0);
        buttonJ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonJ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonJ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });
        getContentPane().add(buttonJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 300, 31, 25));

        buttonI.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonI.setText("I");
        buttonI.setAlignmentY(0.0F);
        buttonI.setIconTextGap(0);
        buttonI.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonI.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonI.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });
        getContentPane().add(buttonI, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 300, 31, 25));

        buttonK.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonK.setText("K");
        buttonK.setAlignmentY(0.0F);
        buttonK.setIconTextGap(0);
        buttonK.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonK.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonK.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });
        getContentPane().add(buttonK, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 300, 31, 25));

        buttonL.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonL.setText("L");
        buttonL.setAlignmentY(0.0F);
        buttonL.setIconTextGap(0);
        buttonL.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonL.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonL.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });
        getContentPane().add(buttonL, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 300, 31, 25));

        buttonM.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonM.setText("M");
        buttonM.setAlignmentY(0.0F);
        buttonM.setIconTextGap(0);
        buttonM.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonM.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonM.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });
        getContentPane().add(buttonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 300, 31, 25));

        buttonZ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonZ.setText("Z");
        buttonZ.setAlignmentY(0.0F);
        buttonZ.setIconTextGap(0);
        buttonZ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonZ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonZ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });
        getContentPane().add(buttonZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 330, 31, 25));

        buttonY.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonY.setText("Y");
        buttonY.setAlignmentY(0.0F);
        buttonY.setIconTextGap(0);
        buttonY.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonY.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonY.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });
        getContentPane().add(buttonY, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 330, 31, 25));

        buttonX.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonX.setText("X");
        buttonX.setAlignmentY(0.0F);
        buttonX.setIconTextGap(0);
        buttonX.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonX.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonX.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });
        getContentPane().add(buttonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 330, 31, 25));

        buttonW.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonW.setText("W");
        buttonW.setAlignmentY(0.0F);
        buttonW.setIconTextGap(0);
        buttonW.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonW.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonW.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });
        getContentPane().add(buttonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 330, 31, 25));

        buttonV.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonV.setText("V");
        buttonV.setAlignmentY(0.0F);
        buttonV.setIconTextGap(0);
        buttonV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonV.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonV.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });
        getContentPane().add(buttonV, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 330, 31, 25));

        buttonU.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonU.setText("U");
        buttonU.setAlignmentY(0.0F);
        buttonU.setIconTextGap(0);
        buttonU.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonU.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonU.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });
        getContentPane().add(buttonU, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 330, 31, 25));

        buttonT.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonT.setText("T");
        buttonT.setAlignmentY(0.0F);
        buttonT.setIconTextGap(0);
        buttonT.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonT.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonT.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });
        getContentPane().add(buttonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 330, 31, 25));

        buttonS.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonS.setText("S");
        buttonS.setAlignmentY(0.0F);
        buttonS.setIconTextGap(0);
        buttonS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonS.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonS.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });
        getContentPane().add(buttonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 330, 31, 25));

        buttonR.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonR.setText("R");
        buttonR.setAlignmentY(0.0F);
        buttonR.setIconTextGap(0);
        buttonR.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonR.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonR.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });
        getContentPane().add(buttonR, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 330, 31, 25));

        buttonQ.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonQ.setText("Q");
        buttonQ.setAlignmentY(0.0F);
        buttonQ.setIconTextGap(0);
        buttonQ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonQ.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonQ.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });
        getContentPane().add(buttonQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 330, 31, 25));

        buttonP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonP.setText("P");
        buttonP.setAlignmentY(0.0F);
        buttonP.setIconTextGap(0);
        buttonP.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonP.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonP.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });
        getContentPane().add(buttonP, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 330, 31, 25));

        buttonO.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonO.setText("O");
        buttonO.setAlignmentY(0.0F);
        buttonO.setIconTextGap(0);
        buttonO.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonO.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonO.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });
        getContentPane().add(buttonO, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 330, 31, 25));

        buttonN.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        buttonN.setText("N");
        buttonN.setAlignmentY(0.0F);
        buttonN.setIconTextGap(0);
        buttonN.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonN.setMaximumSize(new java.awt.Dimension(0, 0));
        buttonN.setPreferredSize(new java.awt.Dimension(0, 0));
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });
        getContentPane().add(buttonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 330, 31, 25));

        labelPictureHangman.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelPictureHangman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPictureHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/default.png"))); // NOI18N
        getContentPane().add(labelPictureHangman, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 400, 200));
        getContentPane().add(labelDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, 20));

        jButton1.setText("Skip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 100, -1));

        scoreLabel.setText("100");
        getContentPane().add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 50, 20));

        jLabel1.setText("Score:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 20));

        labelWrongOrCorrect.setForeground(new java.awt.Color(51, 204, 0));
        getContentPane().add(labelWrongOrCorrect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonA, 'a');

    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonB, 'b');
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonC, 'c');
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonD, 'd');
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonE, 'e');
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonF, 'f');
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonG, 'g');
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonH, 'h');
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonJ, 'j');
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonI, 'i');
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonK, 'k');
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonL, 'l');
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonM, 'm');
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonZ, 'z');
    }//GEN-LAST:event_buttonZActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonY, 'y');
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonX, 'x');
    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonW, 'w');
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonV, 'v');
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonU, 'u');
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonT, 't');
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonS, 's');
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonR, 'r');
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonQ, 'q');
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonP, 'p');
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonO, 'o');
    }//GEN-LAST:event_buttonOActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        // TODO add your handling code here:
        performSomeTask(buttonN, 'n');
    }//GEN-LAST:event_buttonNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new GameOverGUI(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelDateTime;
    private javax.swing.JLabel labelPictureHangman;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelWrongOrCorrect;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables

}
