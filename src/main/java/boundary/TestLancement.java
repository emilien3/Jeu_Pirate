/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import control.ControlJeuPirate;

/**
 *
 * @author Robin
 */
public class TestLancement {
    public static void main(String[] args) {
        BoundaryConsole sortie = new BoundaryConsole();
        ControlJeuPirate control = new ControlJeuPirate(sortie, 2);
        control.debutTour();
        
    }
}
