package cs245quarterproject.src;
//***********************************************************
// This class is BEING IMPLEMENTED FOR VERSION 1.2 (PLEASE IGNORE)
//***********************************************************
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
}
