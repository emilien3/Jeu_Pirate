package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.JeuPirate;
import model.Plateau;

class JeuPirateTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	static void test() {
		int[] des = {1,2};
		JeuPirate jeuPirate =  new JeuPirate();
		Plateau plateau = jeuPirate.getPlateau();
		jeuPirate.setDes(des);
		assertEquals(jeuPirate.getDes(),des);
		assertEquals(jeuPirate.verifierFin(), false);
		jeuPirate.getPirates()[1].setPosition(29);
		assertEquals(jeuPirate.verifierFin(), true);
		jeuPirate.getPirates()[0].setPosition(29);
		assertEquals(jeuPirate.verifierFin(), true);
		jeuPirate.getPirates()[1].setLife(0);
		assertEquals(jeuPirate.verifierFin(), true);
		jeuPirate.getPirates()[0].setLife(0);
		assertEquals(jeuPirate.verifierFin(), true);
	}

}
