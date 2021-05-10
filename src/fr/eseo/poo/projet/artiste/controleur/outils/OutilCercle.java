/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * @author bapti
 *
 */
public class OutilCercle extends OutilForme {

	private Coordonnees debut;

	public OutilCercle() {
		super();
	}

	@Override
	protected VueForme creerVueForme() {
		double x1 = super.getDebut().getAbscisse();
		double x2 = super.getFin().getAbscisse();
		double y1 = super.getDebut().getOrdonnee();
		double y2 = super.getFin().getOrdonnee();
		double largeur = Math.abs(x2 - x1);
		double hauteur = Math.abs(y2 - y1);
		double max = Math.max(largeur, hauteur);
		this.debut = getDebut();
		// Conditions
		if (y2 < y1) {
			if (x2 < x1) {
				if (largeur > hauteur) {
					this.debut = new Coordonnees(x2, y1 - max);
				} else {
					this.debut = new Coordonnees(x1 - max, y2);
				}
			}
			if (x2 > x1) {
				this.debut = new Coordonnees(x1, y1 - max);
			}
		} else {
			if (x2 < x1) {
				if (largeur > hauteur) {
					this.debut = new Coordonnees(x2, y1);
				} else {
					this.debut = new Coordonnees(x1 - max, y1);
				}
			}
		}

		Cercle c1 = new Cercle(debut, max);
		c1.setRempli(getPanneauDessin().getModeRemplissage());
		c1.setCouleur(getPanneauDessin().getCouleurCourante());
		VueCercle vueCercle = new VueCercle(c1);
		this.getPanneauDessin().ajouterVueForme(vueCercle);
		return (vueCercle);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) { // detection du double click
			super.setDebut(new Coordonnees(event.getX(), event.getY()));
			super.setFin(
					new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT, event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
			this.creerVueForme();
		}
	}

}
