/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CaseSecret;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseSecret {
    
    
            
    public void action(Pirate pirate,ControlJeuPirate controleurJeuPirate) {
        System.out.println("Le joueur vient d arriver sur une case passage secret le prends donc.");
        int[] avancer = {0,CaseSecret.AVANCER};
        controleurJeuPirate.avancerJoueur(avancer,pirate); 
    }
}
