/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;


/**
 *
 * @author Ninon
 */
public class De {

    private int value;
    private Random rdm;
    
    public De() {
        rdm = new Random();
    }

    public int roll() {
        value = rdm.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }
}
