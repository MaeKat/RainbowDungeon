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
public class Smoke extends Enemy {

    public Picture initialPic;

    public Smoke() {
        this.clip = new ReusableClip("cough.wav");
    }

    /**
     * Initializes the sprite, setting its picture, position, and speed. It also
     * adds it to the SpriteComponent.
     *
     * @param sc
     * @throws IOException
     */
    public void init(SpriteComponent sc, int xVal, int yVal) throws IOException {
        initialPic = new Picture("smoke-gas.gif");//creates a castle enemy
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
    static int enemyCount = 2;
    /**
     *static pos
     *
     */
    @Override
    public void moveY(double direction) {

    }

     /**
     *static pos
     *
     */
    @Override
    public void moveX(double direction) {

    }

    AudioClip clip;

     /**
     * impact reactions for smoke
     * @param  se
     */
    @Override
    public void processEvent(SpriteCollisionEvent se) {

        if (se.sprite2 != null) {
        } else {
            setActive(false);
        }

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {//if hit move down one with barricade
                se.sprite2.setX(se.sprite2.getX());
                se.sprite2.setY(se.sprite2.getY());
                se.sprite2.loseHealth(40);
                setActive(false);
                clip.play();
                System.out.println("S" + se.sprite2.getHealth());
            }
            if (se.sprite2 instanceof Plasma) {

                se.sprite2.setActive(false);

            }
        }
    }
}
