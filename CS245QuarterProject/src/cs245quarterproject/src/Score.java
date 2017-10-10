/**
 * *************************************************************
 * file: Score.java author: Fabian Flores
 * class: Computer Programming
 * Graphical User Interfaces - CS245
 *
 * assignment: Program 1 date last modified: 10/10/2017
 *
 * purpose: Score object used to help store highscores
 * **************************************************************
 **/

package cs245quarterproject.src;

/**
 *
 * @author fabian
 */
public class Score {
    private String name;
    private int score;
    
    public Score() {
        name = "John Doe";
        score = 0;
    }
    
    public Score(String n, int s) {
        name = n;
        score = s;
    }
    
    public String getName() { return name; }
    public int getScore() { return score; }
    public void setName(String n) { name = n; }
    public void setScore(int s ) { score = s; }
}0
