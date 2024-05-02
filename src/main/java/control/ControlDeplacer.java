/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Pirate;

/**
 *
 * @author Ninon
 */
public class ControlDeplacer implements IDeplacerPirate{

    public void avancerJoueur(int[] des,Pirate pirate) {
        int avancement = des[0] + des[1] + pirate.getChangement();
        int newPosition = pirate.getPosition() + avancement ;
        int tailleMax = pirate.getJeuPirate().getPlateau().getTAILLETABLEAU() - 1;
        if (newPosition > tailleMax ) {
            int depasser = newPosition - tailleMax;
            newPosition = tailleMax - depasser;
        }
        pirate.setPosition(newPosition);
        pirate.setChangement(0);
    }
}
