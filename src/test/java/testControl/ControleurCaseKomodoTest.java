package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurCaseKomodo;
import model.CaseEnum;
import model.De;
import model.Pirate;

class ControleurCaseKomodoTest {
	De de1 = new De();
	De de2 = new De();
	De[] des = {de1,de2};
	BoundaryConsole sortie =  new BoundaryConsole();
	ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
	ControleurCaseKomodo cCK = new ControleurCaseKomodo(cJP, sortie,des);
	Pirate[] pirates = cJP.getPirates();
	int tour = cJP.getJoueurCourant();
	
	@Test
	void getterTest() throws InterruptedException {
		Thread actionThread1 =  new Thread(() -> {
			cCK.action(pirates[tour]);
		});
		actionThread1.start();
        Thread.sleep(1000);
        actionThread1.stop();  
        actionThread1.join();
		assertEquals(cCK.getDepart(),0);
		assertEquals(cCK.getEffetCase(2),CaseEnum.KOMODO.toString());
		assertEquals(cCK.getVie(),-3);
		assertEquals(cCK.getChangement(),-3);
	}
	
	boolean desValide(int n) {
		return n < 7 && n > 0;
	}
	
	@Test
	void getDesTest() throws InterruptedException {
		Thread actionThread =  new Thread(() -> {
			cCK.finLancer();
		});
		actionThread.start();
        Thread.sleep(1000);
        actionThread.stop();  
        actionThread.join();
        int[] newDes = cCK.getDes();
        assertEquals(desValide(newDes[0]),true);
        assertEquals(desValide(newDes[1]),true);
	}

}
