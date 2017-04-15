/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sbrandt
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
        //setVelX(1);
        //setVelY(0);
        this.sc = sc;
        sc.addSprite(this);
        
    }

 public double getScore(){
 return score;
 }
    public void setScore(int pointsGained){
    score = score + pointsGained;
 }
    
   //Movement 
    public void moveY(double direction) {
        prevY(getY());//:?
         prevX(getX());//:?
        setY(getY()+direction);   
    }
    public void moveX(double direction){
        prevX(getX());//:?
        prevY(getY());//:?
        setX(getX()+direction); 
    }
    
   //Health
    @Override
     public void setHealth(int totalHealth){
     health = totalHealth;
    }
    @Override
    public int getHealth(){//gain health
    return health;
    }
    @Override
    public void gainHealth(int hitPoints){
        setHealth(getHealth()+hitPoints);
    
    }
  //lose health function
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
     * This sprite only reacts to collisions with the
     * borders of the display region. When it does, it
     * wraps to the other side.
     * @param se 
     */
    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.WALL) {
        
          
        if(se.eventType==CollisionEventType.SPRITE){
        if(se.sprite2 instanceof Hero){
            se.sprite2.setActive(false);
        }
        if(se.sprite2 instanceof Wall){
           setX(getPrevX());
           setY(getPrevY());
        }
        if(se.sprite2 instanceof Key){
           setActive(false);
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
          
    }
    
}
