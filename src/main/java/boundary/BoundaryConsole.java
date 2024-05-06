/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.IActiverCase;
import control.IDeplacerPirate;
import control.ILancerDe;

/**
 *
 * @author Ninon
 */
public class BoundaryConsole implements IBoundary {
    private IActiverCase controlActiverCase;
    private IDeplacerPirate controlDeplacerPirate;
    private ILancerDe controlLancerDe;

    @Override
    public void lancerDe(ILancerDe c) {
        int[] des = c.rollDices(2);
        System.out.println("Les dés sont :"+des[0]+","+des[1]);
        controlLancerDe.finLancer();
    }

    @Override
    public void deplacer() {
        System.out.println("Le pirate se déplace.");
    }

    @Override
    public void activerCase() {
        System.out.println("On active une case.");
    }

    @Override
    public void finDePartie() {
        System.out.println("La partie est finie");
    }
}
