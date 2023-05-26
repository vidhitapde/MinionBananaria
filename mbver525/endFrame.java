import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class endFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class endFrame extends JFrame
{
    
    /**
     * Constructor for objects of class endFrame
     */
    public endFrame()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
    }

    
}
