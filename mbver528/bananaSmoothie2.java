import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class bananaSmoothie2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bananaSmoothie2 extends JLayeredPane implements KeyListener, ActionListener
{
    JLabel blender;
    JButton nextButton;
    ArrayList<ImageIcon> blenderimgs;
    boolean moveLeft;
    int spaceCount;
    /**
     * Constructor for objects of class bananaSmoothie2
     */
    public bananaSmoothie2(JFrame fr)
    {
        moveLeft = false;
        spaceCount = 0;
        ImageIcon blenderIMG = new ImageIcon("assets/blender1.png");
        ImageIcon nextIMG = new ImageIcon("assets/next.png");
        
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon("assets/blender2.png"));
        blenderimgs.add(new ImageIcon("assets/blender3.png"));
        blenderimgs.add(new ImageIcon("assets/blender4.png"));
        
        blender = new JLabel();
        blender.setIcon(blenderIMG);
        blender.setBounds(250, 0, 400, 700);
        
        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(450,450,350,350);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        nextButton.setVisible(false);
        
        this.add(nextButton);
        this.add(blender);
        
        addKeyListener(this);
    }
    public void keyPressed(KeyEvent e){
        
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (moveLeft){
                blender.setBounds(300,0,400,700);
                
            }else{
                blender.setBounds(200,0,400,700);
            }
            moveLeft = !moveLeft;
            
            repaint();
        }
        

    }
    public void keyTyped(KeyEvent e){
        
    }
    public void actionPerformed(ActionEvent event){
        
    }
}
