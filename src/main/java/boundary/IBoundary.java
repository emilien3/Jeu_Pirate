/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package boundary;

import control.IChangement;
import control.IChangerEtat;
import control.IDeplacerPirate;
import control.IInfoPartie;
import control.ILancerDe;
import control.IModifierVie;
/**
 *
 * @author Ninon
 */
public interface IBoundary {
    public void debutTour(IInfoPartie control);
    public void lancerDe(ILancerDe control);
    public void deplacer(IDeplacerPirate control);
    public void deplacerAuto(IDeplacerPirate control);
    public void changementProchainTour(IChangement control);
    public void changerEtat(IChangerEtat control);
    public void modifierVie(IModifierVie control);
    public void finPartie(IInfoPartie controlInfoPartie);
}