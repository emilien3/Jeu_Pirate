package boundaryComponants;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 *
 * @author Emilien
 */
public class JDicePanel extends javax.swing.JPanel {

    
    private BufferedImage image;
    private int number;
    
    
    /**
     * Creates new form mon_panel
     */
    public JDicePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    
    public void changeImage (BufferedImage im){
        this.image = im;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D ds = (Graphics2D)g;
        ds.drawImage(image, 0, 0,getWidth(), getHeight(), this);
        
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
