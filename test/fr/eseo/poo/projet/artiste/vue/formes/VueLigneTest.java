package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
	public VueLigneTest() {
		testAffichage();
	}

	private void testAffichage() {
		JFrame test = new JFrame("Teste Ligne");
		Container content = test.getContentPane();
		PanneauDessin panD = new PanneauDessin();
		content.add(panD);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(500, 500, 400, 240);

		Ligne ligne1 = new Ligne(new Coordonnees(40, 50), 50, 100);
		Ligne ligne2 = new Ligne(new Coordonnees(100, 159), 10, -66);
		Ligne ligne3 = new Ligne(new Coordonnees(340, 250), 300, 20);
		ligne1.setCouleur(Color.BLUE);
		ligne2.setCouleur(Color.GRAY);
		ligne3.setCouleur(Color.RED);

		panD.ajouterVueForme(new VueLigne(ligne1));
		panD.ajouterVueForme(new VueLigne(ligne2));
		panD.ajouterVueForme(new VueLigne(ligne3));

		test.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
	}

}
