/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PJR4505A
 */
public class JPlateau extends javax.swing.JPanel {

    /**
     * Creates new form JPlateau
     */
    
    private List<PanelCase> cases ;


    public JPlateau() {
        initComponents();
        initCase();
    }
    
    private void initCase(){
        cases = new ArrayList<>();
        Component[] composants = layeredPaneCase.getComponents();
        for (Component composant : composants) {
            if (composant instanceof PanelCase panelCase) {
                cases.add(panelCase);
            }
        }
        Collections.sort(cases , (PanelCase case1, PanelCase case2) -> {
        int posCase1 = layeredPaneCase.getPosition(case1);
        int posCase2 = layeredPaneCase.getPosition(case2);
        return Integer.compare(posCase1, posCase2);
        });
        for (int i = 1; i < cases.size() + 1; i++) {
            PanelCase caseAct = cases.get(i - 1);
            caseAct.setNumero(i);
            caseAct.setImage("ile.png"); // pour les images personaliser
        }
    }
    
    public void setImage(String[] images) {
        for (int i = 1; i < cases.size() + 1; i++) {
            PanelCase caseAct = cases.get(i - 1);
            caseAct.setImage(images[i - 1]);
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

        layeredPaneJeton = new javax.swing.JLayeredPane();
        jetonJack = new boundary.JPion();
        jetonBill = new boundary.JPion();
        layeredPaneCase = new javax.swing.JLayeredPane();
        case1 = new boundary.PanelCase();
        case2 = new boundary.PanelCase();
        case3 = new boundary.PanelCase();
        case4 = new boundary.PanelCase();
        case5 = new boundary.PanelCase();
        case6 = new boundary.PanelCase();
        case7 = new boundary.PanelCase();
        case8 = new boundary.PanelCase();
        case9 = new boundary.PanelCase();
        case10 = new boundary.PanelCase();
        case11 = new boundary.PanelCase();
        case12 = new boundary.PanelCase();
        case13 = new boundary.PanelCase();
        case14 = new boundary.PanelCase();
        case15 = new boundary.PanelCase();
        case16 = new boundary.PanelCase();
        case17 = new boundary.PanelCase();
        case18 = new boundary.PanelCase();
        case19 = new boundary.PanelCase();
        case20 = new boundary.PanelCase();
        case21 = new boundary.PanelCase();
        case22 = new boundary.PanelCase();
        case23 = new boundary.PanelCase();
        case24 = new boundary.PanelCase();
        case25 = new boundary.PanelCase();
        case26 = new boundary.PanelCase();
        case27 = new boundary.PanelCase();
        case28 = new boundary.PanelCase();
        case29 = new boundary.PanelCase();
        case30 = new boundary.PanelCase();

        layeredPaneJeton.setPreferredSize(new java.awt.Dimension(654, 760));

        jetonJack.setBackground(new java.awt.Color(255, 255, 255));
        jetonJack.setPathProperty("pion_jack.png");
        jetonJack.setPreferredSize(new java.awt.Dimension(48, 48));
        jetonJack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jetonJackMouseDragged(evt);
            }
        });
        jetonJack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jetonJackMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jetonJackLayout = new javax.swing.GroupLayout(jetonJack);
        jetonJack.setLayout(jetonJackLayout);
        jetonJackLayout.setHorizontalGroup(
            jetonJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jetonJackLayout.setVerticalGroup(
            jetonJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jetonBill.setMovable(true);
        jetonBill.setPathProperty("pion_bill.png");
        jetonBill.setPreferredSize(new java.awt.Dimension(48, 48));
        jetonBill.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jetonBillMouseDragged(evt);
            }
        });
        jetonBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jetonBillMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jetonBillLayout = new javax.swing.GroupLayout(jetonBill);
        jetonBill.setLayout(jetonBillLayout);
        jetonBillLayout.setHorizontalGroup(
            jetonBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jetonBillLayout.setVerticalGroup(
            jetonBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        layeredPaneJeton.setLayer(jetonJack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPaneJeton.setLayer(jetonBill, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPaneJetonLayout = new javax.swing.GroupLayout(layeredPaneJeton);
        layeredPaneJeton.setLayout(layeredPaneJetonLayout);
        layeredPaneJetonLayout.setHorizontalGroup(
            layeredPaneJetonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneJetonLayout.createSequentialGroup()
                .addGroup(layeredPaneJetonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layeredPaneJetonLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jetonBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layeredPaneJetonLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jetonJack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        layeredPaneJetonLayout.setVerticalGroup(
            layeredPaneJetonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneJetonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jetonJack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jetonBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(640, Short.MAX_VALUE))
        );

        layeredPaneCase.setPreferredSize(new java.awt.Dimension(654, 760));
        layeredPaneCase.setLayout(new java.awt.GridLayout(6, 5));

        javax.swing.GroupLayout case1Layout = new javax.swing.GroupLayout(case1);
        case1.setLayout(case1Layout);
        case1Layout.setHorizontalGroup(
            case1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case1Layout.setVerticalGroup(
            case1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case1);

        javax.swing.GroupLayout case2Layout = new javax.swing.GroupLayout(case2);
        case2.setLayout(case2Layout);
        case2Layout.setHorizontalGroup(
            case2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case2Layout.setVerticalGroup(
            case2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case2);

        javax.swing.GroupLayout case3Layout = new javax.swing.GroupLayout(case3);
        case3.setLayout(case3Layout);
        case3Layout.setHorizontalGroup(
            case3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case3Layout.setVerticalGroup(
            case3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case3);

        javax.swing.GroupLayout case4Layout = new javax.swing.GroupLayout(case4);
        case4.setLayout(case4Layout);
        case4Layout.setHorizontalGroup(
            case4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case4Layout.setVerticalGroup(
            case4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case4);

        javax.swing.GroupLayout case5Layout = new javax.swing.GroupLayout(case5);
        case5.setLayout(case5Layout);
        case5Layout.setHorizontalGroup(
            case5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case5Layout.setVerticalGroup(
            case5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case5);

        javax.swing.GroupLayout case6Layout = new javax.swing.GroupLayout(case6);
        case6.setLayout(case6Layout);
        case6Layout.setHorizontalGroup(
            case6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case6Layout.setVerticalGroup(
            case6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case6);

        javax.swing.GroupLayout case7Layout = new javax.swing.GroupLayout(case7);
        case7.setLayout(case7Layout);
        case7Layout.setHorizontalGroup(
            case7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case7Layout.setVerticalGroup(
            case7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case7);

        javax.swing.GroupLayout case8Layout = new javax.swing.GroupLayout(case8);
        case8.setLayout(case8Layout);
        case8Layout.setHorizontalGroup(
            case8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case8Layout.setVerticalGroup(
            case8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case8);

        javax.swing.GroupLayout case9Layout = new javax.swing.GroupLayout(case9);
        case9.setLayout(case9Layout);
        case9Layout.setHorizontalGroup(
            case9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case9Layout.setVerticalGroup(
            case9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case9);

        javax.swing.GroupLayout case10Layout = new javax.swing.GroupLayout(case10);
        case10.setLayout(case10Layout);
        case10Layout.setHorizontalGroup(
            case10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case10Layout.setVerticalGroup(
            case10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case10);

        javax.swing.GroupLayout case11Layout = new javax.swing.GroupLayout(case11);
        case11.setLayout(case11Layout);
        case11Layout.setHorizontalGroup(
            case11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case11Layout.setVerticalGroup(
            case11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case11);

        javax.swing.GroupLayout case12Layout = new javax.swing.GroupLayout(case12);
        case12.setLayout(case12Layout);
        case12Layout.setHorizontalGroup(
            case12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case12Layout.setVerticalGroup(
            case12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case12);

        javax.swing.GroupLayout case13Layout = new javax.swing.GroupLayout(case13);
        case13.setLayout(case13Layout);
        case13Layout.setHorizontalGroup(
            case13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case13Layout.setVerticalGroup(
            case13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case13);

        javax.swing.GroupLayout case14Layout = new javax.swing.GroupLayout(case14);
        case14.setLayout(case14Layout);
        case14Layout.setHorizontalGroup(
            case14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case14Layout.setVerticalGroup(
            case14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case14);

        javax.swing.GroupLayout case15Layout = new javax.swing.GroupLayout(case15);
        case15.setLayout(case15Layout);
        case15Layout.setHorizontalGroup(
            case15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case15Layout.setVerticalGroup(
            case15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case15);

        javax.swing.GroupLayout case16Layout = new javax.swing.GroupLayout(case16);
        case16.setLayout(case16Layout);
        case16Layout.setHorizontalGroup(
            case16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case16Layout.setVerticalGroup(
            case16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case16);

        javax.swing.GroupLayout case17Layout = new javax.swing.GroupLayout(case17);
        case17.setLayout(case17Layout);
        case17Layout.setHorizontalGroup(
            case17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case17Layout.setVerticalGroup(
            case17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case17);

        javax.swing.GroupLayout case18Layout = new javax.swing.GroupLayout(case18);
        case18.setLayout(case18Layout);
        case18Layout.setHorizontalGroup(
            case18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case18Layout.setVerticalGroup(
            case18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case18);

        javax.swing.GroupLayout case19Layout = new javax.swing.GroupLayout(case19);
        case19.setLayout(case19Layout);
        case19Layout.setHorizontalGroup(
            case19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case19Layout.setVerticalGroup(
            case19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case19);

        javax.swing.GroupLayout case20Layout = new javax.swing.GroupLayout(case20);
        case20.setLayout(case20Layout);
        case20Layout.setHorizontalGroup(
            case20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case20Layout.setVerticalGroup(
            case20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case20);

        javax.swing.GroupLayout case21Layout = new javax.swing.GroupLayout(case21);
        case21.setLayout(case21Layout);
        case21Layout.setHorizontalGroup(
            case21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case21Layout.setVerticalGroup(
            case21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case21);

        javax.swing.GroupLayout case22Layout = new javax.swing.GroupLayout(case22);
        case22.setLayout(case22Layout);
        case22Layout.setHorizontalGroup(
            case22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case22Layout.setVerticalGroup(
            case22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case22);

        javax.swing.GroupLayout case23Layout = new javax.swing.GroupLayout(case23);
        case23.setLayout(case23Layout);
        case23Layout.setHorizontalGroup(
            case23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case23Layout.setVerticalGroup(
            case23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case23);

        javax.swing.GroupLayout case24Layout = new javax.swing.GroupLayout(case24);
        case24.setLayout(case24Layout);
        case24Layout.setHorizontalGroup(
            case24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case24Layout.setVerticalGroup(
            case24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case24);

        javax.swing.GroupLayout case25Layout = new javax.swing.GroupLayout(case25);
        case25.setLayout(case25Layout);
        case25Layout.setHorizontalGroup(
            case25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case25Layout.setVerticalGroup(
            case25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case25);

        javax.swing.GroupLayout case26Layout = new javax.swing.GroupLayout(case26);
        case26.setLayout(case26Layout);
        case26Layout.setHorizontalGroup(
            case26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case26Layout.setVerticalGroup(
            case26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case26);

        javax.swing.GroupLayout case27Layout = new javax.swing.GroupLayout(case27);
        case27.setLayout(case27Layout);
        case27Layout.setHorizontalGroup(
            case27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case27Layout.setVerticalGroup(
            case27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case27);

        javax.swing.GroupLayout case28Layout = new javax.swing.GroupLayout(case28);
        case28.setLayout(case28Layout);
        case28Layout.setHorizontalGroup(
            case28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case28Layout.setVerticalGroup(
            case28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case28);

        javax.swing.GroupLayout case29Layout = new javax.swing.GroupLayout(case29);
        case29.setLayout(case29Layout);
        case29Layout.setHorizontalGroup(
            case29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case29Layout.setVerticalGroup(
            case29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case29);

        javax.swing.GroupLayout case30Layout = new javax.swing.GroupLayout(case30);
        case30.setLayout(case30Layout);
        case30Layout.setHorizontalGroup(
            case30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        case30Layout.setVerticalGroup(
            case30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        layeredPaneCase.add(case30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPaneJeton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(layeredPaneCase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPaneJeton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(layeredPaneCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jetonDeplacement(JPion jeton){
        int newX = (int) this.getMousePosition().getX()- jeton.getWidth() / 2;
        int newY = (int) this.getMousePosition().getY() - jeton.getHeight() / 2;
        jeton.setLocation(newX, newY);
    }
    
    public int getCaseOnJeton(JPion jeton){
        int res = 0;
        for (int i = 0; i < cases.size(); i++) {
            Rectangle bounds = cases.get(i).getBounds();
            if(bounds.contains(jeton.getX(), jeton.getY())){
                res = i;
                break;
            }
        }
        return res;
    }

    public JPion getJetonBill() {
        return jetonBill;
    }
    
    public JPion getJetonJack() {
        return jetonJack;
    }
    
    public PanelCase getCase(int i) {
        return cases.get(i);
    }
    
        public List<PanelCase> getCases() {
        return cases;
    }
        
    private void jetonJackMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jetonJackMouseDragged
        if(jetonJack.isMovable()) {
            jetonDeplacement(jetonJack);
        }
    }//GEN-LAST:event_jetonJackMouseDragged

    private void jetonJackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jetonJackMouseReleased
        int positionCase = getCaseOnJeton(jetonJack);
        System.out.println(positionCase);
        // TODO : informer le JDialog que le pion est a cette case

    }//GEN-LAST:event_jetonJackMouseReleased

    private void jetonBillMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jetonBillMouseDragged
        if(jetonBill.isMovable()) {
            jetonDeplacement(jetonBill);
        }
    }//GEN-LAST:event_jetonBillMouseDragged

    private void jetonBillMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jetonBillMouseReleased
        int positionCase = getCaseOnJeton(jetonBill);
        System.out.println(positionCase);
        // TODO : informer le JDialog que le pion est a cette case
    }//GEN-LAST:event_jetonBillMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private boundary.PanelCase case1;
    private boundary.PanelCase case10;
    private boundary.PanelCase case11;
    private boundary.PanelCase case12;
    private boundary.PanelCase case13;
    private boundary.PanelCase case14;
    private boundary.PanelCase case15;
    private boundary.PanelCase case16;
    private boundary.PanelCase case17;
    private boundary.PanelCase case18;
    private boundary.PanelCase case19;
    private boundary.PanelCase case2;
    private boundary.PanelCase case20;
    private boundary.PanelCase case21;
    private boundary.PanelCase case22;
    private boundary.PanelCase case23;
    private boundary.PanelCase case24;
    private boundary.PanelCase case25;
    private boundary.PanelCase case26;
    private boundary.PanelCase case27;
    private boundary.PanelCase case28;
    private boundary.PanelCase case29;
    private boundary.PanelCase case3;
    private boundary.PanelCase case30;
    private boundary.PanelCase case4;
    private boundary.PanelCase case5;
    private boundary.PanelCase case6;
    private boundary.PanelCase case7;
    private boundary.PanelCase case8;
    private boundary.PanelCase case9;
    private boundary.JPion jetonBill;
    private boundary.JPion jetonJack;
    private javax.swing.JLayeredPane layeredPaneCase;
    private javax.swing.JLayeredPane layeredPaneJeton;
    // End of variables declaration//GEN-END:variables
}
