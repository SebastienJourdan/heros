package heros;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.sjo.heros.Main;

public class TestDeplacement {

	private static final String FICHIER_CARTE_INIT = "src/test/resources/carte v2.txt";
	private static final String FICHIER_DEP_1 = "src/test/resources/deplacement1.txt";
	private static final String FICHIER_DEP_2 = "src/test/resources/deplacement2.txt";
	
	private static final String FICHIER_CARTE_SANS_ESPACE = "src/test/resources/testNePeutSeDeplacer.txt";
	private static final String FICHIER_CARTE_AVEC_ESPACE = "src/test/resources/testPeutSeDeplacer.txt";
	private static final String FICHIER_DEP_MONTER = "src/test/resources/monter.txt";
	private static final String FICHIER_DEP_DESCENDE = "src/test/resources/descendre.txt";
	private static final String FICHIER_DEP_ALLER_A_DROITE = "src/test/resources/allerADroite.txt";
	private static final String FICHIER_DEP_ALLER_A_GAUCHE = "src/test/resources/allerAGauche.txt";
	
	@Test
	public void testInitDep1 () {
		String[] args = {FICHIER_CARTE_INIT, FICHIER_DEP_1};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 9);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testInitDep2 () {
		String[] args = {FICHIER_CARTE_INIT, FICHIER_DEP_2};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 1);
		assertEquals(positionFinale[1], 9);
	}
	
	
	@Test
	public void testNePeutPasMonter () {
		String[] args = {FICHIER_CARTE_SANS_ESPACE, FICHIER_DEP_MONTER};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testNePeutPasDescendre () {
		String[] args = {FICHIER_CARTE_SANS_ESPACE, FICHIER_DEP_DESCENDE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testNePeutPasAllerADroite () {
		String[] args = {FICHIER_CARTE_SANS_ESPACE, FICHIER_DEP_ALLER_A_DROITE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testNePeutPasAllerAGauche () {
		String[] args = {FICHIER_CARTE_SANS_ESPACE, FICHIER_DEP_ALLER_A_GAUCHE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testPeutMonter () {
		String[] args = {FICHIER_CARTE_AVEC_ESPACE, FICHIER_DEP_MONTER};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 1);
	}
	
	@Test
	public void testPeutDescendre () {
		String[] args = {FICHIER_CARTE_AVEC_ESPACE, FICHIER_DEP_DESCENDE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 2);
		assertEquals(positionFinale[1], 3);
	}
	
	@Test
	public void testPeutAllerADroite () {
		String[] args = {FICHIER_CARTE_AVEC_ESPACE, FICHIER_DEP_ALLER_A_DROITE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 3);
		assertEquals(positionFinale[1], 2);
	}
	
	@Test
	public void testPeutAllerAGauche () {
		String[] args = {FICHIER_CARTE_AVEC_ESPACE, FICHIER_DEP_ALLER_A_GAUCHE};
		int[] positionFinale = Main.scanDeDeplacement(args);
		assertEquals(positionFinale[0], 1);
		assertEquals(positionFinale[1], 2);
	}
	
}
