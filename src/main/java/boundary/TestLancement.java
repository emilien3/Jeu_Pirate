/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import control.ControlJeuPirate;

/**
 *
 * @author Lucas, Robin, Ninon
 */
public class TestLancement {
    public static void main(String[] args) {
        //BoundaryConsole sortie = new BoundaryConsole();
        FrameTestToDelete frame = new FrameTestToDelete();
        AdaptateurNoyau adaptateur = new AdaptateurNoyau(frame);
        ControlJeuPirate control = new ControlJeuPirate(adaptateur, 2);
        control.debutJeu();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}
