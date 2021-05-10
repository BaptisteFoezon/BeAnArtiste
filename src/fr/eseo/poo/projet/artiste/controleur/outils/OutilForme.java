/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * @author bapti
 *
 */
public abstract class OutilForme extends Outil {
	public OutilForme() {
		super();
	}

	protected abstract VueForme creerVueForme();

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) { // detection du double click
			super.setDebut(new Coordonnees(event.getX(), event.getY()));
			super.setFin(
					new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT, event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
			this.creerVueForme();
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		super.mousePressed(event);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if ((super.getDebut().getAbscisse() != event.getX()) || (super.getDebut().getOrdonnee() != event.getY())) {
			super.setFin(new Coordonnees(event.getX(), event.getY()));
			this.creerVueForme();
		}
	}
}
