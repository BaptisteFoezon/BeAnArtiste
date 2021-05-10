package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	@Test
	public void testConstructeurs() {
		Cercle cercle1 = new Cercle();
		assertEquals("Hauteur par défaut attendue :", 10, cercle1.getHauteur(), 0.1);
		assertEquals("Largeur par défaut attendue :", 10, cercle1.getLargeur(), 0.1);
		assertEquals("Abscisse par défaut attendue :", 0, cercle1.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee par défaut attendue :", 0, cercle1.getPosition().getOrdonnee(), 0.1);
		assertEquals("Couleur par défaut attendue :", Forme.COULEUR_PAR_DEFAUT.getRGB(), cercle1.getCouleur().getRGB(),
				0.1);

		Cercle cercle2 = new Cercle(15);
		assertEquals("Hauteur  attendue :", 15, cercle2.getHauteur(), 0.1);
		assertEquals("Largeur  attendue :", 15, cercle2.getLargeur(), 0.1);
		assertEquals("Abscisse par défaut attendue :", 0, cercle2.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee par défaut attendue :", 0, cercle2.getPosition().getOrdonnee(), 0.1);
		assertEquals("Couleur par défaut attendue :", Forme.COULEUR_PAR_DEFAUT.getRGB(), cercle2.getCouleur().getRGB(),
				0.1);

		Cercle cercle3 = new Cercle(new Coordonnees(50, -45));
		assertEquals("Hauteur par défaut attendue :", 10, cercle3.getHauteur(), 0.1);
		assertEquals("Largeur par défaut attendue :", 10, cercle3.getLargeur(), 0.1);
		assertEquals("Abscisse attendue :", 50, cercle3.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", -45, cercle3.getPosition().getOrdonnee(), 0.1);

		Cercle cercle4 = new Cercle(new Coordonnees(200, 200), 10);
		assertEquals("Hauteur attendue :", 10, cercle4.getHauteur(), 0.1);
		assertEquals("Largeur attendue :", 10, cercle4.getLargeur(), 0.1);
		assertEquals("Abscisse attendue :", 200, cercle4.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", 200, cercle4.getPosition().getOrdonnee(), 0.1);

	}

	@Test
	public void testSettersGetters() {
		Cercle cercle = new Cercle();

		cercle.setHauteur(15);
		assertEquals("Hauteur attendue :", 15, cercle.getHauteur(), 0.1);

		cercle.setLargeur(78);
		assertEquals("Largeur attendue :", 78, cercle.getLargeur(), 0.1);

		cercle.setCouleur(Color.CYAN);
		assertEquals("Couleur attendue :", Color.cyan.getRGB(), cercle.getCouleur().getRGB(), 0.1);

		assertEquals("cercle par défaut vide", false, cercle.estRempli());
		cercle.setRempli(true);
		assertEquals("cercle pleine", true, cercle.estRempli());

		cercle.setPosition(new Coordonnees(100, 100));
		assertEquals("Abscisse attendue :", 100, cercle.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", 100, cercle.getPosition().getOrdonnee(), 0.1);

		cercle.deplacerDe(15, 20);
		assertEquals("Abscisse attendue :", 115, cercle.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", 120, cercle.getPosition().getOrdonnee(), 0.1);

		cercle.deplacerVers(24, -45);
		assertEquals("Abscisse attendue :", 24, cercle.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", -45, cercle.getPosition().getOrdonnee(), 0.1);

	}

	@Test
	public void testGetCadres() {
		Cercle cercle = new Cercle(new Coordonnees(1, 1), 1);

		assertEquals("Abscisse attendue :", 1, cercle.getCadreMinX(), 0.1);
		assertEquals("Ordonnee attendue :", 1, cercle.getCadreMinY(), 0.1);
		assertEquals("Abscisse attendue :", 2, cercle.getCadreMaxX(), 0.1);
		assertEquals("Ordonnee attendue :", 2, cercle.getCadreMaxY(), 0.1);

		cercle.deplacerVers(-2, -2);
		assertEquals("Abscisse attendue :", -2, cercle.getCadreMinX(), 0.1);
		assertEquals("Ordonnee attendue :", -2, cercle.getCadreMinY(), 0.1);
		assertEquals("Abscisse attendue :", -1, cercle.getCadreMaxX(), 0.1);
		assertEquals("Ordonnee attendue :", -1, cercle.getCadreMaxY(), 0.1);

	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstructeur1Exceptiont() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Cercle cercle = new Cercle(-10);
	}

	@Test
	public void testConstructeur2Exception() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Cercle cercle = new Cercle(new Coordonnees(-155, 48), -50);
	}

	@Test
	public void testSetHauteurException() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'un cercle ne peut pas être inférieur à 0.");
		Cercle cercle = new Cercle();
		cercle.setHauteur(-10);
	}

	@Test
	public void testSetLargeurExeotion() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'un cercle ne peut pas être inférieur à 0.");
		Cercle cercle = new Cercle();
		cercle.setLargeur(-10);
	}

	@Test
	public void testToString() {
		Cercle cercle = new Cercle();
		assertTrue("[Cercle] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51"
				.equals(cercle.toString()));

		cercle.setCouleur(Color.CYAN);
		assertTrue(cercle.toString().equals(
				"[Cercle] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,V255,B255"));

		cercle.setRempli(true);
		assertTrue(cercle.toString().equals(
				"[Cercle-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,V255,B255"));

		Locale.setDefault(Locale.ENGLISH);
		assertTrue(cercle.toString().equals(
				"[Cercle-Rempli] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 31.42 aire : 78.54 couleur = R0,G255,B255"));

		Locale.setDefault(Locale.GERMAN);

		assertTrue(cercle.toString().equals(
				"[Cercle-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,G255,B255"));
	}

	@Test
	public void testContient() {
		Cercle cercle = new Cercle(10);
		Coordonnees pointA = new Coordonnees(5, 5);
		Coordonnees pointB = new Coordonnees(11, 11);
		Coordonnees pointC = new Coordonnees(-5, -5);
		Coordonnees pointD = new Coordonnees(-9, -9);
		Coordonnees pointE = new Coordonnees(-2, 4.58);

		assertTrue(cercle.contient(pointA));
		assertFalse(cercle.contient(pointB));

		cercle.deplacerDe(-10, -10);
		assertTrue(cercle.contient(pointC));
		assertFalse(cercle.contient(pointD));

		cercle.deplacerDe(5, 5);
		assertTrue(cercle.contient(pointE));

	}

	@Test
	public void testAire() {
		Cercle cercle = new Cercle(10);
		assertEquals("Aire attendue :", Math.PI * 25, cercle.aire(), 0.1);
		cercle.setHauteur(100);
		assertEquals("Aire attendue :", Math.PI * 2500, cercle.aire(), 0.1);
	}

	@Test
	public void testPerimetre() {
		Cercle cercle = new Cercle(10);
		assertEquals("Perimetre attendu :", 2 * Math.PI * 5, cercle.perimetre(), 0.1);

	}

}
