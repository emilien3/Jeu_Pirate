/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;

public class ControleurCaseSecret extends ControlActiverCaseSpeciale  implements IDeplacerPirate{
	private final int AVANCER = 2;
	private IBoundary boundary;
	private int depart, arrivee;
	
	public ControleurCaseSecret(ControlJeuPirate controlJeuPirate, IBoundary boundary ) {
		super.controlJeuPirate=controlJeuPirate;
		this.boundary=boundary;
        
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Pirate pirate) {
		int lastPosition =controlJeuPirate.getLastPosition();
		this.depart=pirate.getPosition();
		this.arrivee=depart+AVANCER;
		deplacer(pirate, AVANCER);
		
	}
	
	public void deplacer(Pirate pirate, int deplacement) {
        pirate.setPosition(pirate.getPosition() + deplacement);
        boundary.deplacerAuto(this);
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

}