
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
    
    restaurantFrame rest;
    
    introFrame fr;
    restaurant myRestaurant;
    food currentOrder;
    bananaSmoothie1 mybs;
    JButton BSreturnButton;
    kitchenFrame(introFrame frame){
        fr= frame;
        rest = fr.getRest();
        myRestaurant = rest.getRestaurant();
        currentOrder = myRestaurant.getMyOrder();
        
        
        if(currentOrder instanceof bananaSmoothie){
            mybs = new bananaSmoothie1(this);
            this.add(mybs);
            BSreturnButton = mybs.getRestaurantButton();
        }
        getContentPane().setBackground(new Color(0x87AE73));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == BSreturnButton){
            remove(mybs);
            repaint();
            setVisible(false);
            fr.getRest().setVisible(true);
        }
    }
    
    
}
