/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseBoue {
    private final int CHANGEMENTBOUE = -3;
    
    public void action(Pirate pirate, ControlJeuPirate controljeuPirate) {
        System.out.println("Le joueur viens d arriver sur une case boue et seras donc penalise pour le prochain tour.");
    	controljeuPirate.setChangement(CHANGEMENTBOUE,pirate);
    }
}
