
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class introFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class introFrame extends JFrame
{
    JLabel inst;
    restaurantFrame rest;
    introFrame intro;
    kitchenFrame kit;
    /**
     * Constructor for objects of class introFrame
     */
    public introFrame()
    {
        intro = this;
        inst = new JLabel();
        ImageIcon instIMG = new ImageIcon("assets/Instructions.jpg");
        inst.setIcon(instIMG);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        add(inst);
        rest = new restaurantFrame(this);
        kit = new kitchenFrame(this);
        kit.setVisible(false);
        rest.setVisible(false);
        this.setVisible(true);
        Timer timer = new Timer(15000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rest.setVisible(true);
                intro.setVisible(false);
            }
        });
        timer.setRepeats(false);
        timer.start();
        
    }
    public restaurantFrame getRest(){
        return rest;
    }
    public kitchenFrame getKit(){
        return kit;
    }
}
