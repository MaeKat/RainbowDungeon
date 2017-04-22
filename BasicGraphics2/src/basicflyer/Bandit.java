/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.CollisionEventType;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.io.IOException;

/**
 *
 * @author Mousefire
 */
public class Bandit extends Enemy {

    /**
     * var to hold the sprite
     */
    public Picture initialPic;
    /**
     * Initializes the sprite, setting its picture,
     * position, and speed. It also adds it to the
     * SpriteComponent.
     * 
     * @param sc
     * @param xVal
     * @param yVal
     * @throws IOException 
     */
    public void init(SpriteComponent sc, int xVal, int yVal) throws IOException {
       initialPic = new Picture("bandit-lazer2.png");//creates a castle enemy
        setPicture(initialPic);
       // sc.setSize(10, 10);
        Dimension d = sc.getSize();
       
        setX(xVal);
        setY(yVal);
        //setVelX(1);
        //setVelY(0);
        this.sc = sc;
        sc.addSprite(this);
    }
 SpriteComponent sc;
 static int enemyCount =2;
    
    /**
     * keeps a static y for bandit
     * has a def pos
     * @param direction
     */
    @Override
  public void moveY(double direction) {
    //no move 
    setY(300);
    }
  
    /**
     * keeps a static x for bandit
     * has a def pos
     * @param direction
     */
    @Override
    public void moveX(double direction){
        //no move
        setX(300);
    }
 
    int counter =0;
    
    @Override
       public void processEvent(SpriteCollisionEvent se) {
  
           AudioClip clip = new ReusableClip("shock.wav");
           AudioClip clip2 = new ReusableClip("die.wav");
     if (se.eventType == CollisionEventType.SPRITE) {
               if (se.sprite2 instanceof Falcon) {
                 clip.play();
                 
                   se.sprite2.setX(se.sprite2.getPrevX());
               se.sprite2.setY(se.sprite2.getPrevY());
              se.sprite2.loseHealth(20);//lose 20 health
             
                if (se.sprite2.getHealth()==0){
                
                se.sprite2.setActive(false);
                }
              System.out.println( "B"+se.sprite2.getHealth());
            }
            if (se.sprite2 instanceof Plasma) {//bandit takes 3 shots to disable      
              counter++;
                if (counter ==3){
                clip2.play();
                setActive(false);
                se.sprite2.setActive(false);
                }
            }
        }
    }
}