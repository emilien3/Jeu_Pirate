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
    public void debutPartie(IInfoPartie control) {
        System.out.println("Début de la partie");
    }

    @Override
    public void debutTour(IInfoPartie controlInfoPartie) {
        //On initialise les noms des pirates pour les prochains affichages
        this.noms[0] = controlInfoPartie.getNomJoueur(0);
        this.noms[1] = controlInfoPartie.getNomJoueur(1);
        System.out.println("\n-----\n");
        //On affiche la vie des 2 joueurs au début de chaque tour
        System.out.println("Vie de " + noms[0] + " : " +  controlInfoPartie.getVieJoueur(0));
        System.out.println("Vie de " + noms[1] +" : " +  controlInfoPartie.getVieJoueur(1));
        //On affiche le joueur courant
        courant = controlInfoPartie.getJoueurCourant();
        System.out.println("Au tour du pirate " + noms[courant]);
    }
    
    @Override
    public void lancerDe(ILancerDe controlLancerDe) {
        //On permet à l'utilisateur de "lancer" les dés
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur Entree pour lancer les des...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
        //On affiche le résultat des dés
        int[] des = controlLancerDe.getDes();
        System.out.println("Les des sont : "+des[0]+", "+des[1]);
        //On rend la main au controleur
        controlLancerDe.finLancer();
    }
    
    @Override
    public void deplacer(IDeplacerPirate controlDeplacer){
        //Ici c'est un déplacement dû au lancer de dés, c'est l'utilisateur qui "fait" le déplacement
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur Entree pour deplacer le pirate...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
        //On affiche le déplacement
        int nouvellePosition = controlDeplacer.getArrivee();
        System.out.println("Le pirate "+ noms[courant] + " se deplace sur la case " + nouvellePosition + " : " + controlDeplacer.getEffetCase(nouvellePosition));
        //On rend la main au controleur
        controlDeplacer.finDeplacement();
    }
    @Override
    public void deplacerAuto(IDeplacerPirate controlDeplacer) {
        //Ici c'est un déplacement causé par l'effet d'une case
        //On affiche le déplacement
        int nouvellePosition = controlDeplacer.getArrivee();
        System.out.println("Le pirate "+ noms[courant] + " va sur la case " + nouvellePosition);
        //On rend la main au controleur
        controlDeplacer.finDeplacement();
    }

    @Override
    public void changementProchainTour(IChangement control) {
        //On affiche de changement du prochain tour
        System.out.println("Au prochain tour, le pirate " + noms[courant] + " aura un changement de " + control.getChangement() + " sur son prochain lancer.");
        //On rend la main au controleur
        control.finChangement();
    }

    @Override
    public void changerEtat(IChangerEtat control) {
        //On affiche le nouvel état du pirate
        System.out.println("Le pirate " + noms[courant] +" " + control.getEtat());
        //On rend la main au controleur
        control.finChangerEtat();
    }

    @Override
    public void modifierVie(IModifierVie control) {
        //On affiche la perte ou le gain de points de vie
        int changementVie = control.getVie();
        String changement = "gagne";
        if (changementVie<0){
            changement = "perd";
            changementVie = Math.abs(changementVie);
        }
        System.out.println("Le pirate " + noms[courant] + " "+ changement + " " + changementVie + " points de vie.");
        //On rend la main au controleur
        control.finModifVie();
    }

    @Override
    public void finPartie(IInfoPartie controlInfoPartie) {
        //On affiche les résultats
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
