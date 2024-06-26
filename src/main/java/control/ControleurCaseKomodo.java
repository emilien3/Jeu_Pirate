/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import java.util.function.Function;
import java.util.stream.Stream;
import model.De;
import model.Etat;
import model.Pirate;

public class ControleurCaseKomodo extends ControlActiverCaseSpeciale implements IModifierVie,IDeplacerPirate, ILancerDe,IChangement, IChangerEtat {
    private IBoundary boundary;
    private final int CHANGEMENT = -3;
    private final int PERTEPOINTDEVIE = -3;
    private final int GAGNE = 8;
    private int arrivee,depart, lancer;
    private De[] des;
    private Pirate pirate;
    
        public ControleurCaseKomodo(ControlJeuPirate controlJeuPirate, IBoundary boundary, De[] des){
            super.controlJeuPirate=controlJeuPirate;
            this.boundary=boundary;
            this.des = des;

        }
        public void action(Pirate pirate) {
            this.pirate = pirate;
            this.depart = pirate.getPosition();
            pirate.setEtat(Etat.ESTPOURSUIVI);
            boundary.changerEtat(this);
        }
    
        @Override
        public Etat getEtat() {
            return pirate.getEtat();
        }

        @Override
        public void finChangerEtat() {
            if (pirate.getEtat()==Etat.ESTPOURSUIVI){
                lancerDes();
                boundary.lancerDe(this);
            }else if (pirate.getEtat()==Etat.ESTVIVANT && lancer >=8){
                finAction();
            }else{
                pirate.setChangement(CHANGEMENT);
                boundary.changementProchainTour(this);
            }
            
        }
  
	@Override
	public int[] getDes() {
            Function<De[], int[]> getValeurs = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).toArray();
            return getValeurs.apply(des);
	}
        
        private int totalDes(De[] des){
            //Pour recupérer la somme des valeurs des dés
            Function<De[], Integer> somme = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).reduce(0, (a, b) -> a+b);
            return somme.apply(des);
        }
        
        private void lancerDes(){
            for (De d : des){
                d.roll();
            }
            lancer = totalDes(des);
        }
        
	@Override
	public void finLancer() {
            if (lancer<GAGNE) {
                pirate.setLife(pirate.getLife() + PERTEPOINTDEVIE);
                boundary.modifierVie(this);
            }else{
                this.arrivee=depart + lancer;
                pirate.setPosition(arrivee);
                boundary.deplacerAuto(this);
            }
	}
  
	@Override
	public int getDepart() {
		return depart ;
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
            pirate.setEtat(Etat.ESTVIVANT);
            boundary.changerEtat(this);
	}
	@Override
	public int getVie() {
            return PERTEPOINTDEVIE;
	}
	@Override
	public void finModifVie() {
            pirate.setEtat(Etat.ESTVIVANT);
            boundary.changerEtat(this);
	}

	@Override
	public int getChangement() {
            return CHANGEMENT;
	}
        
	@Override
	public void finChangement() {
            finAction();
	}

        
	
}
