import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class MyPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyPanel extends JPanel implements ActionListener
{
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image image;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    Action downAction;
    JLabel label;
    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.white);
        image = new ImageIcon("assets/minion.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        
        label = new JLabel();
        //it seems that only JLabel types can use the following methods:
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        label.getActionMap().put("downAction", downAction);
        //and the problem is, we are using an Image to oscillate
        //so that means we cant use space bar to move it down 
        
        downAction = new DownAction();
    }
    public void paint(Graphics g){
        super.paint(g); //paint background
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image,x,y,null);
    
    }
    @Override
    public void actionPerformed(ActionEvent e){//where the object is moeny
        if(x>=PANEL_WIDTH - image.getWidth(null) || x<0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        repaint();
    }
    public class DownAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            //if(KeyStroke.getKeyStroke("DOWN")){ //i tried to do a if statement type thing, it didnt work...
                y = y + yVelocity;
            //}
        }
    
    }
}
