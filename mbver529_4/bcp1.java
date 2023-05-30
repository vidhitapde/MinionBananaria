
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Rectangle;
/**
 * Write a description of class bcp1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bcp1 extends JLayeredPane
{
    JLabel pie;
    JLabel crust;    
    JLabel filling;
    JLabel cream;
    JLabel banana;
    
    ArrayList<ImageIcon> pieimgs;
    ArrayList<JLabel> ingredients;
    
    Point imageCorner;
    Point previousPoint;
    
    boolean collision;
    
    boolean crustTouch;
    boolean fillingTouch;
    boolean creamTouch;
    boolean bananaTouch;
    
    JLabel focusLabel;
    /**
     * Constructor for objects of class bcp1
     */
    public bcp1()
    {
       ImageIcon pieIMG = new ImageIcon("assets/pie1.png");
       ImageIcon creamIMG = new ImageIcon("assets/cream.png");
       ImageIcon crustIMG = new ImageIcon("assets/piecrust.png");
       ImageIcon bananaIMG = new ImageIcon("assets/bananaslices.png");
       ImageIcon fillingIMG = new ImageIcon("assets/bananafilling.png");
       
       pie = new JLabel();
       cream = new JLabel();
       crust = new JLabel();
       banana = new JLabel();
       filling = new JLabel();
       
       pie.setIcon(pieIMG);
       pie.setBounds(200,450,632,197);
       cream.setIcon(creamIMG);
       cream.setBounds(100,100,199,103);
       crust.setIcon(crustIMG);
       crust.setBounds(150, 300, 303,112); 
       banana.setIcon(bananaIMG);
       banana.setBounds(500,100,244,124);
       filling.setIcon(fillingIMG);
       filling.setBounds(500, 300, 244,124);
       
       ingredients = new ArrayList<JLabel>();

       ingredients.add(crust);
       ingredients.add(filling);
       ingredients.add(cream);
       ingredients.add(banana);
       
       pieimgs = new ArrayList<ImageIcon>();
       pieimgs.add(new ImageIcon("assets/pie2.png"));
       pieimgs.add(new ImageIcon("assets/pie3.png"));
       pieimgs.add(new ImageIcon("assets/pie4.png"));
       pieimgs.add(new ImageIcon("assets/pie5.png"));
       
       ClickListener clickListener = new ClickListener(); 
       DragListener dragListener = new DragListener();
               
       this.addMouseListener(clickListener); 
       this.addMouseMotionListener(dragListener); 
       
       collision = false;
       crustTouch = false;
       fillingTouch = false;
       creamTouch = false;
       bananaTouch = false;
       
       this.add(filling);
       this.add(crust);
       this.add(banana);
       this.add(cream);
       this.add(pie);
       
       previousPoint = new Point(0, 0);
    }
    /**public void paintComponent(Graphics g) // repaint img w/ new position
    {   
        super.paintComponent(g); 

        pie.paintIcon(this,g,200, 400);
        crust.paintIcon(this,g, 100,50);
        filling.paintIcon(this,g, 700, 50);
        cream.paintIcon(this,g, 200,200);
        banana.paintIcon(this,g, 500, 200);
        
        if (collision) {
            pie.paintIcon(this, g, 400,10);
        }
        
    }
    */

    private class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
        {
            previousPoint = e.getPoint(); // updating the previous point to new place that is clicked
            
            for(JLabel img: ingredients){
                boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                if(withinBounds){
                    focusLabel = img;
                }
            }
        }
    }
    
    public boolean intersects ()
        {
            /**int imageSideL = (int) imageCorner.getX(); 
            int imageSideR = imageSideL + WIDTH; 
            int imageTop = (int) imageCorner.getY();
            int imageBottom = HEIGHT + imageTop;

            int image2SideL = 50; 
            int image2SideR = image2SideL + image2.getIconWidth( ); 
            int image2Top = 50; 
            int image2Bottom = image2Top + image2.getIconHeight(); 

            if (imageSideR >= image2SideL && imageSideL <= image2SideR && imageBottom >= image2Top && imageTop <= image2Bottom)
            {
                return true;
            }
            */
            return false;
            

        }
    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently
            
            focusLabel.setLocation((int)(currentPoint.getX()-50),(int)(currentPoint.getY())-50);
            
            previousPoint = currentPoint; 

            /**if (intersects()) {
                collision = true;
            } else {
                collision = false;
            }
            */

            repaint();
        }

        

        
    }
    
    
}
