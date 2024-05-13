/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;


public class ControleurRetourCaseDebut extends ControlActiverCaseSpeciale implements IDeplacerPirate{
	private int depart, arrivee;
	

	public ControleurRetourCaseDebut(ControlJeuPirate controlJeuPirate, IBoundary boundary) {
		super.controlJeuPirate =controlJeuPirate;
		super.boundary=boundary;
	}

	@Override
	public int getDepart() {
		return depart;
	}

	@Override
	public int getArrivee() {
		return arrivee;
	}

	@Override
	public String getEffetCase(int num) {
		return controlJeuPirate.getEffetcase(num);
	}

	@Override
	public void finDeplacement() {
		finAction();
		
	}

	@Override
	public void action(Pirate pirate) {
            this.depart= pirate.getPosition();
            this.arrivee=0;
            pirate.setPosition(arrivee);
            pirate.setLastPosition(depart);
            boundary.deplacerAuto(this);	
	}
}
