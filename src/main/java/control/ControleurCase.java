/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesJava;

/**
 *
 * @author laura
 */
public class ControleurCase {
    public void action(Cases caseNormale,ControlJeuPirate controlJeuPirate) {
        
        System.out.println("Le joueur atterrit sur une case normale.");
        controlJeuPirate.finTourJoueurActuel();
        
    }
}
