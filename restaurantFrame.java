import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JLabel desk;
    JLabel minion;
    JLabel minionOrder;
    JLayeredPane restaurantLayers;
    
    kitchenFrame kitchen;
    /**
     * Constructor for objects of class restaurantFrame
     */
    public restaurantFrame() 
    {
        Timer timer = new Timer(1000, new MyTimerActionListener());

        timer.start();
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        timer.stop();
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        ImageIcon restaurantBackIMG = new ImageIcon("assets/Bakery.jpg");
        ImageIcon minionIMG = new ImageIcon("assets/minion.png");
        ImageIcon deskIMG = new ImageIcon("assets/desk.png");
        ImageIcon orderIMG = new ImageIcon("assets/order.png");
        ImageIcon orderButtonIMG = new ImageIcon("assets/play button.png");
           
        restaurantBack = new JLabel();
        restaurantBack.setIcon(restaurantBackIMG);
        restaurantBack.setBounds(0,0,1000, 750);
        
        minion = new JLabel();
        minion.setIcon(minionIMG);
        minion.setBounds(450,18,1000, 750);
        
        minionOrder = new JLabel();
        minionOrder.setIcon(orderIMG);
        minionOrder.setBounds(600,100,200,100);
        
        
        orderButton = new JButton();
        orderButton.setFocusable(false);
        orderButton.setBounds(470,540,200,100);
        orderButton.addActionListener(this);
        orderButton.setIcon(orderButtonIMG);
        orderButton.setBackground(new Color(0xFFFFFF));
        orderButton.setContentAreaFilled(false);
        orderButton.setBorder(null);
        
        restaurantLayers = new JLayeredPane();
        restaurantLayers.setBounds(0, 0, 1000, 750);
        
        restaurantLayers.add(minionOrder);
        restaurantLayers.add(orderButton);
        restaurantLayers.add(minion);
        restaurantLayers.add(restaurantBack);
        
        
        this.add(restaurantLayers);
        
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == orderButton){
            setVisible(false);
            kitchen = new kitchenFrame();
        }
    }
}
class MyTimerActionListener extends JFrame implements ActionListener {
  
    JLabel instructions;
    
    JLayeredPane instructionsLayers;
    public MyTimerActionListener(){
        //repaint();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);

        ImageIcon instructionsIMG = new ImageIcon("assets/Instructions.jpg");
        
        instructions = new JLabel();
        instructions.setIcon(instructionsIMG);
        instructions.setBounds(0,0,1000, 750);
        
        instructionsLayers = new JLayeredPane();
        instructionsLayers.setBounds(0, 0, 1000, 750);
        
        instructionsLayers.add(instructions);
        this.add(instructionsLayers);
        
    }
    public void actionPerformed(ActionEvent e) {
    
  }
}
