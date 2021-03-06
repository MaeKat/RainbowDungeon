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
import javax.swing.JOptionPane;

/**
 * All the methods for Capitao
 * @author Mousefire
 */
public class Capitao extends Enemy{
    
    /**
     * image for cap
     */
    public Picture initialPic;

    public Capitao() {
        this.clip = new ReusableClip("cough.wav");
    }
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
        initialPic = new Picture("cap-fire2.png");//creates a enemy
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
     * @param direction
     */
    @Override
  public void moveY(double direction) {     
    }

    /**
     * static pos
     * @param direction
     */
    @Override
    public void moveX(double direction){ 
    }
    
     AudioClip clip;
     /**
     * impact reactions for capitao
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
           
         if(se.sprite2 != null) {
        } else {
            setActive(false);
        }

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {//if hit move down one with barricade
             if(se.sprite2.getHealth() > 0){
                se.sprite2.setX( se.sprite2.getX());
              se.sprite2.setY( se.sprite2.getY());    
              se.sprite2.loseHealth(30);//cough
              clip.play();
              setActive(false);
              System.out.println( "C"+se.sprite2.getHealth());
             }
             if (se.sprite2.getHealth()==0){
                
                se.sprite2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You died! Game Over!");
                 System.exit(0);
                }
            }
            if (se.sprite2 instanceof Plasma) {
              
                se.sprite2.setActive(false);
               
                }
            }
        }
    }