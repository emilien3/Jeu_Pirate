/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.CaseFalaise;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseFalaise extends ControlActiverCaseSpeciale implements IDeplacerPirate, IModifierVie {
    private final int PERTEPOINTDEVIE = -2;
    private ControlJeuPirate controlJeuPirate;
    private IBoundary boundary;
    
    public ControleurCaseFalaise(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        this.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
    }
    
    @Override
    public void action(Pirate pirate) {
        System.out.println("Le joueur vient d arriver sur une case falaise il revient donc de la case d ou il vient et pert de la vie.");
        int lastPosition = controlJeuPirate.getLastPosition();
        deplacer(pirate, pirate.getPosition() - lastPosition);
        modifierVie(PERTEPOINTDEVIE, pirate);
    }

    @Override
    public void deplacer(Pirate pirate, int deplacement) {
        pirate.setPosition(pirate.getPosition() - deplacement);
        boundary.deplacer(this);
    }

    @Override
    public void finDeplacement() {
        boundary.modifierVie(this);
    }

    @Override
    public void modifierVie(int points, Pirate pirate) {
        pirate.setLife(pirate.getLife() + point);
    }

    @Override
    public void finModifVie() {
        finAction();
    }
}
