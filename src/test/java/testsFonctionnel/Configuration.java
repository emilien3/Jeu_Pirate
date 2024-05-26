package testsFonctionnel;
import model.*;

/* CONF_1 : Le joueur est au milieu du jeu avec 3 points de vie.
* Déplacement sur case spéciale.
*/


/*CONF_2 : Le joueur est au début du jeu avec 3 points de vie.
 * Déplacement sur case spéciale.
 * */


/* CONF_3 : Le joueur part de la case boue avec 3 points de vie et avec 
 * changement actif (arrive sur une case normale).	
 * Déplacement simple avec changement.
 * */


/* CONF_4 : Le joueur est une case avant la fin, Le joueur a 2 points de vie
 * Déplacement simple qui emmène sur la fin du jeu.
 * */

public class Configuration {

	private JeuPirate monJeuPirate;
	private Pirate pirate1;
	private De de;
	
	public JeuPirate getMonJeuPirate() {
		return monJeuPirate;
	}


	public void setMonJeuPirate(JeuPirate monJeuPirate) {
		this.monJeuPirate = monJeuPirate;
	}


	public Pirate getPirate1() {
		return pirate1;
	}


	public void setPirate1(Pirate pirate1) {
		this.pirate1 = pirate1;
	}


	public De getDe() {
		return de;
	}


	public void setDe(De de) {
		this.de = de;
	}


	public Configuration(int numConfig){
		this.monJeuPirate = new JeuPirate();
		this.pirate1 = monJeuPirate.getPirates()[0];
		this.de = new De();
		
		switch (numConfig) {
			case 1: {
				Configuration1();
				break;
			}
			case 2: {
				Configuration2();
				break;
			}
			case 3: {
				Configuration3();
				break;
			}
			case 4: {
				Configuration4();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + numConfig);
		 }
	}
	 
	 
	 public void Configuration1() {
		 pirate1.setLife(5);
		 pirate1.setPosition(13);
	 }
	
	 public void Configuration2() {
		 pirate1.setLife(3);
		 pirate1.setPosition(5);
	 }
	 
	 public void Configuration3() {
		 pirate1.setLife(3);
		 pirate1.setPosition(13);
		 pirate1.setChangement(-3);
		 
	 }
	 public void Configuration4() {
		 pirate1.setLife(2);
		 pirate1.setPosition(24); //dernière case normale avant la fin
	 }

	
	
	
}
