/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.BoundaryConsole;
import boundary.IBoundary;
import model.*;

/**
 *
 * @author Ninon
 */
public class ControlJeuPirate {
    private IBoundary boundary;
    private ControlActiverCase controlActiverCase;
    private ControlDeplacer controlDeplacer;
    private ControlLancerDe controlLancerDe;
    private ControlVerifierFin controlVeriferFin;
    
    private JeuPirate jeuPirate;

    public ControlJeuPirate() {
        this.boundary = new BoundaryConsole();
        this.controlActiverCase = new ControlActiverCase();
        this.controlDeplacer = new ControlDeplacer();
        this.controlLancerDe = new ControlLancerDe();
        this.jeuPirate = new JeuPirate();
        this.controlVeriferFin = new ControlVerifierFin(jeuPirate);
    }
    
    public void jouer(){
        boolean termine = false;
        int tour = 0;
        while(!termine) {            
            jeuPirate.getPirates()[tour%2].tour();
            termine = controlVeriferFin.estFinis();
            tour ++;
        }
    }
    
}
