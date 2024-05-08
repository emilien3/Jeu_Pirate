/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Etat;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseLianes {
    public void action(Pirate pirate,ControlJeuPirate controljeuPirate) {
        /*
        // Action pour une case lianes : le joueur lance le dé jusqu'à trois fois pour obtenir un 10
        System.out.println("Le joueur se trouve sur des lianes !");
        controljeuPirate.setEtat(Etat.ESTPRISON, pirate);
        int nbEssais = 3;
        boolean reussi = false;
        for (int i = 0; i < nbEssais; i++) {
            int[] des = controljeuPirate.lancerDe();
            int sommeDes = des[0] + des[1];
            if (sommeDes == 10) {
            //if (des[0] == des[1]) {  pour si le moyen de sortir est egalite.
                reussi = true;
                break;
            }
        }
        if (reussi) {
            System.out.println("Le joueur a réussi à obtenir un 10 ! Il est libéré.");
            controljeuPirate.setEtat(Etat.ESTVIVANT, pirate);
        } else {
            System.out.println("Le joueur n'a pas réussi à obtenir un 10. Il ne jouera pas au prochain tour.");
        }
        */
    }
}
