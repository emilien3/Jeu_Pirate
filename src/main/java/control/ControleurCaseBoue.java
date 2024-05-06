/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CaseBoue;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseBoue {
    
    
    public void action(Pirate pirate, ControlJeuPirate controljeuPirate) {
    	controljeuPirate.setChangement(CaseBoue.CHANGEMENTBOUE,pirate);
    }
}
