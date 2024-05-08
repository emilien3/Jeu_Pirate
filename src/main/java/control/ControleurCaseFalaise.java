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
    
    public ControleurCaseFalaise(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        super.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
    }
    
    @Override
    public void action(Pirate pirate) {
        int lastPosition = controlJeuPirate.getLastPosition();
        deplacer(pirate, pirate.getPosition() - lastPosition);
        modifierVie(PERTEPOINTDEVIE, pirate);
    }

    public void deplacer(Pirate pirate, int deplacement) {
        pirate.setPosition(pirate.getPosition() - deplacement);
        boundary.deplacer(this);
    }

    @Override
    public void finDeplacement() {
        boundary.modifierVie(this);
    }

    @Override
    public int getVie(){
        return PERTEPOINTDEVIE;
    }
    
    public void modifierVie(int points, Pirate pirate) {
        pirate.setLife(pirate.getLife() + points);
    }

    @Override
    public void finModifVie() {
        finAction();
    }

    @Override
    public int getNouvellePosition() {
        return controlJeuPirate.getLastPosition();
    }

    @Override
    public String getEffetCase(int num) {
        return controlJeuPirate.getEffetcase(num);
    }
}
