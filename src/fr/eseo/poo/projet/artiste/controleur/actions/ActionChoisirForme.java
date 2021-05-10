/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * @author bapti
 *
 */
public class ActionChoisirForme extends AbstractAction {
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_LIGNE = "Ligne";
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PanneauDessin panneauDessin;

	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils, String nomAction) {
		super(nomAction);
		this.panneauDessin = panneauDessin;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case NOM_ACTION_LIGNE:
			panneauDessin.associerOutil(new OutilLigne());
			panneauDessin.repaint();
			break;

		case NOM_ACTION_CERCLE:
			panneauDessin.associerOutil(new OutilCercle());
			panneauDessin.repaint();
			break;
		case NOM_ACTION_ELLIPSE:
			panneauDessin.associerOutil(new OutilEllipse());
			panneauDessin.repaint();
			break;
		}
	}
}
