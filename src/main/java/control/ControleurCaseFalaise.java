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
public class ControleurCaseFalaise {
    private final int PERTEPOINTDEVIE = 2;
    
     public void action(Pirate pirate,ControlJeuPirate controljeuPirate) {
         System.out.println("Le joueur vient d arriver sur une case falaise il revient donc de la case d ou il vient et pert de la vie.");
        controljeuPirate.deplacerVersPositionPrecedente(pirate);
        controljeuPirate.perdrePointsDeVie(PERTEPOINTDEVIE,pirate);
    }
}
