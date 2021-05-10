/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

/**
 * @author bapti
 *
 */
public class OutilSelectionner extends Outil {

	private Forme formeSelectrionnee = null;

	public OutilSelectionner() {
		super();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		Coordonnees coord = new Coordonnees(event.getX(), event.getY());

		for (int i = 0; i < this.getPanneauDessin().getVueFormes().size(); i++) {
			if (this.getPanneauDessin().getVueFormes().get(i).getForme().contient(coord))
				this.formeSelectrionnee = this.getPanneauDessin().getVueFormes().get(i).getForme();
		}

		if (this.formeSelectrionnee != null) {
			JOptionPane.showMessageDialog(this.getPanneauDessin(), this.formeSelectrionnee.toString(),
					ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
			System.out.print(this.formeSelectrionnee.toString());
			formeSelectrionnee = null;
		}
	}

}
