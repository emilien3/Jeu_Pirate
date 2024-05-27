package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.De;

class DeTest {


	@Test
	void test() {
		De des = new De();
		des.roll();
		boolean resInf = des.getValue() < 7;
		boolean resSup = des.getValue() > 0;
		assertEquals(resInf,true);
		assertEquals(resSup,true);
	}

}
