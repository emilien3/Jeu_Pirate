/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author Ninon
 */
public class PanelCase extends javax.swing.JPanel {

    /**
     * Creates new form PanelCase
     */
    public PanelCase() {
        timer = new Timer(3000,  (e) -> {timerEventHandler(e);});
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (image != null){
            g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
        }
        drawNumeroCase(g);
        drawBorder(g);
        if (sombre || active){
            drawOpacite(g);
        }
    }
    
    private void drawNumeroCase(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Segoe UI", 1, 12));
        g.drawString(String.valueOf(numero), 5, 15);
    }
    
    private void drawBorder(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(couleur);
    }
    
    private void drawOpacite(Graphics g){
        g.setColor(couleur);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public void setImage(String image){
        try {
            this.image = ImageIO.read(new File(getClass().getResource(image).toURI()));
        } catch (IOException | URISyntaxException e) {
            Logger.getLogger(PanelImage.class.getName()).log(Level.SEVERE, null, e);
        }
        firePropertyChange("image", null, image);
        repaint();
    }
    
    public void setNumero(int numero){
        this.numero = numero;
        firePropertyChange("numero", null, numero);
    }
    
    public void setDescription(String description){
        this.description = description;
        setToolTipText(description);
    }
    
    public void caseSombre(){
        this.couleur = black;
        this.sombre = true;
        repaint();
    }
    
    public void caseValide(){
        this.couleur = green;
        this.active = true;
        timer.start();
        repaint();
    }
    
    public void caseInvalide(){
        this.couleur = red;
        this.active = true;
        timer.start();
        repaint();
    }
    
    private void timerEventHandler(ActionEvent e){
        timer.stop();
        this.active = false;
        if (sombre){
            this.couleur = black;
        }
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage image;
    private int numero;
    private Timer timer;
    private Color couleur;
    private final Color red = new java.awt.Color(255, 0, 0, 80);
    private final Color green = new java.awt.Color(0, 181, 45, 80);
    private final Color black = new java.awt.Color(0, 0, 0, 80);
    private boolean sombre = false;
    private boolean active = false;
    private String description;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
