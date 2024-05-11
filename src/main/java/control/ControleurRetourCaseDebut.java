/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;

public class ControleurRetourCaseDebut extends ControlActiverCaseSpeciale implements IDeplacerPirate{
	
	private IBoundary boundary;
	private int depart, arrivee;
	

	public ControleurRetourCaseDebut(ControlJeuPirate controlJeuPirate, IBoundary boundary) {
		super.controlJeuPirate =controlJeuPirate;
		this.boundary=boundary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDepart() {
		// TODO Auto-generated method stub
		return depart;
	}

	@Override
	public int getArrivee() {
		// TODO Auto-generated method stub
		return arrivee;
	}

	@Override
	public String getEffetCase(int num) {
		// TODO Auto-generated method stub
		return controlJeuPirate.getEffetcase(num);
	}

	@Override
	public void finDeplacement() {
		// TODO Auto-generated method stub
		finAction();
		
	}

	@Override
	public void action(Pirate pirate) {
		// TODO Auto-generated method stub
		this.depart= pirate.getPosition();
		this.arrivee=0;
		pirate.setPosition(arrivee);
        pirate.setLastPosition(depart);
        boundary.deplacerAuto(this);
		
	}

}
