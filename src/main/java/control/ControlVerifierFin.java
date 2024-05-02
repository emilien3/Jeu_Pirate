/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import model.Pirate;
import model.Plateau;

/**
 *
 * @author Ninon
 */
public class ControlVerifierFin implements IVerifierFin {

    private Pirate[] pirates;
    private Plateau plateau;

    public ControlVerifierFin(Pirate[] pirates,Plateau plateau) {
        this.pirates = pirates;
        this.plateau = plateau;
    }
    
    @Override
    public boolean estFinis(){
        boolean pirateMort = pirates[0].getLife()<= 0 || pirates[1].getLife() <= 0;
        boolean pirateArrive = pirates[0].getPosition() == plateau.getTAILLETABLEAU()-1 || pirates[1].getPosition() == plateau.getTAILLETABLEAU()-1;
        return pirateMort || pirateArrive;
    }    
}
