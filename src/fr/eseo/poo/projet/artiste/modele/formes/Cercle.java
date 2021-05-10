/**
 *
 */
package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * @author bapti
 *
 */

public class Cercle extends Ellipse {

	/**
	 *
	 */
	public Cercle() {
		super();
	}

	/**
	 * @param coordonnee
	 */
	public Cercle(Coordonnees coordonnee) {
		super(coordonnee);
	}

	/* constructeur */
	/**
	 * @param coordonnee
	 * @param taille
	 */
	public Cercle(Coordonnees coordonnee, double taille) {
		super(coordonnee, taille, taille);
		if (taille < 0) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @param taille
	 */
	public Cercle(double taille) {
		super(taille, taille);
	}

	@Override
	public double perimetre() {
		return Math.PI * super.getHauteur();
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException();
		} else {
			super.setHauteur(hauteur);
			super.setLargeur(hauteur);
		}

	}

	@Override
	public void setLargeur(double largeur) {
		this.setHauteur(largeur);
	}

	@Override
	public String toString() {
		String remp = (this.estRempli()) ? "-Rempli" : "";
		String green;
		Locale currentLocale = Locale.getDefault();
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(currentLocale));
		df.setMinimumFractionDigits(1);
		df.setMaximumFractionDigits(2);
		if (currentLocale.getLanguage().equals(new Locale("fr").getLanguage())) {
			green = "V";
		} else {
			green = "G";
		}
		return "[Cercle" + remp + "] : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
				+ df.format(this.getPosition().getOrdonnee()) + ") dim " + df.format(super.getHauteur()) + " x "
				+ df.format(super.getLargeur()) + " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire()) + " couleur = R" + this.getCouleur().getRed() + "," + green
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();
	}

}
