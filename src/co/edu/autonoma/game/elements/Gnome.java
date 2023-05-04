/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.game.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author educacion
 */
public class Gnome extends Sprite {
    
    public final int GROWTH_FACTOR = 10;
    
    private int step;
    private Drawable drawable;

    public Gnome(int x, int y)
    {
        super(x, y, 50, 50);
        
        step = 10;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
    
    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_RIGHT |
           key == KeyEvent.VK_UP |
           key == KeyEvent.VK_DOWN)
        {
            if(move(key))
                drawable.redraw();
        }
    }
    
    private boolean isValidPosition(int x, int y)
    {
        if(x >= this.area.getX() &
           x + this.width < this.area.getWidth() &
           y >= this.area.getY() &
           y + this.height <= this.area.getHeight())
            return true;
        
        return false;
    }
    
    public boolean move(int direction)
    {
        int ox = x;
        int oy = y;
        
        if(direction == KeyEvent.VK_LEFT)
            x -= step;
            
        if(direction == KeyEvent.VK_RIGHT)
            x += step;
            
        if(direction == KeyEvent.VK_UP)
            y -= step;
            
        if(direction == KeyEvent.VK_DOWN)
            y += step;

//        if(isValidPosition(nx, ny))
//        {
//            x = nx;
//            y = ny;
//            
//            return true;
//        }
//        
//        return false;


        if(x < this.area.getX())
            x = this.area.getX();
            
        if(y < this.area.getY())
            y = this.area.getY();

        if(x + this.width > this.area.getWidth())
            x = this.area.getWidth() - this.width;
        
        if(y + this.height > this.area.getHeight())
            y = this.area.getHeight()- this.height;
        
        if(x == ox & y == oy)
            return false;
        
        return true;
    }
    
    public void eat(Apple apple)
    {
        width += apple.getNutritionalValue();
        height += apple.getNutritionalValue();

//        if(apple instanceof GoodApple)
//            grow();
//        else if(apple instanceof BadApple)
//            shrink();
//        else
//            System.err.println("ERROR: apple type unknown");
    }
    
    public void grow()
    {
        width += GROWTH_FACTOR;
        height += GROWTH_FACTOR;
    }
    
    public void shrink()
    {
        width -= GROWTH_FACTOR;
        height -= GROWTH_FACTOR;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
