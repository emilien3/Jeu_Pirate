package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCasePierre;
import control.ControleurCaseSecret;
import model.Etat;
import model.Pirate;

class ControleurCasePierreTest {
	BoundaryConsole sortie =  new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCasePierre cCP = new ControleurCasePierre(cJP, sortie);
	Pirate[] pirates = cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	
	
	@Test
	void test() throws InterruptedException {
		Thread actionThread =  new Thread(() -> {
			cCP.action(pirates[tour]);
		});
		actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        assertEquals(pirates[tour].getEtat(),Etat.PASSETOUR);
        assertEquals(cCP.getEtat(),Etat.PASSETOUR);
	}

}
