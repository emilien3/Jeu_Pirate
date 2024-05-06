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
public class ControlLancerDe implements ILancerDe{
    private De dice;

    public ControlLancerDe() {
        dice = new De();
    }
    
    public int[] rollDice(int nDices) {
        int[] rolls = new int[nDices];
                
        for (int i = 0; i < nDices; i++) {
            rolls[i] = dice.roll();
        }
        return rolls;
    }
    
}
