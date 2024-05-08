/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ninon
 */
public class Pirate {
    private int life, position, changement, lastPosition;
    private final int MAX_LIFE = 5;
    private Etat etat;
	
    public Pirate() {
        this.life = MAX_LIFE;
        this.position = 0;
        this.changement = 0;
        this.etat = Etat.ESTVIVANT;
    }
    
    public int getChangement() {
        return changement;
    }

    public void setChangement(int changement) {
        this.changement = changement;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    
    public int getLastPosition() {
        return lastPosition;
    }
    
    public void setLastPosition(int position) {
        this.lastPosition = position;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    
    
  
}
