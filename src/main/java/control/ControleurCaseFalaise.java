/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CaseFalaise;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseFalaise {
    
    
     public void action(Pirate pirate,ControlJeuPirate controljeuPirate) {
        controljeuPirate.deplacerVersPositionPrecedente(pirate);
        controljeuPirate.perdrePointsDeVie(CaseFalaise.PERTEPOINTDEVIE,pirate);
    }
}
