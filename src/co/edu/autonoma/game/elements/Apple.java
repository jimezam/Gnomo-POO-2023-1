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
public abstract class Apple extends Sprite {

    public static final int SIDE = 20;

    public Apple(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public abstract int getNutritionalValue();
}
