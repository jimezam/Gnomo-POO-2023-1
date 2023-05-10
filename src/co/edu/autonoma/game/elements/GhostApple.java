/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.game.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educacion
 */
public class GhostApple extends Apple implements Runnable {
    
    public static final int SIDE = 40;
    public static final int STEP = 5;
    
    private Thread thread = null;
    
    public GhostApple(int x, int y) {
        super(x, y, SIDE, SIDE);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    @Override
    public int getNutritionalValue() {
        return 0;
    }

    @Override
    public void run() {
        while(true)
        {
            int origX = x;
            int origY = y;
            
            int direccion = (int)(Math.random() * 4);

            switch(direccion)
            {
                case 0:     // UP
                    y -= STEP;
                break;
                case 1:     // DOWN
                    y += STEP;
                break;
                case 2:     // LEFT
                    x -= STEP;
                break;
                case 3:     // RIGHT
                    x += STEP;
                break;
            }
            
            if(drawable != null)
                // drawable.redraw();
                drawable.redraw((int) Math.min(origX, x), 
                                (int) Math.min(origY, y),
                                (int) Math.abs(origX - x) + width,
                                (int) Math.abs(origY - y) + height);
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(GhostApple.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
