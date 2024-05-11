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
        System.out.println("Vie de " + jeuPirate.getPirates()[0].getNom() + " : " +  jeuPirate.getPirates()[0].getLife());
        System.out.println("Vie de " + jeuPirate.getPirates()[1].getNom() +" : " +  jeuPirate.getPirates()[1].getLife());
        boundary.debutTour(this);
        controlDeplacer.deplacer(numeroPirate);
    }
    
    public void finDeplacer(){
        Pirate pirateCourant = jeuPirate.getPirates()[numeroPirate];
        CaseEnum caseCourante = jeuPirate.getPlateau().donnerCase(pirateCourant.getPosition());
        switch (caseCourante) {
            case BOUE:
                controlActiverCaseSpeciale = new ControleurCaseBoue(this, boundary);
                controlActiverCaseSpeciale.action(jeuPirate.getPirates()[numeroPirate]);
                break;
            case DEBUT:
                //controlActiverCaseSpeciale = new ControleurRetourCaseDebut(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
                break;
            case FALAISE:
                System.out.println("falaise");
                controlActiverCaseSpeciale = new ControleurCaseFalaise(this, boundary);
                controlActiverCaseSpeciale.action(pirateCourant);
                break;
            case KOMODO:
                //controlActiverCaseSpeciale = new ControleurCaseKomodo(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
                break;
            case LIANES:
                //controlActiverCaseSpeciale = new ControleurCaseLianes(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
                break;
            case NOURRITURE:
                //controlActiverCaseSpeciale = new ControleurCaseNourriture(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
                break;
            case PIERRE:
                //controlActiverCaseSpeciale = new ControleurCasePierre(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
                break;
            case SECRET:
                //controlActiverCaseSpeciale = new ControleurCaseSecret(this, boundary);
                System.out.println("Pas implementee");
                finActionCase();
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
    
    /*
    public int[] lancerDe(){
        valider();
        int[] des = controlLancerDe.rollDices(2);
        System.out.println("Les des sont :"+des[0]+","+des[1]);
        return des;
    }
    
    
    public void jouer(){
        int tour = 0;
        boolean termine = false;
        while(!termine) {
            System.out.println("Au tour du pirate numero "+(tour%2+1));
            jouerTour(jeuPirate.getPirates()[tour%2]);
            termine = verifierFin(pirates, plateau);
            tour ++;
            afficherEtat();
            System.out.println("\n\n");
        }
        gagnant();
    }
    
    private void afficherEtat(){
        Pirate[] pirates = jeuPirate.getPirates();
        System.out.println("Le pirate numero 1 "+pirates[0].getEtat().toString()+" a "+pirates[0].getLife()+" point de vie se trouve sur la case numero "+pirates[0].getPosition()+" et son prochain lancer auras un changement de "+pirates[0].getChangement()+".");
        System.out.println("Le pirate numero 2 "+pirates[1].getEtat().toString()+" a "+pirates[1].getLife()+" point de vie se trouve sur la case numero "+pirates[1].getPosition()+" et son prochain lancer auras un changement de "+pirates[1].getChangement()+".");

    }
    
    public void jouerTour(Pirate pirate){
        
        switch (pirate.getEtat()) {
            case ESTVIVANT -> {
                int[] des = lancerDe();
                jeuPirate.setDes(des);
                avancerJoueur(des,pirate);
                Class<? extends Cases> caseClass = jeuPirate.getPlateau().donnerCase(pirate.getPosition()).getClass();
                controlActiverCase.action(caseClass,pirate);
            }
            case ESTPOURSUIVI -> controlActiverCase.action(new CaseKomodo(0).getClass(),pirate);
            case ESTPRISON -> controlActiverCase.action(new CaseLianes(0).getClass(),pirate);
            case PASSETOUR ->  setEtat(Etat.ESTVIVANT,pirate);
        }
    }
    
    public void avancerJoueur(int[] des,Pirate pirate){
        controlDeplacer.avancerJoueur(des,pirate);
    }
    
    public void reculerJoueur(){
        
    }
    
    public void perdrePointsDeVie(int perte,Pirate pirate){
        int pointDeVieActuel = pirate.getLife();
        if (pointDeVieActuel > perte) {
            pirate.setLife(pointDeVieActuel - perte);
        } else {
            pirate.setLife(0);
        }
    }
    
    public void gagnerPointsDeVie(int gain,Pirate pirate){
        int pointDeVieActuel = pirate.getLife();
        if (pointDeVieActuel + gain < 5) {
            pirate.setLife(pointDeVieActuel + gain);
        }
        else{
            pirate.setLife(5);
        }
    }
    
    public void setChangement(int chang,Pirate pirate){
        pirate.setChangement(chang);
    }
    
    public void setEtat(Etat etat,Pirate pirate){
        pirate.setEtat(etat);
    }

    public void deplacerVersPositionPrecedente(Pirate pirate) {
        int avacement = jeuPirate.getDes()[0] + jeuPirate.getDes()[1];
        controlDeplacer.reculerJoueur(avacement, pirate);
    }
    
    public void retourDepart(Pirate pirate){
        pirate.setChangement(0);
        pirate.setEtat(Etat.ESTVIVANT);
        pirate.setLife(5);
        controlDeplacer.retourDepart(pirate);
    }
    */

    
    
}
