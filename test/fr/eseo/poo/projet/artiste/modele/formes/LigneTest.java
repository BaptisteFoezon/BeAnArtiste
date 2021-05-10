package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	@Test
	public void test() {
		Ligne l1 = new Ligne();
		assertEquals("test hauteur", l1.hauteur, Forme.HAUTEUR_PAR_DEFAUT, 0);
		assertEquals("test largeur", l1.largeur, Forme.LARGEUR_PAR_DEFAUT, 0);
		Coordonnees c1 = new Coordonnees(5, 5);
		Ligne l2 = new Ligne(c1);
		assertEquals("test ligne coord", l2.getPosition(), c1);
		assertEquals("test hauteur", l2.hauteur, Forme.HAUTEUR_PAR_DEFAUT, 0);
		assertEquals("test largeur", l2.largeur, Forme.LARGEUR_PAR_DEFAUT, 0);
		Coordonnees c2 = new Coordonnees(5, 5);
		double h = 20;
		double l = 10;
		Ligne l3 = new Ligne(c2, h, l);
		System.out.print(l3.getPosition());
		assertEquals("test coord ", l3.getPosition(), c2);
		assertEquals("test hauteur", l3.hauteur, 20, 0);
		assertEquals("test largeur", l3.largeur, 10, 0);
		double h2 = 10.0;
		double long2 = 10.0;
		Ligne l4 = new Ligne(h2, long2);
		assertEquals("test hauteur", l4.hauteur, 10, 0);
		assertEquals("test largeur", l4.largeur, 10, 0);
		Ligne l5 = new Ligne(new Coordonnees(10, 10), -5, 20);
		System.out.print(l5.toString());
		assertEquals("test to string", l5.toString(),
				"[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04�");
	}
}
