package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCaseSecret;
import model.CaseEnum;
import model.Pirate;

class ControleurCaseSecretTest {
	BoundaryConsole sortie = new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCaseSecret cCS =  new ControleurCaseSecret(cJP, sortie);
	Pirate[] pirates =  cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	
	
	@Test
	void test() throws InterruptedException {
		Thread actionThread = new Thread(() -> {
            cCS.action(pirates[tour]);
        });
        actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        assertEquals(2, pirates[tour].getPosition());
        assertEquals(0,cCS.getDepart());
        assertEquals(CaseEnum.SECRET.toString(), cCS.getEffetCase(3));
	
	}

}
