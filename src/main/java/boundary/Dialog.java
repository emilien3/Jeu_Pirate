/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.awt.Dimension;
import java.awt.Point;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import model.CaseEnum;
import model.De;
import model.Etat;
import model.Plateau;
/**
 *
 * @author Ninon
 */
public class Dialog implements IPirates {
    private IAdaptateurFonctionnel adaptateur;
    private FrameTestToDelete frame;
    private De[] des;
    
    public Dialog(IAdaptateurFonctionnel adaptateur, FrameTestToDelete frame){
        this.adaptateur = adaptateur;
        this.frame = frame;
    }

    @Override
    public void initDialog() {
        frame.setDialog(this);
        //Initialisation des pirates
        frame.getInfosJoueurBill().setPV(5);
        frame.getInfosJoueurJack().setPV(5);
        //Initialisation des images des cases
        Map<CaseEnum, String> mapPlateau = new EnumMap<>(CaseEnum.class);
        mapPlateau.put(CaseEnum.NORMALE, "bateau.png");
        mapPlateau.put(CaseEnum.DEBUT, "ile.png");
        mapPlateau.put(CaseEnum.FALAISE, "falaise.png");
        mapPlateau.put(CaseEnum.NOURRITURE, "nourriture.png");
        mapPlateau.put(CaseEnum.PIERRE, "falaise.png");
        mapPlateau.put(CaseEnum.KOMODO, "monstre.png");
        mapPlateau.put(CaseEnum.BOUE, "ile.png");
        mapPlateau.put(CaseEnum.LIANES, "ile.png");
        mapPlateau.put(CaseEnum.SECRET, "ile.png");
        adaptateur.getTypeCase(0);
        int taillePlateau = adaptateur.getNombreCases();
        String[] imageCases = new String[taillePlateau];
        for (int i = 0; i < taillePlateau; i++) {
            imageCases[i] = mapPlateau.get(adaptateur.getTypeCase(i));
        }
        frame.getjPlateau().setImage(imageCases);
        
        //On ne peut pas bouger les pions tant que le tour n'a pas commencé
        frame.getjPlateau().getJetonBill().setMovable(false);
        frame.getjPlateau().getJetonJack().setMovable(false);
        
        
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
        frame.getDiceCoursePanel().enablejButtonThrow(true);
    }

    public void eventLancerDe() {
        //L'utilisateur à appuyé sur lancer les des
        int[] des = adaptateur.getResultatsDes();
        //TODO : lancer l'animation des des puis afficher le resultat
        frame.getDiceCoursePanel().enablejButtonThrow(false);
        frame.getDiceCoursePanel().setValuesDice(des);
        adaptateur.finLancerDes();
    }

    @Override
    public void enableDeplacement() {
        int joueurCourant = adaptateur.getPirateCourant();
        int arrivee = adaptateur.getProchaineCase();
        boolean turn = joueurCourant == 0;
        //TODO : on assombrit toutes les cases sauf celle sur laquelle il doit aller (numCase)
        frame.getjPlateau().plateauModeDeplacement(arrivee);
        //TODO : on permet à l'utilisateur de déplacer son pion (pion numPirate)
        frame.getjPlateau().getJetonBill().setMovable(turn);
        frame.getjPlateau().getJetonJack().setMovable(!turn);
    }

    public void eventDeplacement(int arrivee) {
        //L'utilisateur a déplacé son pion depuis caseDepart jusqu'à caseArrivee
        JPion currPawn = adaptateur.getPirateCourant() == 0 ? frame.getjPlateau().getJetonBill() : frame.getjPlateau().getJetonJack();
        
        if (arrivee == adaptateur.getProchaineCase()){
            System.out.println(adaptateur.getDescriptionCase(arrivee));
            //Case valide
            //TODO : animation case valide (caseArrive)
            frame.getjPlateau().getCase(arrivee).caseValide();
            //TODO : On remet les cases normale (pas assombries)
            frame.getjPlateau().plateauModeNormal();
            //TODO : on desactive le deplacement du pion numPirate
            currPawn.setMovable(false);
            adaptateur.finDeplacement();
        }else{
            //Case invalide
            //TODO : animation case invalide (caseArrivee)
            frame.getjPlateau().getCase(arrivee).caseInvalide();
            //On renvoie le pirate sur la case d'ou il venait
            currPawn.setMovable(false);
            frame.getjPlateau().replacerJeton(currPawn, adaptateur.getDerniereCase());
            enableDeplacement();
        }
    }

    @Override
    public void changerPositionPirate(int numCase) {
        //TODO : Automatique -> deplacer jeton numPirate jusqu'a numCase
        //On reprend le pion a bouger
        JPion currPawn = adaptateur.getPirateCourant() == 0 ? frame.getjPlateau().getJetonBill() : frame.getjPlateau().getJetonJack();
        currPawn.setMovable(false);
        frame.getjPlateau().replacerJeton(currPawn, numCase);
        adaptateur.finDeplacement();
    }

    @Override
    public void changerChangement() {
        int changement = adaptateur.getChangement();
        //TODO : mettre changement de numPirate à changement
        adaptateur.finChangement();
    }

    @Override
    public void changerEtat() {
        Etat etat = adaptateur.getEtat();
        //TODO : mettre etat de numPirate à changement
        PanelInfosJoueur joueur =  adaptateur.getPirateCourant() == 0 ? frame.getInfosJoueurBill() : frame.getInfosJoueurJack();
        joueur.setEtat(etat);
        adaptateur.finChangerEtat();
        
    }

    @Override
    public void changerVie() {
        int joueurCourant = adaptateur.getPirateCourant();
        int vie = adaptateur.getPointsVie();
        //TODO : mettre vie de numPirate à changement
        PanelInfosJoueur currPlayer = joueurCourant == 0 ? frame.getInfosJoueurBill() : frame.getInfosJoueurJack();
        currPlayer.setPV(currPlayer.getPV() + vie);
        adaptateur.finChangerVie();
    }

    @Override
    public void finDePartie() {
        //TODO : animation fin de partie
        switch (adaptateur.getResultat()) {
            case 0:
                //Pirate 0 a gagné
                //TODO : animation fin, victoire pirate 0
                frame.finDePartie("Bill");
                break;
            case 1:
                //Pirate 1 a gagné
                //TODO : animation fin, victoire pirate 1
                frame.finDePartie("Jack");
                break;
            default:
                //Les deux sont morts donc égalité
                //TODO : animation fin, defaite des deux pirates
                frame.finDePartie("Egalité");
                break;
        }
    }
    
}
