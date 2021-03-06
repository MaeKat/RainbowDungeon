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
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

/**
 * All the methods and usage needed for an enemy
 * @author Mousefire
 */
public class Enemy extends Sprite{
     public Picture initialPic;
    /**
     * Initializes the sprite, setting its picture,
     * position, and speed. It also adds it to the
     * SpriteComponent.
     * 
     * @param sc
     * @throws IOException 
     */    
 //creates a random enemy
    public void init(SpriteComponent sc) throws IOException {
      initialPic = new Picture(enemyCreator());//creates enemy
        setPicture(initialPic);
       // sc.setSize(10, 10);
        Dimension d = sc.getSize();
       
        setX(d.width/3);
        setY(d.height/3);

        this.sc = sc;
        sc.addSprite(this);        
    }
 SpriteComponent sc;

    /**
     * creates a random enemy
     * @return enemy
     */
 public String enemyCreator(){
 ArrayList<String> enemies = new ArrayList<>();
 enemies.add("castle-barricade.png");//castle
 enemies.add("cap-fire.gif");//capitao
 enemies.add("smoke-gas.gif");//smoke
 enemies.add("bandit-lazer.png");//bandit
    String enemy;
        Random rand = new Random();
int num = rand.nextInt(4);
enemy = enemies.get(num);
    return enemy;//returns which enemy spawns
    
 }
 //if going past barrier
 static int enemyCount;
    
    Enemy() {
        this.clip = new ReusableClip("die.wav");
        enemyCount++;
    }
    
    /**
     * activates enemies and keeps count of enemies
     * @param b
     */
    @Override
    public void setActive(boolean b) {
        if(isActive() == b)
            return;
        if(b)
            enemyCount++;
        else
            enemyCount--;
        super.setActive(b);
    }

    /**
     * moves in the Y direction
     * @param direction
     */
     public void moveY(double direction) {
        setY(getY()+direction);    
    }

    /**
     * moves in the X direction
     * @param direction
     */
    public void moveX(double direction){
        setX(getX()+direction);
    }
       
AudioClip clip;
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
            if (se.sprite2 instanceof Falcon) {
                clip.play();
                se.sprite2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You lose! Game Over!");
                System.exit(0);
            }
            if (se.sprite2 instanceof Plasma) {
                clip.play();
                setActive(false);
                se.sprite2.setActive(false);
                if(enemyCount == 0) {
                    JOptionPane.showMessageDialog(sc, "You win! Game Over!");
                    System.exit(0);
                }
            }
        }
    }
}