/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.stream.IntStream;
import model.Etat;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseKomodo {
    private final int CHANGEMENT = -3;
    private final int PERTEPOINTDEVIE = 3;
    private final int GAGNER = 8;
    
    public void action(Pirate pirate, ControlJeuPirate controljeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case komodo et dois relancer les des pour savoir si il court assez vite.");
        controljeuPirate.setEtat(Etat.ESTPOURSUIVI, pirate);
        int[] des = controljeuPirate.lancerDe();
        //int sommeDes = des[0] + des[1];
        int sommeDes = IntStream.of(des).sum();
        /*Fonctionnel possible : int sommeDes = IntStream.of(des).sum();*/
        if (sommeDes <= GAGNER) {
            System.out.println("Le joueur n a pas courru assez vite.");
            controljeuPirate.perdrePointsDeVie(PERTEPOINTDEVIE,pirate);
            controljeuPirate.setChangement(CHANGEMENT, pirate);
        } else {
            System.out.println("Le joueur a courru assez vite.");
            controljeuPirate.avancerJoueur(des,pirate);
        }
        controljeuPirate.setEtat(Etat.ESTVIVANT, pirate);
    }
}
