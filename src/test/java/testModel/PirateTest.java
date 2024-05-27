package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Etat;
import model.Pirate;

class PirateTest {


	@Test
	void test() {
		Pirate pirate = new Pirate("test");
		assertEquals(pirate.getNom(),"test");
		pirate.setChangement(2);
		assertEquals(pirate.getChangement(),2);
		pirate.setLife(3);
		assertEquals(pirate.getLife(),3);
		pirate.setLife(10);
		assertEquals(pirate.getLife(),5);
		pirate.setPosition(2);
		assertEquals(pirate.getPosition(),2);
		pirate.setLastPosition(1);
		assertEquals(pirate.getLastPosition(),1);
		pirate.setEtat(Etat.ESTPRISON);
		assertEquals(pirate.getEtat(),Etat.ESTPRISON);
	}

}
