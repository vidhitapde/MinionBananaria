import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class bananasFoster1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bananasFoster1 extends JLayeredPane implements MouseListener,ActionListener
{
    JLabel griddle;
    ArrayList<ImageIcon> griddleimgs;
    JLabel batter1;
    JLabel batter2;
    JLabel batter3;
    JLabel batter4;
    JLabel batter5;
    JLabel batter6;
    JLabel[] batters;
    
    JLabel pan;
    JLabel butter;
    JLabel sugar;
    JLabel banana;
    ArrayList<JLabel> paningredients;
    ArrayList<ImageIcon> panimgs;
    
    int batterCount;
    JButton nextButton;
    JButton returnButton;
    BFFrame frame;
    
    JLabel pancakePlate;
    JLabel syrup;
    JLabel chocolateChips;
    JLabel whippedCream;
    ArrayList<JLabel> plateingredients;
    ArrayList<ImageIcon> plateimgs;
    
    boolean switch2;
    boolean switch3;
    
    Point previousPoint;
    JLabel focusLabel;
    
    boolean butterTouch;
    boolean sugarTouch;
    boolean bananaTouch;
    boolean syrupTouch;
    boolean whippedCreamTouch;
    boolean chocolateChipsTouch;
    /**
     * Constructor for objects of class bananasFoster1
     */
    public bananasFoster1(BFFrame fr) 
    {
        frame = fr;
        switch2 = false;
        switch3 = false;
        ImageIcon griddleIMG = new ImageIcon(getClass().getResource("assets/griddle1.png"));
        ImageIcon nextIMG = new ImageIcon(getClass().getResource("assets/next.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/return.png"));
        
        griddle = new JLabel();
        griddle.setIcon(griddleIMG);
        griddle.setBounds(0,0, 1000, 750);
        griddle.addMouseListener(this);
        griddleimgs = new ArrayList<ImageIcon>();
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle2.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle3.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle4.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle5.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle6.png")));
        
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
        
        ImageIcon panIMG = new ImageIcon(getClass().getResource("assets/pan1.png"));
        pan = new JLabel();
        pan.setIcon(panIMG);
        pan.setBounds(400, 100,522,450);
        panimgs = new ArrayList<ImageIcon>();
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan2.png")));
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan3.png")));
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan4.png")));
        
        ImageIcon butterIMG = new ImageIcon(getClass().getResource("assets/butterbowl.png"));
        ImageIcon sugarIMG = new ImageIcon(getClass().getResource("assets/sugarbowl.png"));
        ImageIcon bananaIMG = new ImageIcon(getClass().getResource("assets/bananabowl.png"));
        
        butter = new JLabel();
        butter.setIcon(butterIMG);
        butter.setBounds(100, 20, 200, 200);
        
        sugar = new JLabel();
        sugar.setIcon(sugarIMG);
        sugar.setBounds(100, 250, 200, 200);
        
        banana = new JLabel();
        banana.setIcon(bananaIMG);
        banana.setBounds(100, 500, 200, 200);
        
        paningredients = new ArrayList<JLabel>();
        paningredients.add(butter);
        paningredients.add(sugar);
        paningredients.add(banana);
        
        ImageIcon plateIMG = new ImageIcon(getClass().getResource("assets/pancake1.png"));
        pancakePlate = new JLabel();
        pancakePlate.setIcon(plateIMG);
        pancakePlate.setBounds(250,350,520,320);
        plateimgs = new ArrayList<ImageIcon>();
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake2.png")));
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake3.png")));
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake4.png")));
        
        ImageIcon syrupIMG = new ImageIcon(getClass().getResource("assets/syrup.png"));
        ImageIcon whippedcreamIMG = new ImageIcon(getClass().getResource("assets/whippedcream.png"));
        ImageIcon chocIMG = new ImageIcon(getClass().getResource("assets/chocolatechips.png"));
        
        syrup = new JLabel();
        syrup.setIcon(syrupIMG);
        syrup.setBounds(100, 20, 124, 161);
        
        whippedCream = new JLabel();
        whippedCream.setIcon(whippedcreamIMG);
        whippedCream.setBounds(400, 20, 107, 219);
        
        chocolateChips = new JLabel();
        chocolateChips.setIcon(chocIMG);
        chocolateChips.setBounds(700, 20, 233, 72);
        
        plateingredients = new ArrayList<JLabel>();
        plateingredients.add(syrup);
        plateingredients.add(whippedCream);
        plateingredients.add(chocolateChips);
        
        syrupTouch = false;
        whippedCreamTouch = false;
        chocolateChipsTouch = false;
        
        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(450,450,350,350);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        
        nextButton.setVisible(false);
        this.add(nextButton);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(450,450,350,350);
        returnButton.addActionListener(this); //FIX THIS
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        ClickListener clickListener = new ClickListener(); 
        DragListener dragListener = new DragListener();
               
        this.addMouseListener(clickListener); 
        this.addMouseMotionListener(dragListener); 
        
        this.add(griddle);
    }
    public void switchTo2(){
        this.add(butter);
        this.add(sugar);
        this.add(banana);
        this.add(pan);
        
        /** 
         * 
         this.add(smoothiecup);        
        this.add(bp);
        
        oscillate();
        
        toppingAction myTA = new toppingAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);
        
        nextButton.setVisible(false);
        */
    }
    public void switchTo3(){
        
    }
    public void switchTo4(){
        this.add(syrup);
        this.add(whippedCream);
        this.add(chocolateChips);
        this.add(pancakePlate);
        
    }
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
            currBatter.setIcon(new ImageIcon(getClass().getResource("assets/battercircle.png")));
            this.add(currBatter);
            this.moveToFront(currBatter);
            
            currBatter.setBounds((int)(MouseInfo.getPointerInfo().getLocation().getX())-110, (int)(MouseInfo.getPointerInfo().getLocation().getY())-120, 208, 208);
            
            if(griddleimgs.size() > 0){
                griddle.setIcon(griddleimgs.remove(0));
            }
            
            repaint();
            batterCount++;
           
        }
        if (batterCount == 6){
            nextButton.setVisible(true);
            this.moveToFront(nextButton);
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
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == nextButton){
            removeAll();
            /**
             * 
             if(switch2 == true && switch3 == true){
                switchTo4();
            }
            */
            if(switch2 == true && switch3 == false){
                switchTo4();
                //switchTo3();
                switch3 = true;
            }
            if(switch2 == false){
                switchTo2();
                switch2 = true;
            }
            repaint();
        }
        if(event.getSource() == returnButton){
            
        }
    }
    private class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
        {
            previousPoint = e.getPoint(); // updating the previous point to new place that is clicked
            if(switch2 == true && switch3 == false){
                for(JLabel img: paningredients){
                    boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                    if(withinBounds){
                        focusLabel = img;
                    }
                }
            }else if(switch2 == true && switch3 == true){
                for(JLabel img: plateingredients){
                    boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                    if(withinBounds){
                        focusLabel = img;
                    }
                }
            }
        }
    }
    
    public void intersects ()
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
            if(switch2 == true && switch3 == false){
                if(focusLabel.getX() > 500 && focusLabel.getX()<850 && focusLabel.getY()>150 && focusLabel.getY()<900){
                    if(focusLabel == butter && butterTouch == false && sugarTouch == false && bananaTouch == false){
                        this.remove(butter);
                        pan.setIcon(panimgs.remove(0));
                        butterTouch = true;
                    }else if(focusLabel == sugar && butterTouch == true && sugarTouch == false && bananaTouch == false){
                        this.remove(sugar);
                        pan.setIcon(panimgs.remove(0));
                        sugarTouch = true;
                    }else if (focusLabel == banana && butterTouch == true && sugarTouch == true && bananaTouch == false){
                        this.add(nextButton);
                        nextButton.setVisible(true);
                        this.moveToFront(nextButton);
                        this.remove(banana);
                        pan.setIcon(panimgs.remove(0));
                        bananaTouch = true;
                        
                    }
                    repaint();
                }
            }else if(switch2==true && switch3 == true){
                if(focusLabel.getX() > 250 && focusLabel.getX()<770 && focusLabel.getY()>400 && focusLabel.getY()<680){
                    if(focusLabel == syrup && syrupTouch == false && whippedCreamTouch == false && chocolateChipsTouch == false){
                        this.remove(syrup);
                        pancakePlate.setIcon(plateimgs.remove(0));
                        syrupTouch = true;
                    }else if(focusLabel == whippedCream && syrupTouch == true && whippedCreamTouch == false && chocolateChipsTouch == false){
                        this.remove(whippedCream);
                        pancakePlate.setIcon(plateimgs.remove(0));
                        whippedCreamTouch = true;
                    }else if (focusLabel == chocolateChips && syrupTouch == true && whippedCreamTouch == true && chocolateChipsTouch == false){
                        this.remove(chocolateChips);
                        pancakePlate.setIcon(plateimgs.remove(0));
                        chocolateChipsTouch = true;
                    }
                    repaint();
                }
            }
            
            

        }
    
    public JButton getRestaurantButton(){
        return returnButton;
    }
    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently
            
            focusLabel.setLocation((int)(currentPoint.getX()-50),(int)(currentPoint.getY())-50);
            
            previousPoint = currentPoint; 

            intersects();
            

            repaint();
        }

        

        
    }
}
