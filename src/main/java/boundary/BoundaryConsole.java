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
    

    @Override
    public void debutTour(IInfoPartie controlInfoPartie) {
        courant = controlInfoPartie.getJoueurCourant();
        System.out.println("Au tour du pirate " + courant);
    }
    
    @Override
    public void lancerDe(ILancerDe controlLancerDe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur une touche pour lancer les des...");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
        
        int[] des = controlLancerDe.getDes();
        System.out.println("Les dés sont : "+des[0]+", "+des[1]);
        controlLancerDe.finLancer();
    }

    @Override
    public void deplacer(IDeplacerPirate controlDeplacer) {
        int nouvellePosition = controlDeplacer.getNouvellePosition();
        System.out.println("Le pirate "+ courant +" se déplace jusqu'à la case " + nouvellePosition + " : " + controlDeplacer.getEffetCase(nouvellePosition));
        
        controlDeplacer.finDeplacement();
    }

    @Override
    public void changementProchainTour(IChangement control) {
        System.out.println("Au prochain tour, le pirate " + courant + " aura un changement de " + control.getChangement() + " sur son prochain lancer.");
        control.finChangement();
    }

    @Override
    public void changerEtat(IChangerEtat control) {
        System.out.println("Le pirate " + courant +" " + control.getEtat());
        control.finChangerEtat();
    }

    @Override
    public void modifierVie(IModifierVie control) {
        System.out.println("Le pirate " + courant + " a " + control.getVie() + " points de vie.");
        control.finModifVie();
    }

    @Override
    public void fin(IInfoPartie controlInfoPartie) {
        System.out.println("La partie est terminée !");
        switch (controlInfoPartie.getResultats()) {
            case 0:
                System.out.println("Le pirate 0 a gagné. Félicitations !");
                break;
             case 1:
                System.out.println("Le pirate 1 a gagné. Félicitations !");
                break;
             case -1:
                System.out.println("Les deux pirates sont morts... RIP");
                break;
            default:
                throw new AssertionError();
        }
    }

    
}
