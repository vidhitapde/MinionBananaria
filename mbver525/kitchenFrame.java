
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class kitchenFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class kitchenFrame extends JFrame implements ActionListener
{
    JLabel kitchenBack;
    JButton returnButton;
    restaurantFrame rest;
    JLayeredPane kitchenLayers;
    introFrame fr;
    kitchenFrame(introFrame frame){
        ImageIcon kitchenBackIMG = new ImageIcon("assets/kitchen.png");
        ImageIcon returnIMG = new ImageIcon("assets/return.png");
        
        kitchenBack = new JLabel();
        kitchenBack.setIcon(kitchenBackIMG);
        kitchenBack.setBounds(0,0,1000, 750);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(450,450,350,350);
        returnButton.addActionListener(this);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        kitchenLayers = new JLayeredPane();
        
        kitchenLayers.add(returnButton);
        kitchenLayers.add(kitchenBack);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        this.add(kitchenLayers);
        fr= frame;
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == returnButton){
            setVisible(false);
            fr.getRest().setVisible(true);
        }
    }
}
