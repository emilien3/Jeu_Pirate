/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.De;

/**
 *
 * @author Ninon
 */
public class ControlLancerDe implements ILancerDe {
    private ControlJeuPirate controlJeuPirate;
    private De dice1, dice2;
	
    public ControlLancerDe() {
        dice1 = new De();
        dice2 = new De();
    }
    
    @Override
    public int[] rollDices() {
        int[] rolls = new int[2];
        rolls[0] = dice1.roll();
        rolls[1] = dice2.roll();
        return rolls;
    }
}
