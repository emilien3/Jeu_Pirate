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
    
    public ControleurCaseBoue(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        super.controlJeuPirate = controlJeuPirate;
        super.boundary = boundary;
    }
    
    @Override
    public void action(Pirate pirate) {
        //Action de la case
        pirate.setChangement(CHANGEMENTBOUE);
        boundary.changementProchainTour(this);
    }

    @Override
    public int getChangement(){
        // Est appelée quand l'affichage a besoin du changement
        return CHANGEMENTBOUE;
    }

    @Override
    public void finChangement() {
        // Est appelée quand l'affichage a fini d'afficher le changement
        finAction();
    }
}
