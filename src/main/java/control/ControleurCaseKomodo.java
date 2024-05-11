/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.CaseKomodo;
import model.De;
import model.Etat;
import model.Pirate;

public class ControleurCaseKomodo extends ControlActiverCaseSpeciale implements IChangerEtat,IModifierVie,IDeplacerPirate, ILancerDe,IChangement {
    private IBoundary boundary;
    private final int CHANGEMENT = -3;
    private final int PERTEPOINTDEVIE = 3;
    private final int GAGNE = 8;
    private int arrivee,depart;
    
    public ControleurCaseKomodo(ControlJeuPirate controlJeuPirate, IBoundary boundary){
        super.controlJeuPirate=controlJeuPirate;
        this.boundary=boundary;
    }
    public void action(Pirate pirate) {
    	pirate.getEtat();
    	this.depart = pirate.getPosition();
    	
    	int[] des = getDes();
    	int sommeDes = des[0] + des[1];
    	if (sommeDes<GAGNE) {
    		pirate.setEtat(Etat.ESTVIVANT);
    		this.arrivee=depart;
    		pirate.setPosition(arrivee);
    		pirate.setLastPosition(arrivee);
    		modifierVie(PERTEPOINTDEVIE, pirate);
    		changerProchainTour(pirate);
    	}else {
    		pirate.setEtat(Etat.ESTVIVANT);
    		this.arrivee=depart+8;
    		pirate.setPosition(arrivee);
    		pirate.setLastPosition(arrivee);
    		boundary.deplacerAuto(this);
    		
    		
    	}
    	finChangerEtat();//faire un set Etat? 
        /*
        System.out.println("Le joueur vient d arriver sur une case komodo et dois relancer les des pour savoir si il court assez vite.");
        controljeuPirate.setEtat(Etat.ESTPOURSUIVI, pirate);
        int[] des = controljeuPirate.lancerDe();
        int sommeDes = des[0] + des[1];
        if (sommeDes <= GAGNER) {
            System.out.println("Le joueur n a pas courru assez vite.");
            controljeuPirate.perdrePointsDeVie(PERTEPOINTDEVIE,pirate);
            controljeuPirate.setChangement(CHANGEMENT, pirate);
        } else {
            System.out.println("Le joueur a courru assez vite.");
            controljeuPirate.avancerJoueur(des,pirate);
        }
        controljeuPirate.setEtat(Etat.ESTVIVANT, pirate);
        */
    }
	@Override
	public int[] getDes() {
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
	public int getDepart() {
		// TODO Auto-generated method stub
		return depart ;
	}
	@Override
	public int getArrivee() {
		// TODO Auto-generated method stub
		return arrivee;
	}
	@Override
	public String getEffetCase(int num) {
		return controlJeuPirate.getEffetcase(num);
	}
	@Override
	public void finDeplacement() {
		// TODO Auto-generated method stub
		finAction();
	}
	@Override
	public int getVie() {
		// TODO Auto-generated method stub
		return PERTEPOINTDEVIE;
	}
	@Override
	public void finModifVie() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Etat getEtat() {
		// TODO Auto-generated method stub
		return Etat.ESTPOURSUIVI;
	}
	@Override
	public void finChangerEtat() {
		// TODO Auto-generated method stub
		controlJeuPirate.finActionCase();
		
	}
	public void modifierVie(int points, Pirate pirate) {
        pirate.setLife(pirate.getLife() + points);
        boundary.modifierVie(this);
    }
	 public void changerProchainTour(Pirate pirate) {
	        pirate.setChangement(CHANGEMENT);
	        boundary.changementProchainTour(this);
	    }
	public void avancer(Pirate pirate, int deplacement){
		pirate.setPosition(pirate.getPosition() + deplacement);
        boundary.deplacerAuto(this);
	}
	@Override
	public int getChangement() {
		// TODO Auto-generated method stub
		return CHANGEMENT;
	}
	@Override
	public void finChangement() {
		// TODO Auto-generated method stub
		controlJeuPirate.finActionCase();
	}
	
}
