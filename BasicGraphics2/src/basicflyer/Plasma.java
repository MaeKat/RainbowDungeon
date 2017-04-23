/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.BasicFrame;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * All the methods and usage needed for Plasma to display and interact
 * @author sbrandt
 */
class Plasma extends Sprite {

    int numOfShots = 10;

    /**
     * Creates a picture of a ball with the given color and size.
     *
     * @param color
     * @param size
     * @return
     */
    public static Picture makeBall(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }

    /**
     * Just sets the picture.
     *
     * @param sc
     */
    public void init(SpriteComponent sc) {
        setPicture(makeBall(Color.yellow, 10));

    }

    /**
     * Disappears if it comes in contact with the display boundary.
     * for plasma shots
     * @param se
     */
    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.sprite2 != null) {
        } else {
            setActive(false);
        }
        if (se.eventType == CollisionEventType.SPRITE) {//If it hits an enemy or a wall it disapears
            if (se.sprite2 instanceof Castle) {
                setActive(false);
            }
            if (se.sprite2 instanceof Bandit) {
                {
                    setActive(false);
                }
                if (se.sprite2 instanceof Wall) {
                    {
                        setActive(false);
                    }
                }

            }
        }
    }
}