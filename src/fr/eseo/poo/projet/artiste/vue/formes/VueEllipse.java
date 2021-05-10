/**
 *
 */
package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

/**
 * @author bapti
 *
 */
public class VueEllipse extends VueForme {

	private Ellipse ellipse;

	/**
	 * @param forme
	 */
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
		this.ellipse = ellipse;
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCouranteSauvegarde = g2d.getColor();
		int x = (int) Math.round(this.ellipse.getPosition().getAbscisse());
		int y = (int) Math.round(this.ellipse.getPosition().getOrdonnee());
		int hauteur = (int) Math.round(this.ellipse.getHauteur());
		int largeur = (int) Math.round(this.ellipse.getLargeur());
		g2d.setColor(this.ellipse.getCouleur());
		if (this.ellipse.estRempli()) {
			g2d.fillOval(x, y, largeur, hauteur);
		}
		g2d.drawOval(x, y, largeur, hauteur);
		g2d.setColor(couleurCouranteSauvegarde);

	}

}
