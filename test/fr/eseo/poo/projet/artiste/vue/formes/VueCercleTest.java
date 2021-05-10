package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	public VueCercleTest() {
		testAffichage();
	}

	private void testAffichage() {
		JFrame test = new JFrame("Test Affichage Cercle");
		Container content = test.getContentPane();
		PanneauDessin panD = new PanneauDessin();
		content.add(panD);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(500, 500, 400, 240);
		Cercle cercle1 = new Cercle();
		Cercle cercle2 = new Cercle(new Coordonnees(100, 50));
		Cercle cercle3 = new Cercle(new Coordonnees(), 150);
		Cercle cercle4 = new Cercle(new Coordonnees(180, 35), 235);
		cercle2.setCouleur(Color.BLUE);
		cercle3.setCouleur(Color.GRAY);
		cercle4.setCouleur(Color.RED);

		panD.ajouterVueForme(new VueEllipse(cercle1));
		panD.ajouterVueForme(new VueEllipse(cercle2));
		panD.ajouterVueForme(new VueEllipse(cercle3));
		panD.ajouterVueForme(new VueEllipse(cercle4));

		test.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}

}
