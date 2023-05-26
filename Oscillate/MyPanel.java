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
    
    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        image = new ImageIcon("assets/minion.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        
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
}
