/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.game.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author educacion
 */
public class Garden extends Sprite 
    implements Dimensionable, Drawable {
    
    private Gnome gnome;
    private ArrayList<Apple> apples;

    public Garden(int width, int height)
    {
        super(0, 0, width, height);
        
        gnome = new Gnome(width/2, height/2);
        gnome.setArea(this);
        gnome.setDrawable(this);
        
        apples = new ArrayList<>();
    }
    
    public void addGoodApple()
    {
        int x = (int)(Math.random() * width) - Apple.SIDE;
        int y = (int)(Math.random() * height) - Apple.SIDE;
        
        GoodApple apple = new GoodApple(x, y);
        apple.setDrawable(this);
        
        apples.add(apple);
    }
    
    public void addBadApple()
    {
        int x = (int)(Math.random() * width) - Apple.SIDE;
        int y = (int)(Math.random() * height) - Apple.SIDE;
        
        BadApple apple = new BadApple(x, y);
        apple.setDrawable(this);
        
        apples.add(apple);
    }
    
    public void addGhostApple()
    {
        int x = (int)(Math.random() * width) - GhostApple.SIDE;
        int y = (int)(Math.random() * height) - GhostApple.SIDE;
        
        GhostApple apple = new GhostApple(x, y);
        apple.setDrawable(this);
        
        apples.add(apple);
    }
    
    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_RIGHT |
           key == KeyEvent.VK_UP |
           key == KeyEvent.VK_DOWN)
        {
            gnome.handleKey(key);
            
            checkForEatenApples();
        }
        
        if(key == KeyEvent.VK_A)
        {
            addGoodApple();
            
            if(drawable != null)
                redraw();
        }
        if(key == KeyEvent.VK_S)
        {
            addBadApple();
            
            if(drawable != null)
                redraw();
        }
        if(key == KeyEvent.VK_G)
        {
            addGhostApple();
            
            if(drawable != null)
                redraw();
        }
    }
    
    public void checkForEatenApples()
    {
        for(int i=0; i<apples.size(); i++)
        {
            Apple apple = apples.get(i);
            
            if(gnome.checkCollision(apple))
            {
                gnome.eat(apple);
                apples.remove(apple);
            }
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
        
        gnome.draw(g);
                
        for(Apple apple : apples)
            apple.draw(g);
    }

    @Override
    public void redraw() {
        if(drawable != null)
            drawable.redraw();
    }
    
    @Override
    public void redraw(int x, int y, int width, int height) {
        if(drawable != null)
            drawable.redraw(x, y, width, height);
    }
}
