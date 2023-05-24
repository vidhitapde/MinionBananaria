
/**
 * Write a description of class ImagePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class ImagePanel extends JPanel
{
    ImageIcon image = new ImageIcon("assets/minion.png");
    final int IMG_WIDTH = image.getIconWidth();
    final int IMG_HEIGHT = image.getIconHeight();
    Point image_corner;
    Point previousPoint;
    ImagePanel() {
            image_corner = new Point(0,0);
            ClickListener clickListener = new ClickListener();
            addMouseListener(clickListener);
            
            DragListener dragListener = new DragListener();
            addMouseMotionListener(dragListener);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        image.paintIcon(this,g,(int)image_corner.getX(),(int)image_corner.getY());
    }
    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent evt){
            previousPoint = evt.getPoint();
        }
    }
    private class DragListener extends MouseAdapter {
        public void mouseDragged(MouseEvent evt){
            Point currentPoint = evt.getPoint();
            image_corner.translate((int)(currentPoint.getX() - previousPoint.getX()), (int)(currentPoint.getY() - previousPoint.getY()));
            
            previousPoint = currentPoint;
            repaint();
        }
        
    }
}
