
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class restaurantFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class restaurantFrame extends JFrame implements ActionListener
{
    JButton orderButton;
    JLabel restaurantBack;
    JLabel minion;
    JLabel minionOrder;
    JLayeredPane restaurantLayers;
    JButton finishButton;
    restaurant myRestaurant;
    
    kitchenFrame kitchen;
    introFrame fr;
    public restaurantFrame(introFrame frame){
        myRestaurant = new restaurant();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        ImageIcon restaurantBackIMG = new ImageIcon("assets/Bakery.jpg");
        ImageIcon minionIMG = new ImageIcon("assets/minion.png");
        ImageIcon orderIMG = new ImageIcon(myRestaurant.getMyOrder().getFoodName());
        ImageIcon takeOrderIMG = new ImageIcon("assets/play button.png");
        ImageIcon finishIMG = new ImageIcon("assets/done.png");
        
           
        restaurantBack = new JLabel();
        restaurantBack.setIcon(restaurantBackIMG);
        restaurantBack.setBounds(0,0,1000, 750);
        
        minion = new JLabel();
        minion.setIcon(minionIMG);
        minion.setBounds(450,18,1000, 750);
        
        minionOrder = new JLabel(); 
        minionOrder.setIcon(orderIMG); 
        minionOrder.setBounds(700,200,200,100);
        
        orderButton = new JButton();
        orderButton.setFocusable(false);
        orderButton.setBounds(450,450,350,350);
        orderButton.addActionListener(this);
        orderButton.setIcon(takeOrderIMG);
        orderButton.setBackground(new Color(0xFFFFFF));
        orderButton.setContentAreaFilled(false);
        orderButton.setBorder(null);
        
        finishButton = new JButton();
        finishButton.setFocusable(false);
        finishButton.setBounds(450,450,350,350);
        finishButton.addActionListener(this);
        finishButton.setIcon(finishIMG);
        finishButton.setBackground(new Color(0xFFFFFF));
        finishButton.setContentAreaFilled(false);
        finishButton.setBorder(null);
        
        restaurantLayers = new JLayeredPane();
        
        restaurantLayers.setBounds(0, 0, 1000, 750);
        
        restaurantLayers.add(minionOrder);
        restaurantLayers.add(orderButton);
        restaurantLayers.add(minion);
         
        restaurantLayers.add(restaurantBack);
        
        this.add(restaurantLayers);
        
        fr = frame;
    }
    public restaurant getRestaurant(){
        return myRestaurant;
    }
    public void addOrder(){
        restaurantLayers.remove(4);
        String foodName = myRestaurant.getMyOrder().getFoodName();
        ImageIcon orderIMG = new ImageIcon(foodName);
        minionOrder.setIcon(orderIMG);
        minionOrder.setBounds(400,200,200,100);
        restaurantLayers.add(minionOrder);
        this.repaint();
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == orderButton){
            setVisible(false);
            fr.getKit().setVisible(true);
            
        }
        
    }
}
