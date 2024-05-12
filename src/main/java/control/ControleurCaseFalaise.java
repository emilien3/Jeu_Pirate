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
        //Action de la case
        int lastPosition = controlJeuPirate.getLastPosition();
        this.depart = pirate.getPosition();
        this.arrivee = lastPosition;
        pirate.setPosition(arrivee);
        pirate.setLife(pirate.getLife() + PERTEPOINTDEVIE);
        boundary.modifierVie(this);
    }

    @Override
    public void finDeplacement() {
        // Est appelée quand l'affichage a fini d'afficher le déplacement
        finAction();
    }

    @Override
    public int getVie(){
        // Est appelée quand l'affichage a besoin de la valeur du changement de points de vie du pirate courant
        return PERTEPOINTDEVIE;
    }

    @Override
    public void finModifVie() {
        // Est appelée quand l'affichage a fini d'afficher les changement de points de vie
        boundary.deplacerAuto(this);
    }

    @Override
    public int getArrivee() {
        // Est appelée quand l'affichage a besoin de la case d'arrivee
        return arrivee;
    }
    
    @Override
    public int getDepart() {
        // Est appelée quand l'affichage a besoin de la case de départ
        return depart;
    }

    @Override
    public String getEffetCase(int num) {
        // Est appelée quand l'affichage a besoin de l'effet de la case
        return controlJeuPirate.getEffetcase(num);
    }
}
