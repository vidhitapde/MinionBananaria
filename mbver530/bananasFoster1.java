import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class bananasFoster1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bananasFoster1 extends JLayeredPane implements MouseListener
{
    JLabel griddle;
    ArrayList<ImageIcon> griddleimgs;
    JLabel batter1;
    JLabel batter2;
    JLabel batter3;
    JLabel batter4;
    JLabel batter5;
    JLabel batter6;
    JLabel[] batters;
    int batterCount;
    /**
     * Constructor for objects of class bananasFoster1
     */
    public bananasFoster1()
    {
        ImageIcon griddleIMG = new ImageIcon("assets/griddle1.png");
        
        griddle = new JLabel();
        griddle.setIcon(griddleIMG);
        griddle.setBounds(0,0, 1000, 750);
        griddle.addMouseListener(this);
        griddleimgs = new ArrayList<ImageIcon>();
        griddleimgs.add(new ImageIcon("assets/griddle2.png"));
        griddleimgs.add(new ImageIcon("assets/griddle3.png"));
        griddleimgs.add(new ImageIcon("assets/griddle4.png"));
        griddleimgs.add(new ImageIcon("assets/griddle5.png"));
        griddleimgs.add(new ImageIcon("assets/griddle6.png"));
        
        batter1 = new JLabel();
        batter2 = new JLabel();
        batter3 = new JLabel();
        batter4 = new JLabel();
        batter5 = new JLabel();
        batter6 = new JLabel();
        JLabel[] batters = new JLabel[6];
        batters[0] = batter1;
        batters[1] = batter2;
        batters[2] = batter3;
        batters[3] = batter4;
        batters[4] = batter5;
        batters[5] = batter6;
        batterCount = 0;
        
        this.add(griddle);
    }
    public void mouseClicked(MouseEvent e){
        JLabel currBatter = null;
        if(batterCount < 6){
            
            if(batterCount ==0){
                currBatter = batter1;
            }else if(batterCount == 1){
                currBatter = batter2;
            }else if(batterCount ==2){
                currBatter = batter3;
            }else if(batterCount == 3){
                currBatter = batter4;
            }else if (batterCount == 4){
                currBatter = batter5;
            }else if (batterCount == 5){
                currBatter = batter6;
            }
            currBatter.setIcon(new ImageIcon("assets/battercircle.png"));
            this.add(currBatter);
            this.moveToFront(currBatter);
            
            currBatter.setBounds((int)(MouseInfo.getPointerInfo().getLocation().getX())-110, (int)(MouseInfo.getPointerInfo().getLocation().getY())-120, 208, 208);
            
            if(griddleimgs.size() > 0){
                griddle.setIcon(griddleimgs.remove(0));
            }
            
            repaint();
            batterCount++;
           
        
        }
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    
    
}
