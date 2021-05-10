/**
 *
 */
package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * @author bapti
 *
 */
public class PanneauDessinTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
	}

	public PanneauDessinTest() {
		this.testConstructeurParDefaut();
		this.testConstructeur();
	}

	private void testConstructeur() {
		JFrame jf = new JFrame();
		jf.setTitle("Blues du Businessman");
		PanneauDessin pan2 = new PanneauDessin(500, 500, Color.blue);
		jf.getContentPane().add(pan2);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.pack();
	}

	private void testConstructeurParDefaut() {
		JFrame jf = new JFrame("Etre un Artiste");
		PanneauDessin pan1 = new PanneauDessin();
		jf.getContentPane().add(pan1);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.pack();
	}
}
