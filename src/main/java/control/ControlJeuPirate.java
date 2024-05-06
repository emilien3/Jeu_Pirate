/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.BoundaryConsole;
import boundary.IBoundary;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Ninon
 */
public class ControlJeuPirate {
    private IBoundary boundary;
    private ControlActiverCase controlActiverCase;
    private ControlDeplacer controlDeplacer;
    private ControlLancerDe controlLancerDe;
    private ControlVerifierFin controlVeriferFin;
    private JeuPirate jeuPirate;

    public ControlJeuPirate() {
        this.boundary = new BoundaryConsole();
        this.controlActiverCase = new ControlActiverCase(this);
        this.controlDeplacer = new ControlDeplacer();
        this.controlLancerDe = new ControlLancerDe();
        this.jeuPirate = 
                new JeuPirate();
        this.controlVeriferFin = new ControlVerifierFin(jeuPirate.getPirates(),jeuPirate.getPlateau());
    }
    
    private void valider() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur une touche pour lancer les des...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
    }
    
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
            termine = controlVeriferFin.estFinis();
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

    private void gagnant() {
        if(jeuPirate.getPirates()[0].getLife()==0 || jeuPirate.getPirates()[1].getPosition()==jeuPirate.getPlateau().getTAILLETABLEAU()-1){
            System.out.println("Le gagnant est le pirate 2");
        }
        else{
            System.out.println("Le gagnant est le pirate 1");
        }
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
    
}
