package testControl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import boundary.BoundaryConsole;
import control.ControlJeuPirate;
import control.ControleurRetourCaseDebut;

class ControleurRetourCaseDebutTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		BoundaryConsole sortie = new BoundaryConsole();
		ControlJeuPirate cJP = new ControlJeuPirate(sortie, 2);
		ControleurRetourCaseDebut cRCD =  new ControleurRetourCaseDebut(cJP, sortie);
		cRCD.action();
	}

}
