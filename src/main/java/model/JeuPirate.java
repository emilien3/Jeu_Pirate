/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ninon
 */
public class JeuPirate {

    private Plateau plateau;
    private Pirate pirates[];
    private int[] des;

    public JeuPirate() {
        this.plateau = new Plateau();
        this.pirates = new Pirate[2];
        this.pirates[0] = new Pirate("Jack Le Borgne");
        this.pirates[1] = new Pirate("Bill Jambe De Bois");
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Pirate[] getPirates() {
        return pirates;
    }

    public int[] getDes() {
        return des;
    }
    
    public void setDes(int[] des){
        this.des = des;
    }
    
    public boolean verifierFin(){
        boolean pirateMort = pirates[0].getLife()<= 0 || pirates[1].getLife() <= 0;
        boolean pirateArrive = pirates[0].getPosition() == plateau.getTAILLETABLEAU()-1 || pirates[1].getPosition() == plateau.getTAILLETABLEAU()-1;
        return pirateMort || pirateArrive;
    }
}
