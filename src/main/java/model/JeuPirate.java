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
    private De des;

    public JeuPirate() {
        this.plateau = new Plateau();
        this.pirates = new Pirate[2];
        this.pirates[0] = new Pirate();
        this.pirates[1] = new Pirate();
        this.des = new De();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Pirate[] getPirates() {
        return pirates;
    }

    public De getDes() {
        return des;
    }
}
