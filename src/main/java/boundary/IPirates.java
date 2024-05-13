/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package boundary;


import model.Etat;

/**
 *
 * @author Ninon
 */
public interface IPirates {

    //Fonction qui seront appelées depuis l'adaptateur noyau
    public void initDialog(FrameTestToDelete frame);
    public void changerJoueur();
    public void enableLancerDe();
    public void enableDeplacement();
    public void changerPositionPirate(int numCase);
    public void changerChangement();
    public void changerEtat();
    public void changerVie();
    public void finDePartie();
}
