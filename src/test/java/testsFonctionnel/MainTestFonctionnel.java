package testsFonctionnel;

import model.De;

/* Pour cette phase de test fonctionnelle, plusieurs points s'imposent :
 * 
 */
/*	* Nous devons nous limiter au test du modèle :
 * 		En effet, utiliser les classes du controleur lancerait automatiquement des parties;
 * 		dans le but d'éviter cela, nous devons nous rapprocher au maximum de la logique.
 * 	
 * 	* Afin d'alléger cette phase de test des choix de de facilité ont étaient pris :
 * 		Nous concentrons notre partie sur le pirate que nous appellerons Joueur1, 
 * 		càd que nous ignorions complètement le joueur2 allant jusqu'à ne pas réaliser 
 * 		son tour
 * 
 * 	* Et enfin, cet ensemble de test s'isnpire du plan de tests papier mais en est une version 
 * 	* simplifié dû à un manque de temps 
 */

/* 
 * Test 1 : Le joueur effectue un déplacement qui le fait arriver 
 * sur une case spéciale (case spéciale boue).
 *
 * Test 2 : Le joueur effectue un déplacement qui le fait arriver sur une 
 * case spéciale (case dragon de komodo). -> meurt
 * 
 * Test 3 : Le joueur effectue un déplacement qui le fait arriver sur une
 * case sans effets.
 * 
 * Test 4 : Le joueur effectue un déplacement qui le fait arriver
 * sur une case sans effets mais qui s'avère être la dernière case.
 * */


public class MainTestFonctionnel {
	
	//le but ici est de simuler le pseudo fonctionnement du progamme de façon simplifié,
	//sans controleur, dans le but d'analyser les effets de chacune des méthodes dans le cas
	//d'une partie en cours, et cela, pour tout les tests
	
	public void test1(){
		System.out.println("\nInitialisation du plateau\n");
		Configuration config1 = new Configuration(1);
		System.out.println("\n\n");
		//lancement du dé -> on définit les dés manuellement pour éviter l'aléatoire
		int[] des = {1,1};
		config1.getMonJeuPirate().setDes(des);;

		//simulation du lancé de dé
		simulationDe(config1, 2);
		
		if (config1.getMonJeuPirate().verifierFin()){
			System.out.println("Joueur1 est arriver à la fin !");
			return;
		}
		// Vérification du type de case
		System.out.println("Est ce que vous êtes tombé sur une case spéciale ?");
		System.out.println(config1.getMonJeuPirate().getPlateau().estSpeciale(config1.getPirate1().getPosition()));
		//tombe sur la case spéciale boue
		System.out.println("\nLa nouvelle case est : " + config1.getMonJeuPirate().getPlateau().donnerCase(config1.getPirate1().getPosition()).toString());
		//le joueur obtient alors un malus de -3
		config1.getPirate1().setChangement(-3);		
	}
	
	public void test2(){
		System.out.println("\nInitialisation du plateau\n");
		Configuration config2 = new Configuration(2);
		System.out.println("\n\n");
		//lancement du dé -> on définit les dés manuellement pour éviter l'aléatoire
		int[] des = {2,3};
		config2.getMonJeuPirate().setDes(des);;
		
		simulationDe(config2, 5);
		
		if (config2.getMonJeuPirate().verifierFin()){
			System.out.println("\nJoueur1 est arriver à la fin !");
			return;
		}
		
		// Vérification du type de case
		System.out.println("Est ce que vous êtes tombé sur une case spéciale ?");
		System.out.println(config2.getMonJeuPirate().getPlateau().estSpeciale(config2.getPirate1().getPosition()));
		
		//tombe sur la case spéciale komodo
		System.out.println(config2.getMonJeuPirate().getPlateau().donnerCase(config2.getPirate1().getPosition()).toString());
		
		//Initialement, on peut relancer le dé
		int resDe = 4; //ici on teste le cas où on obtient moins de 8
		if (resDe>=8) {
			simulationDe(config2, resDe);
		}
		else {
			//le joueur perd 3 de vie
			config2.getPirate1().setLife(config2.getPirate1().getLife()-3);
			//le joueur obtient alors un malus de -3
			config2.getPirate1().setChangement(-3);		
		}
		System.out.println("Le joueur a maintenant "+ config2.getPirate1().getLife() +" points de vie");
		if (config2.getMonJeuPirate().verifierFin()){
			System.out.println("La partie est terminée !");
			return;
		}
		System.out.println("La partie n'est pas terminée !");
	}
	
	public void test3(){
		System.out.println("\nInitialisation du plateau\n");
		Configuration config3 = new Configuration(3);
		System.out.println("\n\n");
		
		//lancement du dé -> on définit les dés manuellement pour éviter l'aléatoire
		int[] des = {1,1};
		config3.getMonJeuPirate().setDes(des);;

		//simulation du lancé de dé
		simulationDe(config3, 2);
		config3.getPirate1().setChangement(0);	
		
		if (config3.getMonJeuPirate().verifierFin()){
			System.out.println("Joueur1 est arriver à la fin !");
			return;
		}
		
		// Vérification du type de case
		System.out.println("Est ce que vous êtes tombé sur une case spéciale ?");
		System.out.println(config3.getMonJeuPirate().getPlateau().estSpeciale(config3.getPirate1().getPosition()));
	
		System.out.println("\nLa nouvelle case est : "+config3.getMonJeuPirate().getPlateau().donnerCase(config3.getPirate1().getPosition()).toString());
			
	}
	
	public void test4(int resDe1,int resDe2){
		
		System.out.println("\nInitialisation du plateau\n");
		Configuration config4 = new Configuration(4);
		System.out.println("\n\n");
		
		//lancement du dé -> on définit les dés manuellement pour éviter l'aléatoire
		int[] des = {resDe1, resDe2};
		config4.getMonJeuPirate().setDes(des);;

		//simulation du lancé de dé
		simulationDe(config4, (resDe1+resDe2));
		
		if (config4.getMonJeuPirate().verifierFin()){
			System.out.println("Joueur1 est arriver à la fin !");
			return;
		}
		// Vérification du type de case
		System.out.println("Est ce que vous êtes tombé sur une case spéciale ?");
		System.out.println(config4.getMonJeuPirate().getPlateau().estSpeciale(config4.getPirate1().getPosition()));
		//Description de la case sur laquelle il est tombé
		System.out.println("\nLa nouvelle case est : " + config4.getMonJeuPirate().getPlateau().donnerCase(config4.getPirate1().getPosition()).toString());
	}
	
	public void simulationDe(Configuration conf, int resDe) {
		int lastPosition = conf.getPirate1().getPosition();
		System.out.println("Joueur1 était sur la case "+lastPosition);
		conf.getPirate1().setLastPosition(lastPosition);
		int newPosition = lastPosition + resDe + conf.getPirate1().getChangement(); // actualisation faite manuellement
		//Dans le cas d'un dépassement
		if (newPosition>29) {
			newPosition = 29 + (29-newPosition);
		} 
		conf.getPirate1().setPosition(newPosition);
		System.out.println("Joueur1 est maintenant sur la case " + newPosition);
	}
	
	
	public static void main(String[] args) {
		
		MainTestFonctionnel mainTest = new MainTestFonctionnel();
		
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		
		mainTest.test1();
		
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		mainTest.test2();
		
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		mainTest.test3();
		
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		//test où le joueur arrive à la fin 
		mainTest.test4(3, 2);
		
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		//test où le joueur n'arrive pas à la fin 
		mainTest.test4(3, 3);
		
	}

}