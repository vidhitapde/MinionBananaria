import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class BSFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSFrame extends JFrame
{
    bananaSmoothie1 test;
    two test2;
    JLabel banana;
    BSFrame(){
        ImageIcon bananapudding = new ImageIcon("assets/bananapudding");
        JLabel banana = new JLabel();
        banana.setIcon(bananapudding);
        test = new bananaSmoothie1(this);
        this.add(test);
        
        getContentPane().setBackground(new Color(0x87AE73));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
    }
    public void removeTest(){
        this.add(banana);
        this.remove(test);
        repaint();
        
    }
    
}
