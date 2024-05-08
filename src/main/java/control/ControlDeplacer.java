/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.IBoundary;
import java.util.function.Function;
import java.util.stream.IntStream;
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
    private int deplacement;
    int courant;
    
    public ControlDeplacer(ControlJeuPirate controlJeuPirate, IBoundary boundary, int taille, De[] de, Pirate[] pirates){
        this.controlJeuPirate = controlJeuPirate;
        this.boundary = boundary;
        this.TAILLE_MAX = taille;
        this.pirates = pirates;
        this.de = de;
    }
    
    public void deplacer(int i) {
        this.courant = i;
        lancerDes();
    }
    
    public void lancerDes(){
        for (De d : de){
            d.roll();
        }
        this.deplacement = valeurDeplacement(de);
        boundary.lancerDe(this);
    }
    
    private int valeurDeplacement(De[] des){
        Function<De[], Integer> somme = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).reduce(0, (a, b) -> a+b);
        return somme.apply(des);
    }
    
    @Override
    public int[] getDes() {
        Function<De[], int[]> getValeurs = d -> Stream.of(d).mapToInt(d1 -> d1.getValue()).toArray();
        return getValeurs.apply(de);
    }
    

    @Override
    public void finLancer() {
        effectuerDeplacement();
    }
    
    private void effectuerDeplacement(){
        int avancement = deplacement + pirates[courant].getChangement();
        int newPosition = pirates[courant].getPosition() + avancement ;
        if (newPosition > TAILLE_MAX ) {
            int depasser = newPosition - TAILLE_MAX;
            newPosition = TAILLE_MAX - depasser;
        }else if (newPosition < 0 ) {
            newPosition = 0;
        }
        pirates[courant].setLastPosition(pirates[courant].getPosition());
        pirates[courant].setPosition(newPosition);
        pirates[courant].setChangement(0);
        boundary.deplacer(this);
    }
    
    @Override
    public String getEffetCase(int num) {
        return controlJeuPirate.getEffetcase(num);
    }

    @Override
    public int getNouvellePosition() {
        return pirates[courant].getPosition();
    }

    @Override
    public void finDeplacement() {
        controlJeuPirate.finDeplacer();
    }
    
}
