package testModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CaseEnum;

class CaseEnumTest {
	
	@Test
	void test() {
		assertEquals(CaseEnum.NORMALE.toString(),"Case normale - Pas d'effet");
		assertEquals(CaseEnum.BOUE.toString(),"Case boue - Moins 3 sur le prochain lancer");
		assertEquals(CaseEnum.FALAISE.toString(),"Case falaise - Moins 2 points de vie et retour sur la case precedente");
		assertEquals(CaseEnum.LIANES.toString(),"Case prison de lianes - Bloque jusqu'a obtention d'un 10");
		assertEquals(CaseEnum.PIERRE.toString(),"Case chute de pierres - Passe un tour");
		assertEquals(CaseEnum.KOMODO.toString(),"Case dragon de Komodo - Si lancer inferieur a 8, perte de 3 points de  vie et moins 3 sur le prochain lancer");
		assertEquals(CaseEnum.NOURRITURE.toString(),"Case nourriture - Gagne 1 point de vie et plus 2 sur le prochain lancer");
		assertEquals(CaseEnum.DEBUT.toString(),"Case retour au debut - Retourne sur la premiere case");
		assertEquals(CaseEnum.SECRET.toString(),"Case passage secret - Avance de 2 cases");
	}

}
