/**
 *
 */
package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

/**
 * @author bapti
 *
 */
public class VueLigne extends VueForme {

	private Ligne ligne;

	public VueLigne(Ligne ligne) {
		super(ligne);
		this.ligne = ligne;
	}

	@Override
	public void affiche(Graphics2D g2D) {
		Color couleurCouranteSauvegarde = g2D.getColor();
		int c1X = (int) (Math.round(this.ligne.getC1().getAbscisse())); // convertion de double en int avec arrondi
																		// vers l'entier le plus proche
		int c2X = (int) (Math.round(this.ligne.getC2().getAbscisse()));
		int c1Y = (int) (Math.round(this.ligne.getC1().getOrdonnee()));
		int c2Y = (int) (Math.round(this.ligne.getC2().getOrdonnee()));
		g2D.setColor(this.ligne.getCouleur());
		g2D.drawLine(c1X, c1Y, c2X, c2Y);
		g2D.setColor(couleurCouranteSauvegarde);

	}
}
