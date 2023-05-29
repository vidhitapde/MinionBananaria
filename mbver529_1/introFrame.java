
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
public class introFrame extends JFrame implements ActionListener
{
    JLabel inst;
    restaurantFrame rest;
    
    kitchenFrame kit;
    JButton exit;
    JLayeredPane instLayers;
    /**
     * Constructor for objects of class introFrame
     */
    public introFrame()
    {
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        
        ImageIcon instIMG = new ImageIcon("assets/Instructions.jpg");
        inst = new JLabel();
        inst.setIcon(instIMG);
        inst.setBounds(0,0,1000,750);
        
        ImageIcon exitIMG = new ImageIcon("assets/exit.png");
        exit = new JButton();
        exit.setIcon(exitIMG);
        exit.setBounds(775, 30, 75, 75);
        exit.addActionListener(this);
        exit.setBackground(new Color(0x000000));
        exit.setContentAreaFilled(false);
        exit.setBorder(null);
        
        instLayers = new JLayeredPane();
        instLayers.setBounds(0,0, 1000, 750);
        
        instLayers.add(exit);
        instLayers.add(inst);
        
        rest = new restaurantFrame(this);
        kit = new kitchenFrame(this);
        
        this.add(instLayers);
        
        kit.setVisible(false);
        rest.setVisible(false);
        
        this.setVisible(true);
        
        
    }
     public void actionPerformed(ActionEvent event){
        if(event.getSource() == exit){
            setVisible(false);
            rest.setVisible(true);
        }
    }
    public restaurantFrame getRest(){
        return rest;
    }
    public kitchenFrame getKit(){
        return kit;
    }
}