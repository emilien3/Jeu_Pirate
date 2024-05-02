/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ninon
 */
public class Plateau {
    private final int TAILLETABLEAU = 30;
    private Cases cases[];

    public Plateau() {
        this.cases = new Cases[TAILLETABLEAU];
        initialiserCases();
    }
    
    private void initialiserCases(){
        for (int i = 0; i < TAILLETABLEAU; i++) {
            cases[i] = new Cases(i);
        }
    }
    
    public int getTAILLETABLEAU(){
        return TAILLETABLEAU;
    }
    
    public Cases donnerCase(int n){
        return cases[n];
    }
    
}
