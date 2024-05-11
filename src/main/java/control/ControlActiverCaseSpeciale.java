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
public abstract class ControlActiverCaseSpeciale {
    protected ControlJeuPirate controlJeuPirate;
    
    public abstract void action(Pirate pirate);
    
    public void finAction(){
        controlJeuPirate.finActionCase();
    }
}
