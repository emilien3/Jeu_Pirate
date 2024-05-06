/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CaseKomodo;
import model.Etat;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseKomodo {
    
    
    public void action(Pirate pirate, ControlJeuPirate controljeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case komodo et dois relancer les des pour savoir si il court assez vite.");
        controljeuPirate.setEtat(Etat.ESTPOURSUIVI, pirate);
        int[] des = controljeuPirate.lancerDe();
        int sommeDes = des[0] + des[1];
        if (sommeDes <= CaseKomodo.GAGNER) {
            System.out.println("Le joueur n a pas courru assez vite.");
            controljeuPirate.perdrePointsDeVie(CaseKomodo.PERTEPOINTDEVIE,pirate);
            controljeuPirate.setChangement(CaseKomodo.CHANGEMENT, pirate);
        } else {
            System.out.println("Le joueur a courru assez vite.");
            controljeuPirate.avancerJoueur(des,pirate);
        }
        controljeuPirate.setEtat(Etat.ESTVIVANT, pirate);
    }
}
