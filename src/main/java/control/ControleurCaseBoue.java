/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseBoue extends ControlActiverCaseSpeciale implements IChangement{
    private final int CHANGEMENTBOUE = -3;
    private ControlJeuPirate controlJeuPirate;
    private IBoundary boundary;
    
    public ControleurCaseBoue(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        this.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
    }
    
    @Override
    public void action(Pirate pirate) {
        changerProchainTour(pirate);
    }

    @Override
    public void changerProchainTour(Pirate pirate) {
        pirate.setChangement(CHANGEMENTBOUE);
        boundary.changementProchainTour(this);
    }

    @Override
    public void finChangement() {
        controlJeuPirate.finActionCase();
    }
}
