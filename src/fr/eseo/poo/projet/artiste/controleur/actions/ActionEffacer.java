/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * @author bapti
 *
 */
public class ActionEffacer extends AbstractAction {

	public static final String NOM_ACTION = "Effacer tout";
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PanneauDessin panneauDessin;

	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int action = JOptionPane.showConfirmDialog(panneauDessin, "Voulez-vous tout effacer ?", NOM_ACTION,
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (action == 0) { // OUI
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();

		}

	}
}
