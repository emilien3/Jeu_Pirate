/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;

public class ControleurCaseNourriture extends ControlActiverCaseSpeciale implements IChangement,IModifierVie {
	private final int CHANGEMENT=2;
	private final int GAINPOINTDEVIE=1;
	private IBoundary boundary;
	
	

	public ControleurCaseNourriture(ControlJeuPirate controlJeuPirate, IBoundary boundary) {
		super.controlJeuPirate= controlJeuPirate;
		this.boundary = boundary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getVie() {
		// TODO Auto-generated method stub
		return GAINPOINTDEVIE;
	}

	

	@Override
	public int getChangement() {
		// TODO Auto-generated method stub
		return CHANGEMENT;
	}

	@Override
	public void finChangement() {
		controlJeuPirate.finActionCase();
	}

	@Override
	public void action(Pirate pirate) {
		// TODO Auto-generated method stub
		modifierVie(GAINPOINTDEVIE, pirate);
		changerProchainTour(pirate);
	}

	@Override
	public void finModifVie() {
		// TODO Auto-generated method stub
		
	}
	public void modifierVie(int points, Pirate pirate) {
        pirate.setLife(pirate.getLife() + points);
        boundary.modifierVie(this);
    }
	public void changerProchainTour(Pirate pirate) {
        pirate.setChangement(CHANGEMENT);
        boundary.changementProchainTour(this);
    }

}
