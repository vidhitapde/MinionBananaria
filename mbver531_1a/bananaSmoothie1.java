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
public class bananaSmoothie1 extends JLayeredPane implements ActionListener//, MouseListener
{
    JLabel cup;
    JLabel bg;
    JButton upButton;
    JButton downButton;
    JButton checkButton;
    JButton nextButton;
    JLayeredPane kitLayers;
    ImageIcon[] bananaImages;
    ImageIcon[] milkImages;
    ImageIcon[] iceImages;
    JLabel result;
    int imageIndex;
    ArrayList<String> levels;
    kitchenFrame frame;
    
    JLabel blender;
    ArrayList<ImageIcon> blenderimgs;
    boolean moveLeft;
    int spaceCount;
    boolean switch2;
    boolean switch3;
    
    /**JLabel griddle;
    ArrayList<ImageIcon> griddleimgs;
    JLabel batter1;
    JLabel batter2;
    JLabel batter3;
    JLabel batter4;
    JLabel batter5;
    JLabel batter6;
    JLabel[] batters;
    int batterCount;
    */
    
    JLabel bp;
    JLabel smoothiecup;
    int xcoord;
    int ycoord;
   
    boolean left;
    Timer timer;
    JButton returnButton;
    bananaSmoothie1(kitchenFrame fr){
        frame = fr;
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
        ImageIcon returnIMG = new ImageIcon("assets/return.png");
        
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
        
        
        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(450,450,350,350);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        
        nextButton.setVisible(false);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(450,450,350,350);
        returnButton.addActionListener(frame);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        
        this.add(nextButton);
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
        
        /**ImageIcon griddleIMG = new ImageIcon("assets/griddle1.png");
        
        griddle = new JLabel();
        griddle.setIcon(griddleIMG);
        griddle.setBounds(0,0, 1000, 750);
        griddle.addMouseListener(this);
        griddleimgs = new ArrayList<ImageIcon>();
        griddleimgs.add(new ImageIcon("assets/griddle2.png"));
        griddleimgs.add(new ImageIcon("assets/griddle3.png"));
        griddleimgs.add(new ImageIcon("assets/griddle4.png"));
        griddleimgs.add(new ImageIcon("assets/griddle5.png"));
        griddleimgs.add(new ImageIcon("assets/griddle6.png"));
        
        batter1 = new JLabel();
        batter2 = new JLabel();
        batter3 = new JLabel();
        batter4 = new JLabel();
        batter5 = new JLabel();
        batter6 = new JLabel();
        JLabel[] batters = new JLabel[6];
        batters[0] = batter1;
        batters[1] = batter2;
        batters[2] = batter3;
        batters[3] = batter4;
        batters[4] = batter5;
        batters[5] = batter6;
        batterCount = 0;
        */
        ImageIcon umbrellaIMG = new ImageIcon("assets/umbrella.png");
        bp = new JLabel();
        bp.setIcon(umbrellaIMG);
        xcoord=200;
        ycoord = 0;
        bp.setBounds(xcoord,ycoord, 157, 146);
        left = false;
        
        
        ImageIcon smoothiecupIMG = new ImageIcon("assets/donesmoothie.png");
        smoothiecup = new JLabel();
        smoothiecup.setIcon(smoothiecupIMG);
        smoothiecup.setBounds(350, 250, 287,358);
        
        
        
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
                    
                    
                    ImageIcon nextIMG = new ImageIcon("assets/next.png");
                    
                    nextButton.setVisible(true);
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
        if(event.getSource() == nextButton){
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
        this.add(nextButton);
        nextButton.setVisible(false);
    }
    public void switchTo3(){
        this.add(smoothiecup);        
        this.add(bp);
        
        oscillate();
        
        toppingAction myTA = new toppingAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);
        
        nextButton.setVisible(false);
    }
    public JButton getNextButton(){
        return nextButton;
    }
    /**
    public void mouseClicked(MouseEvent e){
        JLabel currBatter = null;
        if(batterCount < 6){
            
            if(batterCount ==0){
                currBatter = batter1;
            }else if(batterCount == 1){
                currBatter = batter2;
            }else if(batterCount ==2){
                currBatter = batter3;
            }else if(batterCount == 3){
                currBatter = batter4;
            }else if (batterCount == 4){
                currBatter = batter5;
            }else if (batterCount == 5){
                currBatter = batter6;
            }
            currBatter.setIcon(new ImageIcon("assets/battercircle.png"));
            this.add(currBatter);
            this.moveToFront(currBatter);
            
            currBatter.setBounds((int)(MouseInfo.getPointerInfo().getLocation().getX())-110, (int)(MouseInfo.getPointerInfo().getLocation().getY())-120, 208, 208);
            
            if(griddleimgs.size() > 0){
                griddle.setIcon(griddleimgs.remove(0));
            }
            
            repaint();
            batterCount++;
           
        
        }
        if(batterCount==6){
            this.add(returnButton);
            this.moveToFront(returnButton);
            returnButton.setVisible(true);
            repaint();
        }
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    **/
    
    public JButton getRestaurantButton(){
        return returnButton;
    }
    public void oscillate(){
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp.setLocation(xcoord,0);
                if(left == false){
                    xcoord+=5;
                }else{
                    xcoord-=5;
                }
                if(xcoord == 800 || xcoord == 200){
                    left = !left;
                }
                bp.getParent().repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
    public void moveDown(){
        bananaSmoothie1 myBSPanel = this;
        JButton retButton = myBSPanel.getRestaurantButton();
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp.setLocation(xcoord,ycoord);
                ycoord+=5;
                if(xcoord > 350 && xcoord <625){
                    if(ycoord == 150){
                        timer.setRepeats(false);
                        myBSPanel.add(retButton);
                        myBSPanel.moveToFront(retButton);
                        returnButton.setVisible(true);
                        repaint();
                    }
                }else if(ycoord == 500){
                    timer.setRepeats(false);
                    myBSPanel.add(retButton);
                    myBSPanel.moveToFront(retButton);
                    returnButton.setVisible(true);
                    repaint();
                }
                bp.getParent().repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}
