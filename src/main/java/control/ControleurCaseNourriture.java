/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesJava;

/**
 *
 * @author laura
 */
public class ControleurCaseNourriture {
    public void action(ControlJeuPirate controlJeuPirate, int nombreCases) {
        
    	controlJeuPirate.avancerJoueur(2); 
        controlJeuPirate.recupererPointDeVie(1); 
        controlJeuPirate.finTourJoueurActuel();
    }
}
