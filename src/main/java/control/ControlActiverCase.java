/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Cases;

/**
 *
 * @author Ninon
 */
public class ControlActiverCase implements IActiverCase {
    private ControlJeuPirate controlJeuPirate;
    private ControleurCase controleurCase;
    private ControleurCaseBoue controleurCaseBoue;
    private ControleurCaseFalaise controleurCaseFalaise;
    private ControleurCaseKomodo controleurCaseKomodo;
    private ControleurCaseLianes controleurCaseLianes;
    private ControleurCaseNourriture controleurCaseNourriture;
    private ControleurCasePierre controleurCasePierre;
    private ControleurCaseSecret controleurCaseSecret;

    public ControlActiverCase(ControlJeuPirate controlJeuPirate) {
        this.controlJeuPirate = controlJeuPirate;
        controleurCase = new ControleurCase();
    }
    
    public void action(Class<? extends Cases> caseClass){
        if (caseClass.isInstance(new Cases(0))) {
            controleurCase.action(controlJeuPirate);
        }
    }
    
}
