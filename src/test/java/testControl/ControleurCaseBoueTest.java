package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCaseBoue;
import control.ControleurCaseFalaise;
import model.Pirate;

class ControleurCaseBoueTest {
	BoundaryConsole sortie =  new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCaseBoue cCB = new ControleurCaseBoue(cJP, sortie);
	Pirate[] pirates = cJP.getPirates();
	int tour = cJP.getJoueurCourant();

	@Test
	void getChangementTest() {
		assertEquals(cCB.getChangement(),-3);
	}
	
	@Test
	void actionTest() throws InterruptedException {
		Thread actionThread1 =  new Thread(() -> {
			cCB.action(pirates[tour]);
		});
		actionThread1.start();
        Thread.sleep(1000);
        actionThread1.stop();  
        actionThread1.join();
        assertEquals(pirates[tour].getChangement(),-3);
	}

}
