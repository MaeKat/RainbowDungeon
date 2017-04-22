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
import java.awt.Dimension;
import java.io.IOException;

/**
 *
 * @author Mousefire
 */
public class Castle extends Enemy { 
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
        initialPic = new Picture("castle-barricade.png");//creates a castle enemy
        setPicture(initialPic);
        Dimension d = sc.getSize();
       
        setX(xVal);
        setY(yVal);

        this.sc = sc;
        sc.addSprite(this);
    }
 SpriteComponent sc;
 
 //if going past barrier
 static int enemyCount =2;
    /**
     * static pos
     * @param  direction
     */
 @Override
  public void moveY(double direction) {
       //doesn't move
    }
  /**
     * static pos
     * @param  direction
     */
    @Override
    public void moveX(double direction){
        //doesn't move
    }
 
    int counter=0;
    /**
     * impact reactions for castle
     * @param  se
     */
    @Override
       public void processEvent(SpriteCollisionEvent se) {
            if (se.xlo) {
            setX(sc.getSize().width-getWidth());
        }
        if (se.xhi) {
            setX(0);
        }
        if (se.ylo) {
            setY(sc.getSize().height-getHeight());
        }
        if (se.yhi) {
            setY(0);
        }
           
         if(se.sprite2 != null) {
        } else {
            setActive(false);
        }

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {//trying to block movement >:
               se.sprite2.setX(se.sprite2.getPrevX());
               se.sprite2.setY(se.sprite2.getPrevY());   
            }
            if (se.sprite2 instanceof Plasma) {
              counter++;
                if (counter ==5){//castle takes 5 shots
                clip.play();
                setActive(false);
                se.sprite2.setActive(false);
                }
            }
        }
    }  
}