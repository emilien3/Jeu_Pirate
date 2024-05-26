package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Etat;

class EtatTest {

	@Test
	static void test() {
		assertEquals(Etat.ESTVIVANT.toString(),"va bien");
		assertEquals(Etat.PASSETOUR.toString(),"passer son prochain tour");
		assertEquals(Etat.ESTPRISON.toString(),"est en prison");
		assertEquals(Etat.ESTPOURSUIVI.toString(),"est poursuivi");
	}

}
