package boundary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class DiceCoursePanel extends JPanel{

    private List <BufferedImage> buffer;
    private DicePanel diceArray[];
    private Timer timerArray[];
    
    private Random seed;
    
    
    /**
     * Creates new form DiceCoursePanel
     */
    public DiceCoursePanel() {
        this.buffer = new ArrayList<>();
        
        this.seed = new Random();
        
        this.diceArray = new DicePanel[2];
        this.timerArray = new Timer[3];
        
        try {
            buffer.add(ImageIO.read(getClass().getResource("/de1.png")));
            buffer.add(ImageIO.read(getClass().getResource("/de2.png")));
            buffer.add(ImageIO.read(getClass().getResource("/de3.png")));
            buffer.add(ImageIO.read(getClass().getResource("/de4.png")));
            buffer.add(ImageIO.read(getClass().getResource("/de5.png")));
            buffer.add(ImageIO.read(getClass().getResource("/de6.png")));
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        initComponents();
        
        diceArray[0] = dicePanel1;
        diceArray[1] = dicePanel2;
        
        timerArray[0] = new Timer(100, e -> {
            // Changer l'image du dé aléatoirement
            int index = seed.nextInt(6);
            diceArray[0].changeImage(getBuffer().get(index));
        });
        timerArray[1] = new Timer(100, e -> {
            // Changer l'image du dé aléatoirement
            int index = seed.nextInt(6);
            diceArray[1].changeImage(getBuffer().get(index));
        });
        timerArray[2] = new Timer(2000, e -> {
            timerArray[0].stop();
            timerArray[1].stop();
            timerArray[2].stop();
            endAnimation();
        });
        
        diceArray[0].changeImage(getBuffer().get(0));
        diceArray[1].changeImage(getBuffer().get(5));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonThrow = new javax.swing.JButton();
        dicePanel1 = new boundary.DicePanel();
        dicePanel2 = new boundary.DicePanel();

        jButtonThrow.setText("Throw");
        jButtonThrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThrowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dicePanel1Layout = new javax.swing.GroupLayout(dicePanel1);
        dicePanel1.setLayout(dicePanel1Layout);
        dicePanel1Layout.setHorizontalGroup(
            dicePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dicePanel1Layout.setVerticalGroup(
            dicePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dicePanel2Layout = new javax.swing.GroupLayout(dicePanel2);
        dicePanel2.setLayout(dicePanel2Layout);
        dicePanel2Layout.setHorizontalGroup(
            dicePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dicePanel2Layout.setVerticalGroup(
            dicePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(dicePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(dicePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButtonThrow)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonThrow)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dicePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dicePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThrowActionPerformed
        diceAnimation();
        
    }//GEN-LAST:event_jButtonThrowActionPerformed

    private Dialog dialog;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private boundary.DicePanel dicePanel1;
    private boundary.DicePanel dicePanel2;
    private javax.swing.JButton jButtonThrow;
    // End of variables declaration//GEN-END:variables

    
    private void endAnimation(){
        dialog.eventLancerDe();
    }
    
    /**
     * @return the buffer
     */
    public List <BufferedImage> getBuffer() {
        return buffer;
    }
    
    public void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
    
    /**
     * @return the seed
     */
    public Random getSeed() {
        return seed;
    }

    
    public void diceAnimation(){
        timerArray[0].start();
        timerArray[1].start();
        timerArray[2].start();
    } 

    public void enablejButtonThrow(boolean enabled) {
        jButtonThrow.setEnabled(enabled);
    }
    
    public void setValuesDice(int[] values){
        dicePanel1.changeImage(getBuffer().get(values[0] - 1));
        dicePanel2.changeImage(getBuffer().get(values[1] - 1));
    }
    
}
