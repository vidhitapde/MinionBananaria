import javax.swing.JFrame;
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class MyFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyFrame extends JFrame
{
    DragPanel dragPanel = new DragPanel(); 

    //boolean collision;     
    
    MyFrame()
    {

        //collision = false;

        this.add(dragPanel); 
        this.setTitle("Drag & Drop Pie Ingredients"); 
        this.setSize(600,600); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true);
    }
}
