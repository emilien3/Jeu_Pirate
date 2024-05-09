/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.IChangement;
import control.IChangerEtat;
import control.IDeplacerPirate;
import control.IInfoPartie;
import control.ILancerDe;
import control.IModifierVie;
import java.util.Scanner;

/**
 *
 * @author Ninon
 */
public class BoundaryConsole implements IBoundary {
    private int courant;
    private String[] noms = new String[2];
    

    @Override
    public void debutTour(IInfoPartie controlInfoPartie) {
        this.noms[0] = controlInfoPartie.getNomJoueur(0);
        this.noms[1] = controlInfoPartie.getNomJoueur(1);
        courant = controlInfoPartie.getJoueurCourant();
        System.out.println("\n-----\nAu tour du pirate " + noms[courant]);
    }
    
    @Override
    public void lancerDe(ILancerDe controlLancerDe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur Entree pour lancer les des...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
        int[] des = controlLancerDe.getDes();
        System.out.println("Les des sont : "+des[0]+", "+des[1]);
        controlLancerDe.finLancer();
    }
    
    @Override
    public void deplacer(IDeplacerPirate controlDeplacer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur Entree pour deplacer le pirate...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
        int nouvellePosition = controlDeplacer.getArrivee();
        System.out.println("Le pirate "+ noms[courant] + " se deplace sur la case " + nouvellePosition + " : " + controlDeplacer.getEffetCase(nouvellePosition));
        controlDeplacer.finDeplacement();
    }
    @Override
    public void deplacerAuto(IDeplacerPirate controlDeplacer) {
        int nouvellePosition = controlDeplacer.getArrivee();
        System.out.println("Le pirate "+ noms[courant] + " va sur la case " + nouvellePosition);
        controlDeplacer.finDeplacement();
    }

    @Override
    public void changementProchainTour(IChangement control) {
        System.out.println("Au prochain tour, le pirate " + noms[courant] + " aura un changement de " + control.getChangement() + " sur son prochain lancer.");
        control.finChangement();
    }

    @Override
    public void changerEtat(IChangerEtat control) {
        System.out.println("Le pirate " + noms[courant] +" " + control.getEtat());
        control.finChangerEtat();
    }

    @Override
    public void modifierVie(IModifierVie control) {
        System.out.println("Le pirate " + noms[courant] + " a " + control.getVie() + " points de vie.");
        control.finModifVie();
    }

    @Override
    public void finPartie(IInfoPartie controlInfoPartie) {
        System.out.println("La partie est terminee !");
        switch (controlInfoPartie.getResultats()) {
            case 0:
                System.out.println("Le pirate " + noms[0] + " a gagne. Felicitations !");
                break;
             case 1:
                System.out.println("Le pirate " + noms[1] + " a gagne. Felicitations !");
                break;
             case -1:
                System.out.println("Les deux pirates sont morts... RIP");
                break;
            default:
                throw new AssertionError();
        }
    }
}
