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
    private Case cases[];

    public Plateau() {
        this.cases = new Case[30];
        initialiserCases();
    }
    
    private void initialiserCases(){
        //mettre les cases au bon endroit
    }
    
    public Case donnerCase(int n){
        return cases[n];
    }
    
}
