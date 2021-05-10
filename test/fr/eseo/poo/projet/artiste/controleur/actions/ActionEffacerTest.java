package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest {

	public ActionEffacerTest() {
		effacerTest();
	}

	private void effacerTest() {
		JFrame test = new JFrame("Test ActionEffacer");
		PanneauDessin panneauDessin = new PanneauDessin();
		OutilLigne outil = new OutilLigne();
		panneauDessin.associerOutil(outil);
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panneauDessin);
		test.add(panneauDessin);
		test.add(barreOutils, BorderLayout.EAST);
		test.pack();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(500, 500, 400, 240);
		// outil.setPanneauDessin(panneauDessin);
		test.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionEffacerTest();
			}
		});
	}

}
