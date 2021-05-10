package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {

	public ActionChoisirCouleurTest() {
		testCouleur();
	}

	private void testCouleur() {
		JFrame test = new JFrame("test Couleur");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panneauDessin);
		test.add(panneauDessin);
		test.add(barreOutils, BorderLayout.EAST);
		test.pack();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(500, 500, 400, 240);
		test.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionChoisirCouleurTest();
			}
		});
	}
}
