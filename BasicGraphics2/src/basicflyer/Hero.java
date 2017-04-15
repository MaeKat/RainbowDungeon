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
 *
 * @author Mousefire
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

 @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.WALL) {
                setActive(false);      
        }
        Falcon f = new Falcon();
        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {
                if (f.getHealth()<100){
                    f.gainHealth(40);//if health is below 100% add 40HP
                setActive(false);}
                else{
                    f.gainHealth(20);//else add only 20HP   
                    setActive(false);}
            }
 
        }  

}}
