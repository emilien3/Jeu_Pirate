package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import boundary.*;
import control.*;
import model.*;
import org.junit.jupiter.api.Test;

class ControleurRetourCaseDebutTest {
	BoundaryConsole sortie = new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurRetourCaseDebut cRCD =  new ControleurRetourCaseDebut(cJP, sortie);
	Pirate[] pirates =  cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	void test() throws InterruptedException{
        Thread actionThread = new Thread(() -> {
            cRCD.action(pirates[tour]);
        });
        actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        assertEquals(0, pirates[tour].getPosition());
        assertEquals(0,cRCD.getDepart());
        assertEquals(CaseEnum.DEBUT.toString(), cRCD.getEffetCase(26));
	}

}
