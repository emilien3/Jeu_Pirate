/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesJava;

/**
 *
 * @author laura
 */
public class ControleurCaseLianes {
    public void action(ControlJeuPirate controljeuPirate) {
        // Action pour une case lianes : le joueur lance le dé jusqu'à trois fois pour obtenir un 10
        System.out.println("Le joueur se trouve sur des lianes !");
        int nbEssais = 3;
        boolean reussi = false;
        for (int i = 0; i < nbEssais; i++) {
            int resultat = controljeuPirate.lancerDe();
            System.out.println("Résultat du lancer de dé : " + resultat);
            if (resultat == 10) {
                reussi = true;
                break;
            }
        }

        if (reussi) {
            System.out.println("Le joueur a réussi à obtenir un 10 ! Il est libéré.");
            controljeuPirate.finTourJoueurActuel();
        } else {
            System.out.println("Le joueur n'a pas réussi à obtenir un 10. Il ne jouera pas au prochain tour.");
        }
    }
}
