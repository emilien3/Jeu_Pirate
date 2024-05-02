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
        this.jeuPirate = new JeuPirate();
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
            jouerTour(jeuPirate.getPirates()[tour%2]);
            termine = controlVeriferFin.estFinis();
            tour ++;
            System.out.println("Apres le tour numero "+tour%2+":\n\tle pirate 1 est a la position "+jeuPirate.getPirates()[0].getPosition()+"\n\tet le pirate 2 est a la position "+jeuPirate.getPirates()[1].getPosition()+".");
            System.out.println("\n\n");
        }
        gagnant();
    }
    
    public void jouerTour(Pirate pirate){
        int[] des = lancerDe();
        jeuPirate.setDes(des);
        avancerJoueur(des,pirate);
        Class<? extends Cases> caseClass = jeuPirate.getPlateau().donnerCase(pirate.getPosition()).getClass();
        controlActiverCase.action(caseClass);
    }
    
    public void avancerJoueur(int[] des,Pirate pirate){
        controlDeplacer.avancerJoueur(des,pirate);
    }
    
    public void reculerJoueur(){
        
    }
    
    public void perdrePointDeVie(){
        
    }
    
    public void gagnerPointDeVie(){
        
    }
    
    public void setChangement(){
        
    }
    
    public void setEtat(){
        
    }

    private void gagnant() {
        if(jeuPirate.getPirates()[0].getLife()==0 || jeuPirate.getPirates()[1].getPosition()==jeuPirate.getPlateau().getTAILLETABLEAU()-1){
            System.out.println("Le gagnat est le pirate 2");
        }
        else{
            System.out.println("Le gagnat est le pirate 1");
        }
    }
    
}
