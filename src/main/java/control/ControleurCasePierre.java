/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Etat;
import model.Pirate;

public class ControleurCasePierre extends ControlActiverCaseSpeciale implements IChangerEtat {
	private IBoundary boundary;
	
	public ControleurCasePierre( ControlJeuPirate controlJeuPirate,IBoundary boundary ) {
		super.controlJeuPirate = controlJeuPirate;
		this.boundary=boundary;
		// TODO Auto-generated constructor stub
	}


	@Override
	public Etat getEtat() {
		// TODO Auto-generated method stub
		return Etat.PASSETOUR;
	}

	@Override
	public void finChangerEtat() {
		// TODO Auto-generated method stub
		controlJeuPirate.finActionCase();
	
	}

	@Override
	public void action(Pirate pirate) {
		// TODO Auto-generated method stub
		pirate.setEtat(Etat.PASSETOUR);
		boundary.changerEtat(this);
	
	}

}

