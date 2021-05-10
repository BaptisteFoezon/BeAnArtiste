package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeur() {
		Coordonnees ptA = new Coordonnees();
		assertEquals("Origine attendue : ", 0, ptA.getAbscisse(), 0.1);
		assertEquals("Origine attendue : ", 0, ptA.getOrdonnee(), 0.1);
		Coordonnees ptB = new Coordonnees(5, 12.2);
		assertEquals("Abscisse attendue : ", 5, ptB.getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue : ", 12.2, ptB.getOrdonnee(), 0.1);
		Coordonnees ptC = new Coordonnees(17.1, -7.07);
		assertEquals("Abscisse attendue : ", 17.1, ptC.getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue : ", -7.07, ptC.getOrdonnee(), 0.1);
	}

	@Test
	public void testEcriture() {
		Coordonnees ptA = new Coordonnees();
		ptA.setAbscisse(25);
		assertEquals("Abscisse attendue : ", 25, ptA.getAbscisse(), 0.1);
		ptA.setOrdonnee(-100);
		assertEquals("Ordonnee attendue : ", -100, ptA.getOrdonnee(), 0.1);
		Coordonnees ptB = new Coordonnees(0, -522);
		ptB.setAbscisse(3 * 8);
		assertEquals("Abscisse attendue : ", 24, ptB.getAbscisse(), 0.1);
		ptB.setOrdonnee(Math.PI);
		assertEquals("Ordonnee attendue : ", 3.1415, ptB.getOrdonnee(), 0.1);
	}

	@Test
	public void testDeplacement() {
		Coordonnees ptA = new Coordonnees(4, 7.4);
		ptA.deplacerVers(-8.4, 0);
		assertEquals("Abscisse attendue : ", -8.4, ptA.getAbscisse(), 0.01);
		assertEquals("Ordonnee attendue : ", 0, ptA.getOrdonnee(), 0.01);
		ptA.deplacerDe(+178.774, -009.149);
		assertEquals("Abscisse attendue : ", -8.4 + 178.774, ptA.getAbscisse(), 0.01);
		assertEquals("Ordonnee attendue : ", 0 - 009.149, ptA.getOrdonnee(), 0.01);
	}

	@Test
	public void testDistance() {
		Coordonnees pointA = new Coordonnees(1, 1);
		Coordonnees pointB = new Coordonnees(2, 2);
		assertEquals("Distance attendue : ", Math.sqrt(2), pointA.distanceVers(pointB), 0.1);
		Coordonnees pointC = new Coordonnees(0.1655, -822);
		Coordonnees pointD = new Coordonnees(+62, -1.3);
		assertEquals("Distance attendue : ", Math.sqrt(3823.50539 + 673548.49), pointC.distanceVers(pointD), 0.1);
	}

	@Test
	public void testAngle() {
		Coordonnees pointA = new Coordonnees(0, 0);
		Coordonnees pointB = new Coordonnees(1, 1);

		assertEquals("Angle attendu : ", 45 * Math.PI / 180, pointA.angleVers(pointB), 0.1);

		pointB.deplacerVers(-1, 1);

		assertEquals("Angle attendu : ", 135 * Math.PI / 180, pointA.angleVers(pointB), 0.1);

	}

	@Test
	public void testToString() {
		Coordonnees pointA = new Coordonnees();
		assertTrue(pointA.toString().equals("(0,0 , 0,0)"));
	}

}
