import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class myFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class startFrameTest extends JFrame implements ActionListener
{
    JButton play;
    JLabel title;
    
    introFrame intro;
    startFrameTest(){
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
            setVisible(false);
            intro = new introFrame();
        }
    }
    
}
