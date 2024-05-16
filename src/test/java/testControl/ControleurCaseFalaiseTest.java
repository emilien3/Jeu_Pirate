package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCaseFalaise;
import control.ControleurCaseNourriture;
import model.CaseEnum;
import model.Pirate;

class ControleurCaseFalaiseTest {
	BoundaryConsole sortie =  new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCaseFalaise cCF = new ControleurCaseFalaise(cJP, sortie);
	Pirate[] pirates = cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	int nouvellePosition = 2;
	
	@Test
	void getterTest() throws InterruptedException{
		pirates[tour].setLastPosition(nouvellePosition);
		Thread actionThread =  new Thread(() -> {
			cCF.action(pirates[tour]);
		});
		actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
		pirates[tour].setLastPosition(5);
		assertEquals(cCF.getVie(),-2);
		assertEquals(cCF.getArrivee(),nouvellePosition);
		assertEquals(cCF.getDepart(),0);
		assertEquals(cCF.getEffetCase(7),CaseEnum.FALAISE.toString());
	}
	
	
	@Test
	void actionTest() throws InterruptedException {
		pirates[tour].setLastPosition(nouvellePosition);
		Thread actionThread =  new Thread(() -> {
			cCF.action(pirates[tour]);
		});
		actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        assertEquals(pirates[tour].getLastPosition(),nouvellePosition);
        assertEquals(pirates[tour].getPosition(),nouvellePosition);
        assertEquals(pirates[tour].getLife(),3);
	}

}
