/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.game.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author educacion
 */
public class GoodApple extends Apple {

    public static final int SIDE = 20;
    
    public GoodApple(int x, int y) {
        super(x, y, SIDE, SIDE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    @Override
    public int getNutritionalValue() {
        return 10;
    }
}