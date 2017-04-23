/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.io.IOException;

/**
 * All the methods and usage needed for Door
 * @author Mousefire
 */
public class Door extends Sprite {
       
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
        for (int i = 0; i < 8; i++) {
             initialPic = new Picture("door.png");//creates a wall 
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
    
}