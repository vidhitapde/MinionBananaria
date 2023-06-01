import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player 
{
    private Integer score;
    JLabel ScoreLabel;
    MBFrame myFrame;
    /**
     * Constructor for objects of class Player
     */
    public Player(MBFrame frame)
    {
        myFrame = frame;
        score = new Integer(0);
        ScoreLabel = new JLabel("Money: $" + score.toString());
        ScoreLabel.setBounds(10, 10, 100, 50);
    }
    public void updateScore(Integer increment){
        score= (score.intValue() + increment.intValue());
        ScoreLabel.setText("Money: $" + score.toString());
    }
    public void addScore(){
        myFrame.getLayeredPane().add(ScoreLabel);
        myFrame.getLayeredPane().moveToFront(ScoreLabel);
    }
    
}
