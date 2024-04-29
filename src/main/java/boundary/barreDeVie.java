/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ogled
 */
public class barreDeVie extends javax.swing.JPanel {
    
    private int nombrePV = 3;
    private int imWidth;
    private int maxPV = 5;
    private BufferedImage coeurPlein;
    private BufferedImage coeurVide;

    /**
     * Creates new form pointDeVie
     */
    public barreDeVie() {
        initComponents();
        
        // Init des images
        try {
            coeurPlein = ImageIO.read(
                    getClass().getResource("/coeurPlein32.png"));
            coeurVide = ImageIO.read(
                    getClass().getResource("/coeurVide32.png"));
            
            this.imWidth = coeurPlein.getWidth();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setNombrePV(int value) {
        // Pour éviter les dépassements
        if(value > maxPV) {nombrePV = maxPV;}
        else if(value < 0) {nombrePV = 0;}
        else {nombrePV = value;}
        
        // On actualise l'affichage
        repaint();
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Afficher les points de vie
        for(int i = 0; i < nombrePV; i++) {
            g.drawImage(coeurPlein, i * imWidth, 0, null);
        }
        for(int i = nombrePV; i < maxPV; i++) {
            g.drawImage(coeurVide, i * imWidth, 0, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
