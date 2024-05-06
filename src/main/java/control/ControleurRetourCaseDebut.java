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
public class ControleurRetourCaseDebut {
    public void action(Pirate pirate,ControlJeuPirate controlJeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case retour debut.");
	controlJeuPirate.retourDepart(pirate);
    }
}
