/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
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
    public void initDialog(FrameTestToDelete frame) {
        this.frame = frame;
        //frame.setDialog(this);
        //initialiser les cases, les pirates, et les des
        frame.getInfosJoueurBill().setPV(5);
        frame.getInfosJoueurJack().setPV(5);
    }

    @Override
    public void changerJoueur() {
        int joueurCourant = adaptateur.getPirateCourant();
        boolean turn = joueurCourant == 0;
        //TODO : changer les panels de joueurs en fonction du joueur courant
        //joueurCourant 0 : Bill, 1 : Jack
        frame.getInfosJoueurBill().setTurn(turn);
        frame.getInfosJoueurJack().setTurn(!turn);
    }

    @Override
    public void enableLancerDe() {
        //TODO : enable bouton lancer de des
        frame.getDiceCoursePanel().getjButtonThrow().setEnabled(true);
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
        boolean turn = joueurCourant == 0;
        //TODO : on permet à l'utilisateur de déplacer son pion (pion numPirate)
        frame.getjPlateau().getJetonBill().setMovable(turn);
        frame.getjPlateau().getJetonJack().setMovable(!turn);
        //TODO : on assombrit toutes les cases sauf celle sur laquelle il doit aller (numCase)
        List<PanelCase> cases = frame.getjPlateau().getCases();
        IntStream.range(0, cases.size())
                .filter(i -> i != arrivee)
                .forEach(i -> cases.get(i).caseSombre());
    }

    public void eventDeplacement(int arrivee) {
        //L'utilisateur a déplacé son pion depuis caseDepart jusqu'à caseArrivee
        JPion currPawn = adaptateur.getPirateCourant() == 0 ? frame.getjPlateau().getJetonBill() : frame.getjPlateau().getJetonJack();
        List<PanelCase> cases = frame.getjPlateau().getCases();
        Point currLocation = currPawn.getLocation();
        
        if (arrivee == adaptateur.getProchaineCase()){
            //Case valide
            //TODO : animation case valide (caseArrive)
            cases.get(arrivee).caseValide();
            //TODO : On remet les cases normale (pas assombries)
            
            //TODO : on desactive le deplacement du pion numPirate
            currPawn.setMovable(false);
        }else{
            //Case invalide
            //TODO : animation case invalide (caseArrivee)
            cases.get(arrivee).caseInvalide();
            //On renvoie le pirate sur la case d'ou il venait
            changerPositionPirate(adaptateur.getDerniereCase());
            currPawn.setLocation(currLocation);
        }
    }

    @Override
    public void changerPositionPirate(int numCase) {
        //TODO : Automatique -> deplacer jeton numPirate jusqu'a numCase
        //On reprend le pion a bouger
        JPion currPawn = adaptateur.getPirateCourant() == 0 ? frame.getjPlateau().getJetonBill() : frame.getjPlateau().getJetonJack();
        //On recupere la taille de la case
        Dimension caseSize = frame.getjPlateau().getCase(numCase).getSize(),
                pawnSize = currPawn.getSize();
        //On genere une coordonnee aleatoire pour eviter la superposition des panels Pion
        Random random = new Random();
        int randomX = random.nextInt(caseSize.width - pawnSize.width);
        int randomY = random.nextInt(caseSize.height - pawnSize.height);
        Point randomLocation = new Point(randomX, randomY);
        //On recupere la coordonnee de la case
        Point caseLocation = frame.getjPlateau().getCase(numCase).getLocationOnScreen();
        randomLocation.translate(caseLocation.x, caseLocation.y);
        //On deplace le jeton
        currPawn.setLocation(randomLocation);
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
        int joueurCourant = adaptateur.getPirateCourant();
        int vie = adaptateur.getPointsVie();
        //TODO : mettre vie de numPirate à changement
        InfosJoueur currPlayer = joueurCourant == 0 ? frame.getInfosJoueurJack() : frame.getInfosJoueurBill();
        currPlayer.setPV(vie);
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
