/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import java.util.function.Function;
import java.util.stream.Stream;
import model.De;
import model.Pirate;

/**
 *
 * @author Ninon
 */
public class ControlDeplacer implements IDeplacerPirate, ILancerDe{
    private IBoundary boundary;
    private ControlJeuPirate controlJeuPirate;
    private int TAILLE_MAX;
    private De[] de;
    private Pirate[] pirates;
    private int depart, deplacement, joueurCourant;
    
    public ControlDeplacer(ControlJeuPirate controlJeuPirate, IBoundary boundary, int taille, De[] de, Pirate[] pirates){
        this.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
        this.TAILLE_MAX = taille - 1;
        this.pirates = pirates;
        this.de = de;
    }
    

    public void deplacer(int i) {
        //On déplace le pirate i (fonction appelée depuis controlJeuPirate)
        this.joueurCourant = i;
        this.depart = pirates[joueurCourant].getPosition();
        lancerDes();
    }
    

    private void lancerDes(){
        //On lance tous les dés
        for (De d : de){
            d.roll();
        }
        this.deplacement = valeurDeplacement(de);
        boundary.lancerDe(this);

    }
    
    private int valeurDeplacement(De[] des){
        //Pour recupérer la somme des valeurs des dés
        Function<De[], Integer> somme = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).reduce(0, (a, b) -> a+b);
        return somme.apply(des);
    }
    
    @Override
    public int[] getDes() {
        //Est appelée quand l'affichage a besoin du résultat des dés
        Function<De[], int[]> getValeurs = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).toArray();
        return getValeurs.apply(de);
    }
    

    @Override
    public void finLancer() {
        //Est appelée quand l'affichage a fini d'afficher le lancer de dés -> On débute le déplacement
        effectuerDeplacement();
    }
    
    
    private void effectuerDeplacement(){
        //On modifie les données pour effectuer le déplacement
        int avancement = deplacement + pirates[joueurCourant].getChangement();
        int newPosition = depart + avancement ;
        if (newPosition > TAILLE_MAX ) {
            //Si la valeur des dés amène sur une case supérieure à la dernière case, on recule du nombre de cases qu'on a dépassé
            int depasser = newPosition - TAILLE_MAX;
            newPosition = TAILLE_MAX - depasser;
        }else if (newPosition < 0 ) {
            newPosition = 0;
        }
        pirates[joueurCourant].setLastPosition(depart);
        pirates[joueurCourant].setPosition(newPosition);
        pirates[joueurCourant].setChangement(0);
        boundary.deplacer(this);
    }
    
    @Override
    public String getEffetCase(int num) {
        //Est appelée quand l'affichage a besoin de l'effet de la case
        return controlJeuPirate.getEffetcase(num);
    }

    @Override
    public int getArrivee() {
        //Est appelée quand l'affichage a besoin de la case d'arrivée
        return pirates[joueurCourant].getPosition();
    }
    
    @Override
    public int getDepart(){
        //Est appelée quand l'affichage a besoin de la case de départ
        return depart;
    }

    @Override
    public void finDeplacement() {
        //Est appelée quand l'affichage a fini d'afficher le déplacement
        controlJeuPirate.finDeplacer();
    }
    
}
