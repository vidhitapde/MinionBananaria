import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class bananaSmoothieTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bananaSmoothie1 extends JLayeredPane implements ActionListener
{
    JLabel cup;
    JLabel bg;
    JButton upButton;
    JButton downButton;
    JButton checkButton;
    JButton returnButton;
    JLayeredPane kitLayers;
    ImageIcon[] bananaImages;
    ImageIcon[] milkImages;
    ImageIcon[] iceImages;
    JLabel result;
    int imageIndex;
    ArrayList<String> levels;
    BSFrame frame;
    
    JLabel blender;
    ArrayList<ImageIcon> blenderimgs;
    boolean moveLeft;
    int spaceCount;
    boolean switch2;
    boolean switch3;
    
    JLabel griddle;
    JLabel circle1;
    JLabel circle2;
    JLabel circle3;
    JLabel circle4;
    JLabel circle5;
    JLabel circle6;
    JLabel batter1;
    JLabel batter2;
    JLabel batter3;
    JLabel batter4;
    JLabel batter5;
    JLabel batter6;
    bananaSmoothie1(BSFrame fr){
        bananaImages = new ImageIcon[5];
        bananaImages[0] = new ImageIcon("assets/cupwithline.png");
        bananaImages[1] = new ImageIcon("assets/bananafill1.png");
        bananaImages[2] = new ImageIcon("assets/bananafill2.png");
        bananaImages[3] = new ImageIcon("assets/bananafill3.png");
        bananaImages[4] = new ImageIcon("assets/bananafill4.png");
        
        milkImages = new ImageIcon[5];
        milkImages[0] = new ImageIcon("assets/milk0.png");
        milkImages[1] = new ImageIcon("assets/milk1.png");
        milkImages[2] = new ImageIcon("assets/milk2.png");
        milkImages[3] = new ImageIcon("assets/milk3.png");
        milkImages[4] = new ImageIcon("assets/milk4.png");
        
        iceImages = new ImageIcon[5];
        iceImages[0] = new ImageIcon("assets/ice0.png");
        iceImages[1] = new ImageIcon("assets/ice1.png");
        iceImages[2] = new ImageIcon("assets/ice2.png");
        iceImages[3] = new ImageIcon("assets/ice3.png");
        iceImages[4] = new ImageIcon("assets/ice4.png");
        
        imageIndex = 0;
        
        levels = new ArrayList<String>();
        levels.add("banana");
        levels.add("ice");
        levels.add("milk");
        
        ImageIcon bgIMG = new ImageIcon("assets/bg.png");
        ImageIcon upIMG = new ImageIcon("assets/upbutton.png");
        ImageIcon downIMG = new ImageIcon("assets/downbutton.png");
        ImageIcon checkIMG = new ImageIcon("assets/checkbutton.png");
        ImageIcon cupIMG = new ImageIcon("assets/cupwithline.png");
        ImageIcon nextIMG = new ImageIcon("assets/next.png");
        
        
        bg = new JLabel();
        bg.setIcon(bgIMG);
        bg.setBounds(0,0, 1000,750);
        
        
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
        
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(450,450,350,350);
        returnButton.addActionListener(this);
        returnButton.setIcon(nextIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        returnButton.setVisible(false);
        
        this.add(returnButton);
        this.add(cup);
        this.add(upButton);
        this.add(downButton);
        this.add(checkButton);
        this.add(result);
 
        
        frame = fr;
        
        switch2 = false;
        
        spaceCount = 0;
        ImageIcon blenderIMG = new ImageIcon("assets/blender1.png");
        
        
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon("assets/blender2.png"));
        blenderimgs.add(new ImageIcon("assets/blender3.png"));
        blenderimgs.add(new ImageIcon("assets/blender4.png"));
        
        blender = new JLabel();
        blender.setIcon(blenderIMG);
        blender.setBounds(200, 0, 400, 700);
        
        blenderAction myBA = new blenderAction(blender, this);
        InputMap blenderInput = blender.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap blenderAction = blender.getActionMap();
        blenderInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "move");
        blenderAction.put("move", myBA);
        
        switch3 = false;
        
        ImageIcon griddleIMG = new ImageIcon("assets/griddle.png");
        
        griddle = new JLabel();
        griddle.setIcon(griddleIMG);
        griddle.setBounds(0,0, 1000, 750);
        
        circle1 = new JLabel();
        circle1.setIcon(new ImageIcon("assets/circle.png"));
        circle1.setBounds(125,125, 208, 208);
        
        circle2 = new JLabel();
        circle2.setIcon(new ImageIcon("assets/circle.png"));
        circle2.setBounds(390,125, 208, 208);
        
        circle3 = new JLabel();
        circle3.setIcon(new ImageIcon("assets/circle.png"));
        circle3.setBounds(660,125, 208, 208);
        
        circle4 = new JLabel();
        circle4.setIcon(new ImageIcon("assets/circle.png"));
        circle4.setBounds(125,420, 208, 208);
        
        circle5 = new JLabel();
        circle5.setIcon(new ImageIcon("assets/circle.png"));
        circle5.setBounds(390,420, 208, 208);
        
        circle6 = new JLabel();
        circle6.setIcon(new ImageIcon("assets/circle.png"));
        circle6.setBounds(660,420, 208, 208);
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == upButton){
            if(imageIndex < 4){
                imageIndex ++;
                if(levels.get(0) == "banana"){
                    cup.setIcon(bananaImages[imageIndex]);
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                }
                repaint();
            }
        }
        if(event.getSource() == downButton){
            if(imageIndex > 0){
                imageIndex --;
                if(levels.get(0) == "banana"){
                    cup.setIcon(bananaImages[imageIndex]);
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                }
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
                
                if(levels.size() != 0){
                    String the = levels.remove(0);
                }
                
                imageIndex = 0;
                if(levels.size() == 0){
                    
                    
                    ImageIcon returnIMG = new ImageIcon("assets/return.png");
                    
                    returnButton.setVisible(true);
                    System.out.println("hi");
                    repaint();
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                    repaint();
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                    repaint();
                }
                Timer timer = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        result.setVisible(false);
                    }
                });
                timer.setRepeats(false);
                timer.start();
                
            }
        }
        if(event.getSource() == returnButton){
            removeAll();
            
            if(switch2 == true && switch3 == false){
                switchTo3();
                switch3 = true;
            }
            if(switch2 == false){
                switchTo2();
                switch2 = true;
            }
            repaint();
        }
    }
    public void switchTo2(){
        this.add(blender);
        this.add(returnButton);
        returnButton.setVisible(false);
    }
    public void switchTo3(){
        this.add(circle1);
        this.add(circle2);
        circle2.setVisible(false);
        this.add(circle3);
        circle3.setVisible(false);
        this.add(circle4);
        circle4.setVisible(false);
        this.add(circle5);
        circle5.setVisible(false);
        this.add(circle6);
        circle6.setVisible(false);
        this.add(griddle);
        returnButton.setVisible(false);
    }
    public JButton getReturnButton(){
        return returnButton;
    }
}
