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

/**
 *
 * @author Mousefire
 */
public class Wall extends Sprite {

    public Picture initialPic;

    /**
     * Initializes the sprite, setting its picture, position, and speed. It also
     * adds it to the SpriteComponent. for the normal single block of a wall
     *
     * @param sc
     * @param xVal
     * @param yVal
     * @throws IOException
     */
    public void init(SpriteComponent sc, int xVal, int yVal) throws IOException {
        for (int i = 0; i < 8; i++) {
            initialPic = new Picture("walls.png");//creates a wall 
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

    /**
     * Initializes the sprite, setting its picture, position, and speed. It also
     * adds it to the SpriteComponent. For the horizontal border wall sprite
     *
     * @param sc
     * @param xVal
     * @param yVal
     * @throws IOException
     */
    public void intiBorderHor(SpriteComponent sc, int xVal, int yVal) throws IOException {
        for (int i = 0; i < 8; i++) {
            initialPic = new Picture("wall border.png");//creates a wall 
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

    /**
     * for vertical border.
     * @param sc
     * @param xVal
     * @param yVal
     * @throws IOException
     */
    public void intiBorderVert(SpriteComponent sc, int xVal, int yVal) throws IOException {
        for (int i = 0; i < 8; i++) {
            initialPic = new Picture("wall border rotate.png");//creates a wall 
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

    public void inti3High(SpriteComponent sc, int xVal, int yVal) throws IOException {
        for (int i = 0; i < 8; i++) {
            initialPic = new Picture("wall3High.png");//creates a wall 3 nodes high
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
    /**
     * impact reactions for walls
     * @param  se
     */
    @Override
    public void processEvent(SpriteCollisionEvent se) {

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Falcon) {//if hit move down one with barricade
                se.sprite2.setX(se.sprite2.getPrevX());
                se.sprite2.setY(se.sprite2.getPrevY());

            }
            if (se.sprite2 instanceof Plasma) {
                se.sprite2.setActive(false);//turn off sprite
            }
        }
    }
}
