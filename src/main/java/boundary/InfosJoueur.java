/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author ogled
 */
public class InfosJoueur extends javax.swing.JPanel {
    
    public enum Joueur {Bill, Jack};
    private Joueur joueur = Joueur.Bill;

    /**
     * Creates new form InfosJoueur
     */
    public InfosJoueur() {
        initComponents();
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
        
        // Pour l'édition dans le GUI
        firePropertyChange("joueur", null, joueur);
        
        // On mets à jour les images
        this.background.setAlternative(joueur == Joueur.Jack);
        this.pointsVie.setAlternative(joueur == Joueur.Jack);
    }
    
    public void setPV(int PV) {
        this.pointsVie.setNombrePV(PV);
        
        // Pour l'édition dans le GUI
        firePropertyChange("PV", null, PV);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new boundary.IconJoueur();
        pointsVie = new boundary.barreDeVie();

        setPreferredSize(new java.awt.Dimension(306, 306));

        background.setX2Res(true);

        pointsVie.setOpaque(false);

        javax.swing.GroupLayout pointsVieLayout = new javax.swing.GroupLayout(pointsVie);
        pointsVie.setLayout(pointsVieLayout);
        pointsVieLayout.setHorizontalGroup(
            pointsVieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        pointsVieLayout.setVerticalGroup(
            pointsVieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(pointsVie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(pointsVie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private boundary.IconJoueur background;
    private boundary.barreDeVie pointsVie;
    // End of variables declaration//GEN-END:variables
}