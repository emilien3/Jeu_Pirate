/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.*;

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
    private ControleurRetourCaseDebut controleurRetourCaseDebut;

    public ControlActiverCase(ControlJeuPirate controlJeuPirate) {
        this.controlJeuPirate = controlJeuPirate;
        this.controleurCase = new ControleurCase();
        this.controleurCaseBoue = new ControleurCaseBoue();
        this.controleurCaseFalaise = new ControleurCaseFalaise();
        this.controleurCaseKomodo = new ControleurCaseKomodo();
        this.controleurCaseLianes = new ControleurCaseLianes();
        this.controleurCaseNourriture = new ControleurCaseNourriture();
        this.controleurCasePierre = new ControleurCasePierre();
        this.controleurCaseSecret = new ControleurCaseSecret();
        this.controleurRetourCaseDebut = new ControleurRetourCaseDebut();
    }
    
    public void action(Class<? extends Cases> caseClass,Pirate pirate){
        if (caseClass.isInstance(new Cases(0))) {
            controleurCase.action(controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseBoue(0))) {
            controleurCaseBoue.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseFalaise(0))) {
            controleurCaseFalaise.action(pirate,controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseKomodo(0))) {
            controleurCaseKomodo.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseLianes(0))) {
            controleurCaseLianes.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseNourriture(0))) {
            controleurCaseNourriture.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CasePierre(0))) {
            controleurCasePierre.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseSecret(0))) {
            controleurCaseSecret.action(pirate, controlJeuPirate);
        }
        else if (caseClass.isInstance(new CaseRetourDebut(0))) {
            controleurRetourCaseDebut.action(pirate, controlJeuPirate);
        }
    }
    
}
