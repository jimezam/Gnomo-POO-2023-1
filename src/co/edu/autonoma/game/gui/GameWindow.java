/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.autonoma.game.gui;

import co.edu.autonoma.game.elements.Drawable;
import co.edu.autonoma.game.elements.Garden;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author educacion
 */
public class GameWindow 
        extends javax.swing.JFrame 
        implements Drawable {

    private Garden garden;
    
    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
        garden.setDrawable(this);
    }
    
    @Override
    public void paint(Graphics g)
    {
        garden.draw(g);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);
        
        if(evt.getKeyCode() == KeyEvent.VK_UP | 
           evt.getKeyCode() == KeyEvent.VK_DOWN |
           evt.getKeyCode() == KeyEvent.VK_LEFT |
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
            garden.handleKey(evt.getKeyCode());
        
        if(evt.getKeyCode() == KeyEvent.VK_A |
           evt.getKeyCode() == KeyEvent.VK_S | 
           evt.getKeyCode() == KeyEvent.VK_G)
            garden.handleKey(evt.getKeyCode());  
        
//        repaint();
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GameWindow window = new GameWindow();
        Garden garden = new Garden(window.getWidth(), 
                                  window.getHeight());
        
        window.setGarden(garden);
//        garden.setWidth(window.getWidth());
//        garden.setHeight(window.getHeight());
        
        window.setTitle("The great gnome game 2023");
        window.setVisible(true);
    }

    @Override
    public void redraw() {
        repaint();
    }
    
    @Override
    public void redraw(int x, int y, int width, int height)
    {
        repaint(x, y, width, height);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
