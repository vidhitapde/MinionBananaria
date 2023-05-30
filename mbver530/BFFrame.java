import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class BFFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BFFrame extends JFrame
{
    BFFrame(){
        bananasFoster1 b = new bananasFoster1();
        this.add(b);
        getContentPane().setBackground(new Color(0xFFFFFF));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
    }
}
