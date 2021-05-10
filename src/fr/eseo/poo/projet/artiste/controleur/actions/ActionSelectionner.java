/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * @author bapti
 *
 */
public class ActionSelectionner extends AbstractAction {

	public static final String NOM_ACTION = "Selection";
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	PanneauDessin panneauDessin;

	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(NOM_ACTION)) {
			panneauDessin.associerOutil(new OutilSelectionner());
		}
	}

}
