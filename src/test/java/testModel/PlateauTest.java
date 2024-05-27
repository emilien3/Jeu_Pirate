package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.CaseEnum;
import model.Plateau;

class PlateauTest {

	@Test
	void test() {
		Plateau plateau = new Plateau();
		assertEquals(plateau.getTAILLETABLEAU(),30);
		assertEquals(plateau.donnerCase(0), CaseEnum.NORMALE);
		assertEquals(plateau.estSpeciale(1),false);
		assertEquals(plateau.estSpeciale(2),true);
	}

}
