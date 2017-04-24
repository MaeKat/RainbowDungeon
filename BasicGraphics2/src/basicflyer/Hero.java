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
//import basicshooter.Bullet;

import java.awt.Dimension;
import java.io.IOException;


/**
 * All the methods and usage needed for a hero
 * @author vhoffm2
 */
public class Hero extends Sprite {

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
        initialPic = new Picture("doc-icon.png");//creates a doc hero
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
    /*  
    adds one to the number of heros in play at any time should be only 1-3 pergame
     */
    SpriteComponent sc;
    static int heroCount;

    Hero() {
        heroCount++;
    }

    /**
     * sets hero to active
     * @param b
     */
    @Override
    public void setActive(boolean b) {
        if (isActive() == b) {
            return;
        }
        if (b) {
            heroCount++;
        } else {
            heroCount--;
        }
        super.setActive(b);
    }
/**
     * impact reactions for the hero
     * adds 20HP if health is at 100% and adds 40HP if health is below 100%
     * @param  se
     */
 @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.WALL) {
                setActive(false);      
        }

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {
                if (se.sprite2.getHealth()<100){
                    se.sprite2.gainHealth(40);//if health is below 100% add 40HP
                setActive(false);
                System.out.println("H"+ se.sprite2.getHealth());
                }
                
                else{
                    se.sprite2.gainHealth(20);//else add only 20HP   
                    setActive(false);
                System.out.println("H"+ se.sprite2.getHealth());
                }
            }
 
        }  

}}