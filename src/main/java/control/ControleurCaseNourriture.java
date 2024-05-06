/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CaseNourriture;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseNourriture {
    
    
    public void action(Pirate pirate,ControlJeuPirate controlJeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case nourriture il recupere de la vie et est plus for pour le prochain tour.");
        controlJeuPirate.setChangement(CaseNourriture.CHANGEMENT, pirate);
    	//controlJeuPirate.avancerJoueur(2); Variante ou le bonus est direct
        controlJeuPirate.gagnerPointsDeVie(CaseNourriture.GAINPOINTDEVIE,pirate); 
    }
}
