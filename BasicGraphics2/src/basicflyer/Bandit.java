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
       public Picture initialPic;
    /**
     * Initializes the sprite, setting its picture,
     * position, and speed. It also adds it to the
     * SpriteComponent.
     * 
     * @param sc
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
 
 //if going past barrier
 static int enemyCount =2;
    
 @Override
  public void moveY(double direction) {
//no move 
    setY(300);
    }
  
    @Override
    public void moveX(double direction){
        //no move
        setX(300);
    }
 
    int counter =0;
    @Override
       public void processEvent(SpriteCollisionEvent se) {
  
           AudioClip clip = new ReusableClip("shock.wav");

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {//if hit move down one with barricade
               se.sprite2.setX( se.sprite2.getX());
              se.sprite2.setY( se.sprite2.getY());
              se.sprite2.loseHealth(20);//lose 20 health
              clip.play();
                if (se.sprite2.getHealth()==0){
                
                se.sprite2.setActive(false);
                }
              System.out.println( "B"+se.sprite2.getHealth());
            }
            if (se.sprite2 instanceof Plasma) {//bandit takes 3 shots to disable      
              counter++;
                if (counter ==3){
                clip.play();
                setActive(false);
                se.sprite2.setActive(false);
                }
            }
        }
    }


}
