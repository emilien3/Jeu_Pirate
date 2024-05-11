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
public class ControleurCaseFalaise extends ControlActiverCaseSpeciale implements IDeplacerPirate, IModifierVie {
    private final int PERTEPOINTDEVIE = -2;
    private IBoundary boundary;
    private int depart, arrivee;
    
    public ControleurCaseFalaise(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        super.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
    }
    
    @Override
    public void action(Pirate pirate) {
        int lastPosition = controlJeuPirate.getLastPosition();
        this.depart = pirate.getPosition();
        this.arrivee = lastPosition;
        
        pirate.setPosition(this.arrivee);
        pirate.setLastPosition(arrivee);
        modifierVie(PERTEPOINTDEVIE, pirate);
        
    }

    

    @Override
    public void finDeplacement() {
        finAction();
    }

    @Override
    public int getVie(){
        return PERTEPOINTDEVIE;
    }
    
    public void modifierVie(int points, Pirate pirate) {
        pirate.setLife(pirate.getLife() + points);
        boundary.modifierVie(this);
    }

    @Override
    public void finModifVie() {
        boundary.deplacerAuto(this);
    }

    @Override
    public int getArrivee() {
        return arrivee;
    }
    
    @Override
    public int getDepart() {
        return depart;
    }

    @Override
    public String getEffetCase(int num) {
        return controlJeuPirate.getEffetcase(num);
    }
}