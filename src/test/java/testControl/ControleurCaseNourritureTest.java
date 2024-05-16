package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCaseNourriture;
import model.Pirate;

class ControleurCaseNourritureTest {
	BoundaryConsole sortie =  new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCaseNourriture cCN = new ControleurCaseNourriture(cJP, sortie);
	Pirate[] pirates = cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	int nouvelleVie = 2;
	
	
	@Test
	void test() throws InterruptedException {
		pirates[tour].setLife(nouvelleVie);
		Thread actionThread =  new Thread(() -> {
			cCN.action(pirates[tour]);
		});
		actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        assertEquals(cCN.getVie(),1);
        assertEquals(cCN.getChangement(),2);
        assertEquals(pirates[tour].getChangement(),2);
        assertEquals(pirates[tour].getLife(),nouvelleVie + 1);
	}

}
