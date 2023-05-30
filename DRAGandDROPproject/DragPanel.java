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
 * Write a description of class DragPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DragPanel extends JPanel 
{
    ImageIcon image = new ImageIcon("assets/yellowbanana.png");

    ImageIcon image2 = new ImageIcon("assets/minionpie.png");

    ImageIcon collisionImage = new ImageIcon("assets/checkbutton.png");

    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();

   

    Point imageCorner;
    Point previousPoint;

    

    boolean collision = false;
    DragPanel()
    {
        imageCorner = new Point(0,0); 

       

        ClickListener clickListener = new ClickListener(); 
        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener); 
        this.addMouseMotionListener(dragListener); 
    }

    public void paintComponent(Graphics g) // repaint img w/ new position
    {   
        super.paintComponent(g); 

        image2.paintIcon(this,g,50, 50);
        image.paintIcon(this,g,(int)imageCorner.getX(), (int)imageCorner.getY()); 
        if (collision) {
            collisionImage.paintIcon(this, g, 400,10);
        }

    }

    private class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
        {
            previousPoint = e.getPoint(); // updating the previous point to new place that is clicked
        }
    }

    public boolean intersects ()
        {
            int imageSideL = (int) imageCorner.getX(); 
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
            return false;

        }
    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently

            imageCorner.translate( // translates image corner to new position

                (int)(currentPoint.getX() - previousPoint.getX()),
                (int)(currentPoint.getY() - previousPoint.getY())
            );
            previousPoint = currentPoint; 

            if (intersects()) {
                collision = true;
            } else {
                collision = false;
            }

            repaint();
        }

        

        
    }
}

