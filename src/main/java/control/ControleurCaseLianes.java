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

/**
 *
 * @author laura
 */

public class ControleurCaseLianes extends ControlActiverCaseSpeciale implements ILancerDe,IChangerEtat {
    private Pirate pirate;
    private int compteur, result;
    private De[] des;

	public ControleurCaseLianes(ControlJeuPirate controlJeuPirate, IBoundary boundary, De[] des) {
            super.controlJeuPirate = controlJeuPirate;
            super.boundary = boundary;
            this.des = des;
            this.compteur = 0;
            this.result = 0;
	}

	@Override
	public Etat getEtat() {
		// TODO Auto-generated method stub
		return pirate.getEtat();
	}

	@Override
	public void finChangerEtat() {
            if (pirate.getEtat()==Etat.ESTPRISON){
                lancerDes();
                boundary.lancerDe(this);
            }else{
                finAction();
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
            result = totalDes(des);
            compteur ++;
        }

	@Override
	public void finLancer() {
            if (result != 10 && compteur<3){
                lancerDes();
                boundary.lancerDe(this);
            }else if (result == 10){
                pirate.setEtat(Etat.ESTVIVANT);
                boundary.changerEtat(this);
            }else{
                finAction();
            }
	}

	@Override
	public void action(Pirate pirate) {
                this.pirate = pirate;
                pirate.setEtat(Etat.ESTPRISON);
		boundary.changerEtat(this);
	}
}
