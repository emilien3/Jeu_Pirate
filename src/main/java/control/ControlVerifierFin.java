/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import model.JeuPirate;
import model.Pirate;

/**
 *
 * @author Ninon
 */
public class ControlVerifierFin implements IVerifierFin {

    private final int taillePlateau = 30;
    private JeuPirate jeuPirate;

    public ControlVerifierFin(JeuPirate jeuPirate) {
        this.jeuPirate = jeuPirate;
    }
    
    public boolean estFinis(){
        Pirate pirates[] = jeuPirate.getPirates();
        boolean pirateMort = pirates[0].getHp() <= 0 || pirates[1].getHp <= 0;
        boolean pirateArrive = pirates[0].getPosition == taillePlateau || pirates[1].getPosition == taillePlateau;
        return pirateMort || pirateArrive;
    }    
}
