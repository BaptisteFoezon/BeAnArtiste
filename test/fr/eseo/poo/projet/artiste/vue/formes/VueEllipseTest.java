package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	public VueEllipseTest() {
		testAffichage();
	}

	private void testAffichage() {
		JFrame test = new JFrame("Test Affichage Ellipse");
		Container content = test.getContentPane();
		PanneauDessin panD = new PanneauDessin();
		content.add(panD);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(500, 500, 400, 240);
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse(new Coordonnees(50, 100));
		Ellipse ellipse3 = new Ellipse(new Coordonnees(), 100, 50);
		Ellipse ellipse4 = new Ellipse(new Coordonnees(180, 35), 150, 35);
		ellipse2.setCouleur(Color.BLUE);
		ellipse3.setCouleur(Color.GRAY);
		ellipse4.setCouleur(Color.RED);
		ellipse1.setRempli(true);
		ellipse4.setRempli(true);
		panD.ajouterVueForme(new VueEllipse(ellipse1));
		panD.ajouterVueForme(new VueEllipse(ellipse2));
		panD.ajouterVueForme(new VueEllipse(ellipse3));
		panD.ajouterVueForme(new VueEllipse(ellipse4));

		test.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});

	}

}
