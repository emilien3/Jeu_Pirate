/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laura
 */
public class Cases {
    private int position; // Position de la case sur le plateau

    public Cases(int position) {
        this.position = position;
    }

    // Getter pour la position
    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Case normale";
    }
    
    
}
