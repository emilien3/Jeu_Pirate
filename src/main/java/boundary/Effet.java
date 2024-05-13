/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ogled
 */
public class Effet extends javax.swing.JPanel {

    private BufferedImage effetImage;
    private TypeEffet effet = TypeEffet.avalanche;
    private int dureeEffet = 0;
    
    public enum TypeEffet {
        avalanche,
        crane,
        falaise,
        longueVue,
        monstre,
        nourriture,
        none
    }
    
    /**
     * Creates new form Effet
     */
    public Effet() {
        initComponents();
        
        // Init du label
        updateLabels();
        
        // Mise à jour de l'image
        updateImageFile();
    }

    public TypeEffet getEffet() {
        return effet;
    }

    public int getDureeEffet() {
        return dureeEffet;
    }

    public void setEffet(TypeEffet effet) {
        this.effet = effet;
        
        // Pour l'édition dans le GUI
        firePropertyChange("effet", null, effet);
        
        // Mise à jour de l'image
        updateImageFile();
        updateLabels();
        
        // repaint de la frame
        repaint();
    }

    public void setDureeEffet(int dureeEffet) {
        this.dureeEffet = dureeEffet;
        
        // Pour l'édition dans le GUI
        firePropertyChange("dureeEffet", null, dureeEffet);
        updateLabels();
    }
    
    private String formatName(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
        
    private void updateImageFile() {
        if(effet == TypeEffet.none)
            return;
        
        try {
            effetImage = ImageIO.read(
                    getClass().getResource("/" + formatName(effet.name()) + ".png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void updateLabels() {
        if(effet == TypeEffet.none || dureeEffet == 0) {
            labelNomEffet.setText("");
            labelDureeEffet.setText("");
            return;
        }
        labelNomEffet.setText(formatName(effet.name()));
        labelDureeEffet.setText(dureeEffet + " Tour" + (dureeEffet > 1 ? "s":""));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(effet != TypeEffet.none && dureeEffet != 0)
            g.drawImage(effetImage, 0, 0, null);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomEffet = new javax.swing.JLabel();
        labelDureeEffet = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(160, 90));

        labelNomEffet.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelNomEffet.setForeground(java.awt.Color.black);

        labelDureeEffet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDureeEffet.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNomEffet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDureeEffet, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomEffet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDureeEffet)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDureeEffet;
    private javax.swing.JLabel labelNomEffet;
    // End of variables declaration//GEN-END:variables
}
