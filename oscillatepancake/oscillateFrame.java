import javax.swing.JFrame;
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to J and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class oscillateFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class oscillateFrame extends JFrame
{
    Oscillate pancake;
    oscillateFrame( ){
      
        pancake = new Oscillate(this);
        this.add(pancake);
        
        getContentPane().setBackground(new Color(0x87AE73));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
    }
    
}
