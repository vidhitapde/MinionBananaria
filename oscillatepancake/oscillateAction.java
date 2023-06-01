
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class oscillateAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class oscillateAction extends AbstractAction
{
    JLabel label;
    Oscillate pane;
    Timer timer;
    public oscillateAction(JLabel lab, Oscillate jpane, Timer tim){
        label = lab;
        pane = jpane;
        timer = tim;
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("holaaaaa");
        timer.setRepeats(false);
        if (label == pane.bp) {
            pane.movePancakeOneDown();
        } else if (label == pane.pan) {
            pane.movePancakeTwoDown();
        } else if (label == pane.pancakes)
        {
            pane.movePancakeThreeDown(); 
        }
    }
}

