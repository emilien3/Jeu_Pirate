/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

import model.Etat;
import model.Pirate;

/**
 *
 * @author Ninon
 */
public interface IChangerEtat {
    public void changerEtat(Etat etat, Pirate pirate);
    public void finChangerEtat();
}
