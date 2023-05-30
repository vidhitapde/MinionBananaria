
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class toppingAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class toppingAction extends AbstractAction
{
    JLabel label;
    bananaSmoothie1 pane;
    Timer timer;
    public toppingAction(JLabel lab, bananaSmoothie1 jpane, Timer tim){
        label = lab;
        pane = jpane;
        timer = tim;
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("holaaaaa");
        timer.setRepeats(false);
        pane.moveDown();
    }
}
