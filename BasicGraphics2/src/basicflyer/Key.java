/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.SpriteComponent;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.io.IOException;

/**
 * All the methods and usage needed for the key to display
 * @author Mousefire
 */
public class Key extends Sprite {   
    
     public Key() {
        this.clip = new ReusableClip("cough.wav");
    }
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
        for (int i = 0; i < 8; i++) {
             initialPic = new Picture("key2.png");//creates a wall 
        setPicture(initialPic);
        Dimension d = sc.getSize();
            for (int j = 0; j < 9; j++) {
                
        setX(yVal);
        setY(xVal);
        this.sc = sc;
        sc.addSprite(this);
       
    }
        }
    }
    SpriteComponent sc;  

  AudioClip clip;
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
         
     if (se.sprite2 instanceof Plasma) {            
                se.sprite2.setActive(false);
                 clip.play();
                }
     
     }


}
