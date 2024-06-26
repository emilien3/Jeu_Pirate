/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundaryComponants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author Laura
 */
public class PanelCase extends javax.swing.JPanel {

    /**
     * Creates new form PanelCase
     */
    public PanelCase() {
        timer = new Timer(1000,  (e) -> {timerEventHandler(e);});
        initComponents();
        setBackground(NORMAL);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (image != null){
            Dimension panelDim = this.getSize();
            int xStart = (panelDim.width - imSize) / 2;
            int yStart = (panelDim.height - imSize) / 2;
            g.drawImage(image, xStart, yStart, imSize, imSize, this);
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
            this.image = ImageIO.read(getClass().getResource("/" + image));
        } catch (IOException e) {
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
        if (!active){
            this.couleur = NOIR;
        }
        this.sombre = true;
        repaint();
    }
    
    public void caseClaire(){
        this.sombre = false;
        repaint();
    }
    
    public void caseValide(){
        this.couleur = VERT;
        this.active = true;
        timer.start();
        repaint();
    }
    
    public void caseInvalide(){
        this.couleur = ROUGE;
        this.active = true;
        timer.start();
        repaint();
    }
    
    private void timerEventHandler(ActionEvent e){
        timer.stop();
        this.active = false;
        if (sombre){
            this.couleur = NOIR;
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

        setBackground(new java.awt.Color(240, 215, 125));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage image;
    private int numero;
    private Timer timer;
    private Color couleur;
    private final Color NORMAL = new java.awt.Color(240, 215, 125);
    private final Color VERT = new java.awt.Color(0, 181, 45, 80);
    private final Color ROUGE = new java.awt.Color(255, 0, 0, 80);
    private final Color NOIR = new java.awt.Color(0, 0, 0, 90);
    private boolean sombre = false;
    private boolean active = false;
    private String description;
    private int imSize = 96;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
