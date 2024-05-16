
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package boundary;

import model.CaseEnum;
import model.Etat;

/**
 *
 * @author Ninon
 */
public interface IAdaptateurFonctionnel {
    //Fonctions qui seront appelées depuis le Dialog
    public int getNombreCases();
    public String getNomPirate(int num);
    public String getDescriptionCase(int num);
    public CaseEnum getTypeCase(int num);
    public int[] getResultatsDes();
    public int getPirateCourant();
    public int getProchaineCase();
    public int getDerniereCase();
    public int getChangement();
    public Etat getEtat();
    public int getPointsVie();
    public int getResultat();
    public void finLancerDes();
    public void finDeplacement();
    public void finChangement();
    public void finChangerEtat();
    public void finChangerVie();
}
