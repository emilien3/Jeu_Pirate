/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.IChangement;
import control.IChangerEtat;
import control.IDeplacerPirate;
import control.IInfoPartie;
import control.ILancerDe;
import control.IModifierVie;
import model.Etat;

/**
 *
 * @author Ninon
 */
public class AdaptateurNoyau implements IBoundary, IAdaptateurFonctionnel {
    private IPirates dialog;
    private IInfoPartie controlInfoPartie;
    private ILancerDe controlLancerDe;
    private IDeplacerPirate controlDeplacer;
    private IChangement controlChangement;
    private IChangerEtat controlEtat;
    private IModifierVie controlModifVie;
    
    public AdaptateurNoyau(){
        this.dialog = new Dialog(this);
        dialog.initDialog();
    }

    @Override
    public void debutTour(IInfoPartie control) {
        this.controlInfoPartie = control;
        dialog.changerJoueur();
    }

    @Override
    public void lancerDe(ILancerDe control) {
        this.controlLancerDe = control;
        dialog.enableLancerDe();
    }

    @Override
    public void deplacer(IDeplacerPirate control) {
        this. controlDeplacer = control;
        dialog.enableDeplacement();
    }

    @Override
    public void deplacerAuto(IDeplacerPirate control) {
        this.controlDeplacer = control;
        dialog.changerPositionPirate(controlDeplacer.getArrivee());
    }

    @Override
    public void changementProchainTour(IChangement control) {
        this.controlChangement = control;
        dialog.changerChangement();
    }

    @Override
    public void changerEtat(IChangerEtat control) {
        this.controlEtat = control;
        dialog.changerEtat();
    }

    @Override
    public void modifierVie(IModifierVie control) {
        this.controlModifVie = control;
        dialog.changerVie();
    }

    @Override
    public void finPartie(IInfoPartie controlInfoPartie) {
        this.controlInfoPartie = controlInfoPartie;
        dialog.finDePartie();
    }

    @Override
    public String getNomPirate(int num) {
        return controlInfoPartie.getNomJoueur(num);
    }
    
    @Override
    public String getDescriptionCase(int num) {
        return controlInfoPartie.getEffetcase(num);
    }

    @Override
    public int[] getResultatsDes() {
        return controlLancerDe.getDes();
    }

    @Override
    public int getPirateCourant() {
        return controlInfoPartie.getJoueurCourant();
    }

    @Override
    public int getProchaineCase() {
        return controlDeplacer.getArrivee();
    }

    @Override
    public int getDerniereCase() {
        return controlDeplacer.getDepart();
    }

    @Override
    public int getChangement() {
        return controlChangement.getChangement();
    }

    @Override
    public Etat getEtat() {
        return controlEtat.getEtat();
    }

    @Override
    public int getPointsVie() {
        return controlModifVie.getVie();
    }
    
    @Override
    public int getResultat() {
        return controlInfoPartie.getResultats();
    }
    
    @Override
    public void finLancerDes() {
        controlLancerDe.finLancer();
    }

    @Override
    public void finDeplacement() {
        controlDeplacer.finDeplacement();
    }

    @Override
    public void finChangement() {
        controlChangement.finChangement();
    }

    @Override
    public void finChangerEtat() {
        controlEtat.finChangerEtat();
    }

    @Override
    public void finChangerVie() {
        controlModifVie.finModifVie();
    }

}