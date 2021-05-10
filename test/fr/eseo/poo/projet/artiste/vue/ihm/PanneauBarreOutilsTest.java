package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreOutilsTest {

	public PanneauBarreOutilsTest() {
		testBarreOutils();
	}

	private void testBarreOutils() {
		JFrame test = new JFrame("test Barre Outils");
		PanneauDessin panD = new PanneauDessin();

		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panD);

		test.add(panD);
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
				new PanneauBarreOutilsTest();
			}
		});
	}

}
