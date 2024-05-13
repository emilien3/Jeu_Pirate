/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.Pirate;


public class ControleurCaseSecret extends ControlActiverCaseSpeciale  implements IDeplacerPirate{
	private final int AVANCER = 2;
	private int depart, arrivee;
	
	public ControleurCaseSecret(ControlJeuPirate controlJeuPirate, IBoundary boundary ) {
		super.controlJeuPirate=controlJeuPirate;
		super.boundary=boundary;
	}

	@Override
	public void action(Pirate pirate) {
            this.depart = pirate.getPosition();
            this.arrivee = depart + AVANCER;
            pirate.setPosition(depart + AVANCER);
            boundary.deplacerAuto(this);
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
		// TODO Auto-generated method stub
		return controlJeuPirate.getEffetcase(num);
	}


	@Override
	public void finDeplacement() {
            finAction();
	}

}