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

public class EllipseTest {

	@Test
	public void testConstructeurs() {
		Ellipse ellipse1 = new Ellipse();
		assertEquals("Hauteur par défaut attendue :", 10, ellipse1.getHauteur(), 0.1);
		assertEquals("Largeur par défaut attendue :", 10, ellipse1.getLargeur(), 0.1);
		assertEquals("Abscisse par défaut attendue :", 0, ellipse1.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee par défaut attendue :", 0, ellipse1.getPosition().getOrdonnee(), 0.1);
		assertEquals("Couleur par défaut attendue :", Forme.COULEUR_PAR_DEFAUT.getRGB(), ellipse1.getCouleur().getRGB(),
				0.1);

		Ellipse ellipse2 = new Ellipse(15, 156);
		assertEquals("Hauteur  attendue :", 156, ellipse2.getHauteur(), 0.1);
		assertEquals("Largeur  attendue :", 15, ellipse2.getLargeur(), 0.1);
		assertEquals("Abscisse par défaut attendue :", 0, ellipse2.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee par défaut attendue :", 0, ellipse2.getPosition().getOrdonnee(), 0.1);
		assertEquals("Couleur par défaut attendue :", Forme.COULEUR_PAR_DEFAUT.getRGB(), ellipse2.getCouleur().getRGB(),
				0.1);

		Ellipse ellipse3 = new Ellipse(new Coordonnees(50, -45));
		assertEquals("Hauteur par défaut attendue :", 10, ellipse3.getHauteur(), 0.1);
		assertEquals("Largeur par défaut attendue :", 10, ellipse3.getLargeur(), 0.1);
		assertEquals("Abscisse attendue :", 50, ellipse3.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", -45, ellipse3.getPosition().getOrdonnee(), 0.1);

		Ellipse ellipse4 = new Ellipse(new Coordonnees(200, 200), 10, 50);
		assertEquals("Hauteur attendue :", 50, ellipse4.getHauteur(), 0.1);
		assertEquals("Largeur attendue :", 10, ellipse4.getLargeur(), 0.1);
		assertEquals("Abscisse attendue :", 200, ellipse4.getPosition().getAbscisse(), 0.1);
		assertEquals("Ordonnee attendue :", 200, ellipse4.getPosition().getOrdonnee(), 0.1);

	}

	@Test
	public void testSetters() {
		Ellipse ellipse1 = new Ellipse();

		ellipse1.setHauteur(15);
		assertEquals("Hauteur attendue :", 15, ellipse1.getHauteur(), 0.1);

		ellipse1.setLargeur(78);
		assertEquals("Largeur attendue :", 78, ellipse1.getLargeur(), 0.1);

		ellipse1.setCouleur(Color.CYAN);
		assertEquals("Couleur attendue :", Color.cyan.getRGB(), ellipse1.getCouleur().getRGB(), 0.1);

		assertEquals("ellipse par défaut vide", false, ellipse1.estRempli());
		ellipse1.setRempli(true);
		assertEquals("ellipse pleine", true, ellipse1.estRempli());
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstructeur1ExceptionLargeur() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse(-10, 50);
	}

	@Test
	public void testConstructeur1ExceptionHauteur() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse(10, -50);
	}

	@Test
	public void testConstructeur2ExceptionLargeur() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse(new Coordonnees(1, 5), -50, 50);
	}

	@Test
	public void testConstructeur2ExceptionHauteur() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse(new Coordonnees(1, 5), 50, -50);
	}

	@Test
	public void testSetHauteurException() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse();
		ellipse.setHauteur(-1);
	}

	@Test
	public void testSetLargeurExeotion() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("la taille d'une ellipse ne peut pas être inférieur à 0.");
		Ellipse ellipse = new Ellipse();
		ellipse.setLargeur(-10);
	}

	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.toString().equals(
				"[Ellipse] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51"));

		ellipse.setCouleur(Color.CYAN);
		assertTrue(ellipse.toString().equals(
				"[Ellipse] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,V255,B255"));

		ellipse.setRempli(true);
		assertTrue(ellipse.toString().equals(
				"[Ellipse-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,V255,B255"));

		Locale.setDefault(Locale.ENGLISH);
		assertTrue(ellipse.toString().equals(
				"[Ellipse-Rempli] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 31.42 aire : 78.54 couleur = R0,G255,B255"));

		Locale.setDefault(Locale.GERMAN);

		assertTrue(ellipse.toString().equals(
				"[Ellipse-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R0,G255,B255"));
	}

	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse(10, 10);
		Coordonnees pointA = new Coordonnees(5, 5);
		Coordonnees pointB = new Coordonnees(11, 11);

		assertTrue(ellipse.contient(pointA));
		assertFalse(ellipse.contient(pointB));

	}

	@Test
	public void testAire() {
		Ellipse ellipse = new Ellipse(10, 10);
		assertEquals("Aire attendue :", Math.PI * 25, ellipse.aire(), 0.1);
	}

	@Test
	public void testPerimetre() {
		Ellipse ellipse = new Ellipse(10, 10);
		assertEquals("Perimetre attendu :", 2 * Math.PI * 5, ellipse.perimetre(), 0.1);

	}

}
