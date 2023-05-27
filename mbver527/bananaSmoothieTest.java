
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;

/**
 * Write a description of class bananaSmoothieTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bananaSmoothieTest extends JFrame implements ActionListener
{
    JLabel cup;
    JLabel bg;
    JButton upButton;
    JButton downButton;
    JButton checkButton;
    JLayeredPane kitLayers;
    ImageIcon[] bananaImages;
    JLabel result;
    int imageIndex;
    bananaSmoothieTest(){
        bananaImages = new ImageIcon[5];
        bananaImages[0] = new ImageIcon("assets/cupwithline.png");
        bananaImages[1] = new ImageIcon("assets/bananafill1.png");
        bananaImages[2] = new ImageIcon("assets/bananafill2.png");
        bananaImages[3] = new ImageIcon("assets/bananafill3.png");
        bananaImages[4] = new ImageIcon("assets/bananafill4.png");
        
        imageIndex = 0;
        
        ImageIcon bgIMG = new ImageIcon("assets/kitchen.png");
        ImageIcon upIMG = new ImageIcon("assets/upbutton.png");
        ImageIcon downIMG = new ImageIcon("assets/downbutton.png");
        ImageIcon checkIMG = new ImageIcon("assets/checkbutton.png");
        ImageIcon cupIMG = new ImageIcon("assets/cupwithline.png");
        
        
        bg = new JLabel();
        bg.setIcon(bgIMG);
        bg.setBounds(0,0, 1000,750);
        getContentPane().setBackground(new Color(0x87AE73));
        
        cup = new JLabel();
        cup.setIcon(cupIMG);
        cup.setBounds(250, 0, 400, 700);
        
        result = new JLabel();
        result.setBounds(750, 300, 200, 100);
        result.setVisible(false);
        
        upButton = new JButton();
        upButton.setFocusable(false);
        upButton.setBounds(100,250,100,100);
        upButton.addActionListener(this);
        upButton.setIcon(upIMG);
        upButton.setBackground(new Color(0xFFFFFF));
        upButton.setContentAreaFilled(false);
        upButton.setBorder(null);
        
        downButton = new JButton();
        downButton.setFocusable(false);
        downButton.setBounds(100,400,100,100);
        downButton.addActionListener(this);
        downButton.setIcon(downIMG);
        downButton.setBackground(new Color(0xFFFFFF));
        downButton.setContentAreaFilled(false);
        downButton.setBorder(null);
        
        checkButton = new JButton();
        checkButton.setFocusable(false);
        checkButton.setBounds(100,550,100,100);
        checkButton.addActionListener(this);
        checkButton.setIcon(checkIMG);
        checkButton.setBackground(new Color(0xFFFFFF));
        checkButton.setContentAreaFilled(false);
        checkButton.setBorder(null);
        
        kitLayers = new JLayeredPane();
        kitLayers.add(cup);
        kitLayers.add(upButton);
        kitLayers.add(downButton);
        kitLayers.add(checkButton);
        kitLayers.add(result);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);
        
        this.add(kitLayers);
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == upButton){
            if(imageIndex < 4){
                imageIndex ++;
                cup.setIcon(bananaImages[imageIndex]);
                repaint();
            }
        }
        if(event.getSource() == downButton){
            if(imageIndex > 0){
                imageIndex --;
                cup.setIcon(bananaImages[imageIndex]);
                repaint();
            }
        }
        if(event.getSource() == checkButton){
            if(imageIndex!= 3){
                ImageIcon wrongIMG = new ImageIcon("assets/wrong.png");
                result.setIcon(wrongIMG);
                result.setVisible(true);
                Timer timer = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        result.setVisible(false);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }else{
                ImageIcon slayIMG = new ImageIcon("assets/slay.png");
                result.setIcon(slayIMG);
                result.setVisible(true);
                Timer timer = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        result.setVisible(false);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    public void picUp(ImageIcon imgs){
        
    }
    public void picDown(ImageIcon imgs){
        
    }
    public void checkPic(){
        
    }
}
