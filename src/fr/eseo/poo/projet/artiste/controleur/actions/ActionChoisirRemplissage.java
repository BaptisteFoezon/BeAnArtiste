/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * @author bapti
 *
 */
public class ActionChoisirRemplissage extends AbstractAction {

	public static final String NOM_ACTION = "Remplissage";

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private boolean modeRemplissage;
	private PanneauDessin panneauDessin;

	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
		this.modeRemplissage = this.panneauDessin.getModeRemplissage();
		System.out.print("mode remplissage sélectionné");

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.modeRemplissage = !this.modeRemplissage;
		this.panneauDessin.setModeRemplissage(modeRemplissage);

	}

}
