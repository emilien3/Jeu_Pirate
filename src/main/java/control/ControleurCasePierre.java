/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Etat;
import model.Pirate;

public class ControleurCasePierre extends ControlActiverCaseSpeciale implements IChangerEtat {
	
	public ControleurCasePierre( ControlJeuPirate controlJeuPirate,IBoundary boundary ) {
            super.controlJeuPirate = controlJeuPirate;
            super.boundary=boundary;
	}


	@Override
	public Etat getEtat() {
            return Etat.PASSETOUR;
	}

	@Override
	public void finChangerEtat() {
            finAction();
	
	}

	@Override
	public void action(Pirate pirate) {
            pirate.setEtat(Etat.PASSETOUR);
            boundary.changerEtat(this);
	}

}

