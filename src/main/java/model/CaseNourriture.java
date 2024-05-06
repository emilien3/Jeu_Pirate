/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laura
 */
public class CaseNourriture extends Cases {
    
    public static int CHANGEMENT = 2;
    public static int GAINPOINTDEVIE = 1;
    public CaseNourriture(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case nourriture";
    }
}
