import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class Oscillate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Oscillate extends JLayeredPane 
{
    oscillateFrame frame;
    
    JLabel bp;
    JLabel pan;
    JLabel pancakes;
    JLabel plate;
   
    boolean movecheck;

    int xcoord;
    int ycoord;

    int x; 
    int y; 

    int xval; 
    int yval; 

    boolean left;
    Timer timer;

    Oscillate(oscillateFrame fr)
    {
        frame = fr; 

        ImageIcon umbrellaIMG = new ImageIcon("assets/pancakes.png");
        bp = new JLabel();
        bp.setIcon(umbrellaIMG);
        xcoord= 200;
        ycoord = 0;
        bp.setBounds(xcoord,ycoord, 500, 500);
        movecheck = true;
        left = false;
        

        ImageIcon pancake = new ImageIcon("assets/pancakes.png");
        pan = new JLabel();
        pan.setIcon(pancake);
        x = 50;
        y = 0;
        pan.setBounds(x,y, 500, 500);
        movecheck = true;
        left = false;
        

        ImageIcon pancake3 = new ImageIcon("assets/pancakes.png");
        pancakes = new JLabel();
        pancakes.setIcon(pancake3);
        xval = 50;
        yval = 0;
        pancakes.setBounds(xval,yval, 500, 500);
        movecheck = true;
        left = false;

        ImageIcon plateIMG = new ImageIcon("assets/plate.png");
        plate = new JLabel();
        plate.setIcon(plateIMG);
        plate.setBounds(70,100, 900,900);

        this.add(plate);
        pancakeOne(); 
    }

    public void pancakeOne(){
        this.add(bp);
        oscillatePancakeOne(); 
        
        oscillateAction myTA = new oscillateAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);
    }

    public void pancakeTwo()
    {
        this.add(pan);
        oscillatePancakeTwo(); 

        oscillateAction myTA2 = new oscillateAction(pan, this, timer);
        InputMap panInput = pan.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap panAction = pan.getActionMap();
        panInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        panAction.put("drop", myTA2);
    }

    public void pancakeThree()
    {
        
        this.add(pancakes);
        oscillatePancakeThree(); 

        oscillateAction myTA3 = new oscillateAction(pancakes, this, timer);
        InputMap pancakesInput = pancakes.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap pancakesAction = pancakes.getActionMap();
        pancakesInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        pancakesAction.put("drop", myTA3);
    }

    public void oscillatePancakeOne(){
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    bp.setLocation(xcoord,0);
                    if(left == false){
                        xcoord+=5;
                    }else{
                        xcoord-=5;
                    }
                    if(xcoord == 500 || xcoord == 0){
                        left = !left;
                    }
                    bp.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }

    public void movePancakeOneDown(){
        Oscillate myBSPanel = this;
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    bp.setLocation(xcoord,ycoord);
                    ycoord+=5;
                    myBSPanel.moveToBack(plate); 
                    if(xcoord > 350 && xcoord <625){
                        if(ycoord >= 150)
                        {
                            timer.setRepeats(false);
                            repaint();
                            myBSPanel.moveToFront(bp);
                            timer.stop(); 
                            pancakeTwo();
                        }

                    }else if(ycoord >= 285){
                        timer.setRepeats(false);
                        repaint();
                        myBSPanel.moveToFront(bp); 
                        timer.stop(); 
                        pancakeTwo(); 
                    }
                    bp.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }

    public void oscillatePancakeTwo(){
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pan.setLocation(x,0);
                    if(left == false){
                        x+=5;
                    }else{
                        x-=5;
                    }
                    if(x == 500 || x== 0){
                        left = !left;
                    } 
                    pan.getParent().repaint();
                }
            });     
        timer.setRepeats(true);
        timer.start();
    }

    public void movePancakeTwoDown(){
        Oscillate myBSPanel = this;
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pan.setLocation(x,y);
                    y+=5;
                    myBSPanel.moveToBack(plate); 
                    if(x > 350 && x <625){
                        if(y >= 150)
                        {
                            timer.setRepeats(false);
                            repaint();
                            myBSPanel.moveToFront(pan);
                            timer.stop(); 
                            pancakeThree(); 
                        }
                    }else if(y >= 255){
                        timer.setRepeats(false);
                        repaint();
                        myBSPanel.moveToFront(pan);
                        timer.stop(); 
                        pancakeThree(); 
                    }
                    pan.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }

    
    public void oscillatePancakeThree(){
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pancakes.setLocation(xval,0);
                    if(left == false){
                        xval+=5;
                    }else{
                        xval-=5;
                    }
                    if(xval == 500 || xval == 0){
                        left = !left;
                    } 
                    pancakes.getParent().repaint();
                }
            }); 
        timer.setRepeats(true);
        timer.start();
    }
    public void movePancakeThreeDown(){
        Oscillate myBSPanel = this;
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pancakes.setLocation(xval,yval);
                    yval +=5;
                    myBSPanel.moveToBack(plate); 
                    if(xval > 350 && xval <625){
                        if(yval >= 150)
                        {
                            timer.setRepeats(false);
                            repaint();
                            myBSPanel.moveToFront(pancakes);
                        }

                    }else if(yval >= 235){
                        timer.setRepeats(false);
                        repaint();
                        myBSPanel.moveToFront(pancakes);
                    }
                    pancakes.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }
}
