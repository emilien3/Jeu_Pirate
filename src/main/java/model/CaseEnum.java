/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author Ninon
 */
public enum CaseEnum {
    NORMALE("Case normale - Pas d'effet"), BOUE("Case boue - Moins 3 sur le prochain lancer"), 
    FALAISE("Case falaise - Moins 2 points de vie et retour sur la case précédente"), KOMODO("Case dragon de Komodo - Si lancer inférieur à 8, perte de 3 points de  vie et moins 3 sur le prochain lancer"), 
    LIANES("Case prison de lianes - Bloqué jusqu'à obtention d'un 10"), NOURRITURE("Case nourriture - Gagne 1 point de vie et plus 2 sur le prochain lancer"), 
    PIERRE("Case chute de pierres - Passe un tour"), DEBUT("Case retour au début - Retourne sur la première case"), SECRET("Case passage secret - Avance de 2 cases");
    
    private final String nom;

    private CaseEnum(String nom) {
            this.nom = nom;
    }

    @Override
    public String toString() {
            return nom;
    }
}
