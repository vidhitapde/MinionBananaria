import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
/**
 * Write a description of class myFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class startFrame extends JFrame implements ActionListener
{
    JButton play;
    JLabel title;
    
    JButton bookButton;
    JButton orderButton;
    JLabel restaurantBack;
    JLabel desk;
    JLabel minion;
    JLayeredPane restaurantLayers;
    startFrame(){
        ImageIcon playImage = new ImageIcon("assets/play button.png");
        ImageIcon rolloverImage = new ImageIcon("assets/hoverplay.png");
        
        play = new JButton();
        play.setFocusable(false);
        play.setBounds(385,450,230,72);
        play.addActionListener(this);
        play.setIcon(playImage);
        play.setBackground(new Color(0xFAE7B5));
        play.setContentAreaFilled(false);
        play.setBorder(null);
        play.setRolloverEnabled(true);
        play.setRolloverIcon(rolloverImage);
        
        setTitle("Minion Bananaria!");
        
        ImageIcon image = new ImageIcon("assets/bananapudding.png");
        setIconImage(image.getImage());
        
        getContentPane().setBackground(new Color(0xFAE7B5));
        
        title = new JLabel();
        ImageIcon titleImage = new ImageIcon("assets/title (1).png");
        title.setIcon(titleImage);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        
        title.setLayout(null);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        add(play);
        add(title);
        

    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == play){
            System.out.println("lol");
            remove(title);
            remove(play);
            repaint();
            switchToRestaurant();
            repaint();
        }
    }
    private void switchToRestaurant(){
        ImageIcon restaurantBackIMG = new ImageIcon("assets/restaurant.png");
        ImageIcon minionIMG = new ImageIcon("assets/minion.png");
        ImageIcon deskIMG = new ImageIcon("assets/desk.png");
        
        restaurantBack = new JLabel();
        restaurantBack.setIcon(restaurantBackIMG);
        restaurantBack.setBounds(0,0,1000, 750);
        
        minion = new JLabel();
        minion.setIcon(minionIMG);
        minion.setBounds(700,0,1000, 750);
        
        desk = new JLabel();
        desk.setIcon(deskIMG);
        desk.setBounds(0,0, 1000, 750);
        
        restaurantLayers = new JLayeredPane();
        restaurantLayers.setBounds(0, 0, 1000, 750);
        
        restaurantLayers.add(minion);
        restaurantLayers.add(desk);
        restaurantLayers.add(restaurantBack);
        
        add(restaurantLayers);
    }
    private void animateRestaurant(){
    }
}

