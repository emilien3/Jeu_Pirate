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
    private ControlJeuPirate jeuPirate;
    private int TAILLE_MAX;
    
    public ControlDeplacer(int taille, ControlJeuPirate jeuPirate){
        this.TAILLE_MAX = taille;
        this.jeuPirate = jeuPirate;
    }
    
    @Override
    public void deplacer(Pirate pirate, int deplacement) {
        int avancement = deplacement + pirate.getChangement();
        int newPosition = pirate.getPosition() + avancement ;
        if (newPosition > TAILLE_MAX ) {
            int depasser = newPosition - TAILLE_MAX;
            newPosition = TAILLE_MAX - depasser;
        }else if (newPosition < 0 ) {
            newPosition = 0;
        }
        pirate.setPosition(newPosition);
        pirate.setChangement(0);
    }

    public void retourDepart(Pirate pirate) {
        pirate.setPosition(0);
    }

    @Override
    public void finDeplacement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
