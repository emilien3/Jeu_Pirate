/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import model.*;
import static model.CaseEnum.BOUE;


/**
 *
 * @author Ninon
 */
public class ControlJeuPirate implements IInfoPartie, IChangerEtat{
    private IBoundary boundary;
    private ControlActiverCaseSpeciale controlActiverCaseSpeciale;
    private ControlDeplacer controlDeplacer;
    private JeuPirate jeuPirate;
    private int numeroPirate;
    private De[] des;

    public ControlJeuPirate(IBoundary boundary, int nbDes) {
        this.boundary = boundary;
        this.jeuPirate = new JeuPirate();
        this.des = new De[nbDes];
        for (int i = 0; i<nbDes; i++) {
            des[i] = new De();
        }
        this.controlDeplacer = new ControlDeplacer(this, boundary, jeuPirate.getPlateau().getTAILLETABLEAU(), des, jeuPirate.getPirates());
        this.numeroPirate = 1;
    }
    
    public void debutTour(){
        this.numeroPirate = (numeroPirate + 1)%2;;
        //On affiche le début d'un nouveau tour
        boundary.debutTour(this);
        //On commence le déplacement
        System.out.println(jeuPirate.getPirates()[numeroPirate].getNom() + " " + jeuPirate.getPirates()[numeroPirate].getEtat());
        controlDeplacer.deplacer(numeroPirate);
    }
    
    public Pirate[] getPirates(){
        return jeuPirate.getPirates();
    }
   
    
    @Override
    public String getEffetcase(int num) {
        //Est appelée quand l'affichage a besoin de l'effet de la case num
        return jeuPirate.getPlateau().donnerCase(num).toString();
    }
    
    @Override
    public String getNomJoueur(int num) {
        //Est appelée quand l'affichage a besoin du nom du pirate num
        return jeuPirate.getPirates()[num].getNom();
    }
    
    @Override
    public int getVieJoueur(int num) {
        //Est appelée quand l'affichage a besoin de la vie du pirate num
        return jeuPirate.getPirates()[num].getLife();
    }
    
    
    public void finDeplacer(){
        Pirate pirateCourant = jeuPirate.getPirates()[numeroPirate];
        CaseEnum caseCourante = jeuPirate.getPlateau().donnerCase(pirateCourant.getPosition());
        if(pirateCourant.getEtat()==Etat.PASSETOUR) {
            pirateCourant.setEtat(Etat.ESTVIVANT);
            boundary.changerEtat(this);
            return;
        }
        switch (caseCourante) {
            case BOUE:
                controlActiverCaseSpeciale = new ControleurCaseBoue(this, boundary);
                break;
            case DEBUT:
                controlActiverCaseSpeciale = new ControleurRetourCaseDebut(this, boundary);
                break;
            case FALAISE:
                controlActiverCaseSpeciale = new ControleurCaseFalaise(this, boundary);
                break;
            case KOMODO:
                controlActiverCaseSpeciale = new ControleurCaseKomodo(this, boundary, des);
                break;
            case LIANES:
                controlActiverCaseSpeciale = new ControleurCaseLianes(this, boundary, des);
                break;
            case NOURRITURE:
                controlActiverCaseSpeciale = new ControleurCaseNourriture(this, boundary);
                break;
            case PIERRE:
                controlActiverCaseSpeciale = new ControleurCasePierre(this, boundary);
                break;
            case SECRET:
                controlActiverCaseSpeciale = new ControleurCaseSecret(this, boundary);
                break;
            default:
                finActionCase();
                return;
        }
        controlActiverCaseSpeciale.action(pirateCourant);
    }
    
    public void finActionCase() {
        if (!jeuPirate.verifierFin()){
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
    public Etat getEtat() {
        return jeuPirate.getPirates()[numeroPirate].getEtat();
    }

    @Override
    public void finChangerEtat() {
        finActionCase();
    }
    
    @Override
    public int getJoueurCourant() {
        return numeroPirate;
    }

    @Override
    public int getResultats() {
        return gagnant();

    }
    
}