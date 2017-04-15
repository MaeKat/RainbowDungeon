/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicflyer;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.JLabel;

/**
 * This program creates a map for a hostage to escape. The hostage also shoots of
 * the spacebar is pressed.
 *
 * @author vhoffm2 + sbrandt
 */
public class Flyer {



    public static void main(String[] args) throws IOException {
        BasicFrame bf = new BasicFrame("Flyer");

        bf.addMenuAction("Help", "lol u thot", new Runnable() {//lol this pleases me
            @Override
            public void run() {//does nothing but make you feel stupid
            }
        });
     
        final SpriteComponent sc = new SpriteComponent() {
            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                g.setColor(Color.DARK_GRAY);
                g.fillRect(100,100, 450, 450);
                g.setColor(Color.CYAN);//temp menu
                g.fillRect(50, 0, 550, 50);

       

            }
        };
        
        
        
        
        sc.setPreferredSize(new Dimension(800, 800));
        bf.add("Flyer", sc, 0, 0, 0, 0);
        bf.show();

      //  final Wall w = new Wall();

        final Wall w3 = new Wall();
        final Wall w4 = new Wall();
        final Wall w5 = new Wall();
        final Wall w6 = new Wall();
        final Wall w8 = new Wall();
        final Wall w10 = new Wall();
        final Wall w11 = new Wall();
        final Wall w13 = new Wall();
        final Wall w14= new Wall();
        final Wall w15 = new Wall();
    
        final Wall w17 = new Wall();
        final Wall w18 = new Wall();
      
        final Wall w21 = new Wall();
        final Wall w22 = new Wall();
        
        final Wall wBorderHorBot = new Wall();
        final Wall wBorderVertLeft = new Wall();
        final Wall wBorderVertRight = new Wall();
        final Wall wBorderHorTop  = new Wall();
    

        final Falcon f = new Falcon();
        final Castle castle1 = new Castle();
        final Castle castle2 = new Castle();
        final Bandit bandit1 = new Bandit();
        final Bandit bandit2 = new Bandit();
        final Bandit bandit3 = new Bandit();
        final Bandit bandit4 = new Bandit();
        final Capitao cap1 = new Capitao();
        final Smoke smoke1 = new Smoke(); //lol 420 smoke1 
        final Smoke smoke2 = new Smoke();
         final Key key = new Key();
        final Hero h = new Hero();
        final double INCR = 50;
        final Door door = new Door();
        bf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {//moves right one space
                  
                    f.moveX(INCR);
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {//moves left one space
                    f.moveX(-INCR);
                } else if (ke.getKeyCode() == KeyEvent.VK_UP) {//Moves up a space
                    f.moveY(-INCR);
                    
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {//moves down a space
                    f.moveY(INCR);

                } else if (ke.getKeyChar() == ' ') {
                   
                    Plasma pl = new Plasma();
                   
                    pl.setVelY(-10);
                    pl.setX(f.getX() + f.getWidth() * .5);
                    pl.setY(f.getY() + f.getHeight() * .5);
                    pl.init(sc);
                    sc.addSprite(pl);
                    
                   
                }
            }
        });
   

     
        w3.init(sc, 100, 300);//Stairs
        
        w4.init(sc, 150, 300);
        w5.init(sc, 150, 400);
        w6.init(sc, 150, 500);
        
        w8.init(sc, 200, 350);
        
        w10.init(sc, 250, 300);
        w11.init(sc, 250, 450);
        
        w13.init(sc, 300, 250);
        w14.init(sc, 300, 400);
        w15.init(sc, 300, 500);
        
        w17.init(sc, 350, 350);
        w18.init(sc, 350, 500);
        
        w21.init(sc, 400, 350);
        w22.init(sc, 400, 400);
   
        //Border Walls
        wBorderHorTop.intiBorderHor(sc, 50, 100);//Top
        wBorderHorBot.intiBorderHor(sc, 550, 50);//Bottom
        wBorderVertLeft.intiBorderVert(sc, 50, 50);//Left
        wBorderVertRight.intiBorderVert(sc, 100, 550);//Right
        
        //3High walls
        final Wall w3High = new Wall();
        final Wall w3Hightop = new Wall();
        final Wall w3Highbotm = new Wall();
        w3High.inti3High(sc, 350, 150);
        w3Hightop.inti3High(sc, 205, 200);
        w3Highbotm.inti3High(sc, 405, 247);
        
        f.init(sc);
    
        key.init(sc, 205, 302);
        door.init(sc,150,350);
        castle1.init(sc,450,350);
        castle2.init(sc,300,300);
        
        bandit1.init(sc,452,165);
        bandit2.init(sc,105,215);
        bandit3.init(sc,150,215);
        bandit4.init(sc,302,415);
        
        smoke1.init(sc,100,300);
        
        cap1.init(sc,153,500);

        h.init(sc,455,305);
       
        sc.start(100, 10);

    }
}
