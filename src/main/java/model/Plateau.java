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
            if (i == 0 || i == 1 || i == 5 || i == 13 || i == 18 || i == 22 || i == 24 || i == 29) {
                cases[i] =  new Cases(i);
            }
            if (i == 2 || i == 10) {
                cases[i] =  new CaseKomodo(i);
            }
            if (i == 3 || i == 11 || i == 20) {
                cases[i] =  new CaseSecret(i);
            }
            if (i == 4 || i == 12 || i == 21) {
                cases[i] =  new CasePierre(i);
            }
            if (i == 6 || i == 15 || i == 27) {
                cases[i] =  new CaseBoue(i);
            }
            if (i == 7 || i == 16 || i == 19) {
                cases[i] =  new CaseFalaise(i);
            }
            if (i == 8 || i == 28 ) {
                cases[i] =  new CaseLianes(i);
            }
            if (i == 9 || i == 14 || i == 17 || i == 23 || i == 25) {
                cases[i] =  new CaseNourriture(i);
            }
            if (i == 26) {
                cases[i] =  new CaseRetourDebut(i);
            }
        }
        for (int i = 0; i < TAILLETABLEAU; i++) {
            System.out.println("La " + cases[i].toString() + " numero " + i + " est initialiser.");
        }
    }
    
    public int getTAILLETABLEAU(){
        return TAILLETABLEAU;
    }
    
    public Cases donnerCase(int n){
        return cases[n];
    }
    
}
