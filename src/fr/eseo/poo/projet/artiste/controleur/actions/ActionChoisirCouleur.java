/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * @author bapti
 *
 */
public class ActionChoisirCouleur extends AbstractAction {

	public static final String NOM_ACTION = "Couleur";
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PanneauDessin panneauDessin;

	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Color couleur = JColorChooser.showDialog(panneauDessin, NOM_ACTION, panneauDessin.getCouleurCourante());
		if (couleur != null) {
			panneauDessin.setCouleurCourante(couleur);
		}

	}

}
