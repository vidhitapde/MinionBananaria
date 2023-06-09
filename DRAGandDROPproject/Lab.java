
/**
 * Write a description of class Lab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
public class Lab extends JFrame
{
    JLabel pic1, pic2, pic3; 
    
    public Lab() 
    {
        super ("Drag and Drop Images"); 
        
        pic1 = new JLabel( ); 
        pic2 = new JLabel( ); 
        pic3 = new JLabel( ); 
        
        pic1.setBounds(20,30,250,100); 
        pic2. setBounds(250,30,250,100); 
        pic3.setBounds(20,140,100,100); 
        
        pic1.setIcon(new ImageIcon("assets/bananapudding.png")); 
        pic2.setIcon(new ImageIcon("assets/play button.png")); 
        
        MouseListener ml = new MouseListener()
        {
            public void mouseClicked (MouseEvent e)
            {
                
            }
            
            public void mousePressed (MouseEvent e)
            {
                JComponent jc = (JComponent)e.getSource( ); 
                TransferHandler th = jc.getTransferHandler(); 
                th.exportAsDrag(jc,e,TransferHandler.COPY); 
                
            }
            
            public void mouseReleased (MouseEvent e)
            {
                
            }
            
            
            public void mouseEntered (MouseEvent e)
            {
                
            }
            
            public void mouseExited (MouseEvent e)
            {
                throw new UnsupportedOperationException ("Not supported yet."); 
            }
        };
        
        
        pic1.addMouseListener(ml); 
        pic2.addMouseListener(ml); 
        pic3.addMouseListener(ml); 
        
        pic1.setTransferHandler(new TransferHandler ("icon"));
        pic2.setTransferHandler(new TransferHandler ("icon"));
        pic3.setTransferHandler(new TransferHandler ("icon"));
        
        
        add(pic1); 
        add(pic2); 
        add(pic3); 
        
        setLayout(null);
        setSize(500,500); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
        
        
    }
    public static void main(String[] args)
    {
        new Lab(); 
    }
    }

