
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
    bcp1 mybcp;
    JButton BSreturnButton;
    JButton BCPreturnButton;
    kitchenFrame(introFrame frame){
        fr= frame;
        rest = fr.getRest();
        myRestaurant = rest.getRestaurant();
        
        
        getContentPane().setBackground(new Color(0x87AE73));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        mybs = new bananaSmoothie1(this);
        
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == BSreturnButton){
            remove(mybs);
            
        }
        
        if(event.getSource() == BCPreturnButton){
            remove(mybcp);
            
        }
        this.repaint();
        setVisible(false);
        fr.getRest().checkForDone();
        this.repaint();
        fr.getRest().setVisible(true);
    }
    public void paintNewOrder(){
        System.out.println(myRestaurant.getOrderNum());
        currentOrder = myRestaurant.getMyOrder();
        System.out.println(currentOrder.getFoodName());
        if(currentOrder instanceof bananaSmoothie){
            mybs = new bananaSmoothie1(this);
            this.add(mybs);
            System.out.println("hello");
            BSreturnButton = mybs.getRestaurantButton();
        }
        if(currentOrder instanceof bananaCreamPie){
            mybcp = new bcp1(this);
            this.add(mybcp);
            System.out.println("urmom");
            BCPreturnButton = mybcp.getRestaurantButton();
        }
        this.repaint();
        this.revalidate();
        System.out.println("L");
        myRestaurant.incrementOrder();
        
    }
    
}
