/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laura
 */
public class CasePierre extends Cases {
	private boolean prochainTourPasse;

    public CasePierre(int position) {
        super(position);
        
        
    }

    @Override
    public String toString() {
        return "Case tomber de pierre";
    }
}
