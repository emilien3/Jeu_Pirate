/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.De;
import model.Etat;
import model.Pirate;

/**
 *
 * @author laura
 */
public class ControleurCaseLianes extends ControlActiverCaseSpeciale implements ILancerDe,IChangerEtat {
    private IBoundary boundary;

	public ControleurCaseLianes(ControlJeuPirate controlJeuPirate, IBoundary boundary) {
		super.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Etat getEtat() {
		// TODO Auto-generated method stub
		return Etat.ESTPRISON;
	}

	@Override
	public void finChangerEtat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getDes() {
		// TODO Auto-generated method stub
		De de1 = new De();
	    De de2 = new De();
	    
	    de1.roll();
	    de2.roll();
	    
	    int[] des = {de1.getValue(), de2.getValue()};
	    
	    return des;
	}

	@Override
	public void finLancer() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void action(Pirate pirate) {
		// TODO Auto-generated method stub
		pirate.setEtat(Etat.ESTPRISON);
		for(int i=0;i<3;i++) {
			int[] des = getDes();
			
			int sommeDes = des[0] + des[1];
			System.out.println("Lancer " + (i+1) +" : " +sommeDes);
			if(sommeDes>=10) {
				pirate.setEtat(Etat.ESTVIVANT);
    		
				controlJeuPirate.finActionCase();
    		
			}
    	
		}
		controlJeuPirate.finActionCase();
	}
}