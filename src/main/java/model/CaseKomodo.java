/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laura
 */
public class CaseKomodo extends Cases {
    private final int CHANGEMENT = -3;
    private final int PERTEPOINTDEVIE = 3;
    private final int GAGNE = 8;
    
    public CaseKomodo(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case komodo";
    }
    
    public void activerCase(Pirate pirate){
        pirate.setEtat(Etat.ESTPOURSUIVI);
        System.out.println("Le joueur vient d arriver sur une case komodo et dois relancer les des pour savoir si il court assez vite.");
        int[] des = controljeuPirate.lancerDe();
        int sommeDes = des[0] + des[1];
        if (sommeDes <= GAGNE) {
            System.out.println("Le joueur n a pas courru assez vite.");
            controljeuPirate.perdrePointsDeVie(PERTEPOINTDEVIE,pirate);
            pirate.setChangement(CHANGEMENT);
        } else {
            System.out.println("Le joueur a courru assez vite.");
            pirate.setPosition(pirate.getPosition()+sommeDes);
        }
        pirate.setEtat(Etat.ESTVIVANT, pirate);
    }
}
