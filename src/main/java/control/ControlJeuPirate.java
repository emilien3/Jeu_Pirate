/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.BoundaryConsole;
import boundary.IBoundary;
import java.util.Scanner;
import java.util.Scanner;
import model.*;
import boundary.IBoundary;

/**
 *
 * @author Ninon
 */
public class ControlJeuPirate implements IInfoPartie{
    private IBoundary boundary;
    private ControlActiverCaseSpeciale controlActiverCaseSpeciale;
    private ControlDeplacer controlDeplacer;
    private JeuPirate jeuPirate;
    private int numeroPirate;

    public ControlJeuPirate(IBoundary boundary, int nbDes) {
        this.boundary = boundary;
        this.jeuPirate = new JeuPirate();
        De[] des = new De[nbDes];
        for (int i = 0; i<nbDes; i++) {
            des[i] = new De();
        }
        this.controlDeplacer = new ControlDeplacer(this, boundary, jeuPirate.getPlateau().getTAILLETABLEAU(), des, jeuPirate.getPirates());
        this.numeroPirate = 0;
    }
    
    public void debutTour(){
        boundary.debutTour(this);
        controlDeplacer.deplacer(numeroPirate);
    }
    
    public void finDeplacer(){
        Pirate pirateCourant = jeuPirate.getPirates()[numeroPirate];
        CaseEnum caseCourante = jeuPirate.getPlateau().donnerCase(pirateCourant.getPosition());
        switch (caseCourante) {
            case BOUE:
                controlActiverCaseSpeciale = new ControleurCaseBoue(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case DEBUT:
                controlActiverCaseSpeciale = new ControleurRetourCaseDebut(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case FALAISE:
                controlActiverCaseSpeciale = new ControleurCaseFalaise(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case KOMODO:
                controlActiverCaseSpeciale = new ControleurCaseKomodo(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case LIANES:
                controlActiverCaseSpeciale = new ControleurCaseLianes(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case NOURRITURE:
                controlActiverCaseSpeciale = new ControleurCaseNourriture(this, boundary);
                
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case PIERRE:
                controlActiverCaseSpeciale = new ControleurCasePierre(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
               finActionCase();
                break;
            case SECRET:
                controlActiverCaseSpeciale = new ControleurCaseSecret(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            default:
                System.out.println("Case normale");
                finActionCase();
                return;
        }
        //controlActiverCaseSpeciale.action(pirateCourant);
    }
    
    public void finActionCase() {
    	
        
        if (!jeuPirate.verifierFin()){
        	Pirate pirateCourant = jeuPirate.getPirates()[numeroPirate];
        	if(pirateCourant.getEtat() == Etat.ESTPRISON) {
        		finDeplacer();
        	}
            numeroPirate = (numeroPirate + 1)%2;
            debutTour();
        }else{
            boundary.finPartie(this);
        }
    }
    
    
    public int getLastPosition(){
        return jeuPirate.getPirates()[numeroPirate].getLastPosition();
    }
    
    private int gagnant() {
        if(jeuPirate.getPirates()[1].getLife()==0 || jeuPirate.getPirates()[0].getPosition()==jeuPirate.getPlateau().getTAILLETABLEAU()-1){
            //Pirate 1 mort ou Pirate 0 arrivé à la fin
            return 0;
        }
        else if (jeuPirate.getPirates()[0].getLife()==0 || jeuPirate.getPirates()[1].getPosition()==jeuPirate.getPlateau().getTAILLETABLEAU()-1){
            //Pirate 0 mort ou Pirate 1 arrivé à la fin
            return 1;
        }
        else{
            //Les deux pirates sont morts
            return -1;
        }
    }
    
    @Override
    public int getJoueurCourant() {
        return numeroPirate;
    }

    @Override
    public int getResultats() {
        return gagnant();
    }
    
    @Override
    public String getEffetcase(int num) {
        return jeuPirate.getPlateau().donnerCase(num).toString();
    }
    
    @Override
    public String getNomJoueur(int num) {
        return jeuPirate.getPirates()[num].getNom();
    }
}