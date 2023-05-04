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
public class BadApple extends Apple {

    public BadApple(int x, int y) {
        super(x, y, SIDE, SIDE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(128, 64, 32));
        g.fillRect(x, y, width, height);
    }

    @Override
    public int getNutritionalValue() {
        return -10;
    }
}