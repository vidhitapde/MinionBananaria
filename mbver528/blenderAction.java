import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class blenderAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class blenderAction extends AbstractAction
{
    JLabel label;
    bananaSmoothie1 pane;
    int numSpaces;
    ArrayList<ImageIcon> blenderimgs;
    
    public blenderAction(JLabel lab, bananaSmoothie1 jpane){
        label = lab;
        pane = jpane;
        numSpaces = 0;
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon("assets/blender2.png"));
        blenderimgs.add(new ImageIcon("assets/blender3.png"));
        blenderimgs.add(new ImageIcon("assets/blender4.png"));
    }
    public void actionPerformed(ActionEvent e){
        if(numSpaces % 15 ==0 && numSpaces !=0){
            if (blenderimgs.size() != 0){
                label.setIcon(blenderimgs.remove(0));
            }
        }
        if(numSpaces < 48){
            if(label.getX() < 201){
                label.setLocation(210, label.getY());
            }else{
                label.setLocation(200, label.getY());
            }
            numSpaces++;
            label.getParent().repaint();
        }else if(numSpaces == 48){
            pane.getReturnButton().setVisible(true);
        }
        
        
    
    }
}