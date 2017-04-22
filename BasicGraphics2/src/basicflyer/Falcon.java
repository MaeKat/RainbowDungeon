/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * This class contains the info for controls and
 * implementaion of the Hostage 
 * trying to escape
 * @author vhoffm2
 */
public class Falcon extends Sprite {
   int health;
   double score;
   boolean key =false;
    public Picture initialPic;
    /**
     * Initializes the sprite, setting its picture,
     * position, and speed. It also adds it to the
     * SpriteComponent.
     * 
     * @param sc
     * @throws IOException 
     */
    public void init(SpriteComponent sc) throws IOException {
        initialPic = new Picture("human.png");
        setPicture(initialPic);
         
        Dimension d = sc.getSize();
       
        setX(520);
        setY(510);
        setHealth(100);//start with 100% health
        this.sc = sc;
        sc.addSprite(this);
        
    }

    /**
     *Gets the score
     * @return score
     */
    public double getScore(){
    return score;
    }

    /**
     * Sets the score
     * @param pointsGained
     */
    public void setScore(int pointsGained){
    score = score + pointsGained;
 }
    

    /**
     *  Causes the hostage to move from one square to 
     * another with each button press up or down only
     * @param direction
     */
    public void moveY(double direction) {
        prevY(getY());//:?
         prevX(getX());//:?
        setY(getY()+direction);   
    }

    /**
     * Causes the hostage to move left and right
     * @param direction
     */
    public void moveX(double direction){
        prevX(getX());//:?
        prevY(getY());//:?
        setX(getX()+direction); 
    }
    
    /**
     *  Initializes the health for the Hostage
     * @param totalHealth
     */
    @Override
     public void setHealth(int totalHealth){
     health = totalHealth;
    }

    /**
     *  Gets the health of the hostage
     * @return
     */
    @Override
    public int getHealth(){//gain health
    return health;
    }

    /**
     *  Allows the Hostage to gain health
     * @param hitPoints
     */
    @Override
    public void gainHealth(int hitPoints){
        setHealth(getHealth()+ hitPoints);
    
    }

    /**
     * when the hostage takes damage the points are deducted and kills
     * the hostage if he loses too much health
     * @param hitPoints
     */
    @Override
            public void loseHealth(int hitPoints ){
                if (hitPoints > getHealth())
                {
                 JOptionPane.showMessageDialog(sc, "You died! Game Over!");
                 System.exit(0);
                }
                    else
                setHealth(getHealth()- hitPoints);
            }
    
    SpriteComponent sc;
    /**
     * Here we update the velocity and picture
     * if they need updating.
     */
    @Override
    public void preMove() {
        
    }
    /**
     * This sprite only reacts to collisions 
     * with important interaction for hostage
     * @param se 
     */
    @Override
    public void processEvent(SpriteCollisionEvent se) {
     
        if(se.sprite2 instanceof Key){
           se.sprite2.setActive(false);
           key = true;
        }
        if(se.sprite2 instanceof Door){
            if(key){
                JOptionPane.showMessageDialog(sc, "Congrats! You're smarter than a 5th Grader!");
                System.exit(0);
            }
        }

        }
}