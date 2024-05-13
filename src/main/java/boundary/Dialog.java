/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import model.Etat;
/**
 *
 * @author Ninon
 */
public class Dialog implements IPirates {
    private IAdaptateurFonctionnel adaptateur;
    private FrameTestToDelete frame;
    
    public Dialog(IAdaptateurFonctionnel adaptateur){
        this.adaptateur = adaptateur;
    }

    @Override
    public void initDialog() {
        //this.frame = new Frame2();
        //frame.setDialog(this);
        //initialiser les cases, les pirates, et les des
    }

    @Override
    public void changerJoueur() {
        int joueurCourant = adaptateur.getPirateCourant();
        //TODO : changer les panels de joueurs en fonction du joueur courant
    }

    @Override
    public void enableLancerDe() {
        //TODO : enable bouton lancer de des
    }

    public void eventLancerDe() {
        //L'utilisateur à appuyé sur lancer les des
        int[] des = adaptateur.getResultatsDes();
        //TODO : lancer l'animation des des puis afficher le resultat
        adaptateur.finLancerDes();
    }

    @Override
    public void enableDeplacement() {
        int joueurCourant = adaptateur.getPirateCourant();
        int arrivee = adaptateur.getProchaineCase();
        //TODO : on permet à l'utilisateur de déplacer son pion (pion numPirate)
        //TODO : on assombrit toutes les cases sauf celle sur laquelle il doit aller (numCase)
    }

    public void eventDeplacement(int arrivee) {
        //L'utilisateur a déplacé son pion depuis caseDepart jusqu'à caseArrivee
        if (arrivee==adaptateur.getProchaineCase()){
            //Case valide
            //TODO : animation case valide (caseArrive)
            //TODO : On remet les cases normale (pas assombries)
            //TODO : on desactive le deplacement du pion numPirate
        }else{
            //Case invalide
            //TODO : animation case invalide (caseArrivee)
            //On renvoie le pirate sur la case d'ou il venait
            changerPositionPirate(adaptateur.getDerniereCase());
        }
    }

    @Override
    public void changerPositionPirate(int numCase) {
        //TODO : Automatique -> deplacer jeton numPirate jusqu'a numCase
    }

    @Override
    public void changerChangement() {
        int changement = adaptateur.getChangement();
        //TODO : mettre changement de numPirate à changement
    }

    @Override
    public void changerEtat() {
        Etat etat = adaptateur.getEtat();
        //TODO : mettre etat de numPirate à changement
    }

    @Override
    public void changerVie() {
        int vie = adaptateur.getPointsVie();
        //TODO : mettre vie de numPirate à changement
    }

    @Override
    public void finDePartie() {
        //TODO : animation fin de partie
        switch (adaptateur.getResultat()) {
            case 0:
                //Pirate 0 a gagné
                //TODO : animation fin, victoire pirate 0
                break;
            case 1:
                //Pirate 1 a gagné
                //TODO : animation fin, victoire pirate 1
                break;
            default:
                //Les deux sont morts donc égalité
                //TODO : animation fin, defaite des deux pirates
                break;
        }
    }
    
}
