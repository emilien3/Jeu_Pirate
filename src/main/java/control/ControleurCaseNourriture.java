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

	public ControleurCaseNourriture(ControlJeuPirate controlJeuPirate, IBoundary boundary) {
		super.controlJeuPirate= controlJeuPirate;
		super.boundary = boundary;
	}

	@Override
	public int getVie() {
		return GAINPOINTDEVIE;
	}

	@Override
	public int getChangement() {
		return CHANGEMENT;
	}

	@Override
	public void finChangement() {
            finAction();
	}

	@Override
	public void action(Pirate pirate) {
            pirate.setLife(pirate.getLife() + GAINPOINTDEVIE);
            pirate.setChangement(CHANGEMENT);
            boundary.modifierVie(this);
	}

	@Override
	public void finModifVie() {
            boundary.changementProchainTour(this);
	}

}
