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
public class ControleurCaseNourriture {
    private final int CHANGEMENT = 2;
    private final int GAINPOINTDEVIE = 1;
    
    public void action(Pirate pirate,ControlJeuPirate controlJeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case nourriture il recupere de la vie et est plus for pour le prochain tour.");
        controlJeuPirate.setChangement(CHANGEMENT, pirate);
    	//controlJeuPirate.avancerJoueur(2); Variante ou le bonus est direct
        controlJeuPirate.gagnerPointsDeVie(GAINPOINTDEVIE,pirate); 
    }
}
