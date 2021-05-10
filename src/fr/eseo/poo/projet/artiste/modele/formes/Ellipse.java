/**
 *
 */
package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * @author bapti
 *
 */
public class Ellipse extends Forme implements Remplissable {
	private boolean estRempli;
	public double hauteur;
	public double largeur;
	public Coordonnees position;

	public Ellipse() {
		super();
		setRempli(false);
	}

	/**
	 * Constructeur
	 *
	 * @param coordonnee
	 */
	public Ellipse(Coordonnees coordonnee) {
		this(coordonnee, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur
	 *
	 * @param coordonnee
	 * @param largeur
	 * @param hauteur
	 */
	public Ellipse(Coordonnees coordonnee, double largeur, double hauteur) {
		super(coordonnee, largeur, hauteur);
		setRempli(false);

	}

	/**
	 * Constructeur
	 *
	 * @param largeur
	 * @param hauteur
	 */
	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	@Override
	public double aire() {
		return Math.PI * (super.getLargeur()) * (super.getHauteur()) / 4;
	}

	@Override
	public boolean contient(Coordonnees pos) {
		double x = super.getLargeur() / 2;
		double y = super.getHauteur() / 2;
		double a = (super.getCadreMaxX() + super.getCadreMinX()) / 2;
		double b = (super.getCadreMaxY() + super.getCadreMinY()) / 2;
		return Math.pow(((pos.getAbscisse() - a) / x), 2) + Math.pow(((pos.getOrdonnee() - b) / y), 2) <= 1;
	}

	@Override
	public boolean estRempli() {
		return this.estRempli;
	}

	@Override
	public double perimetre() {
		double h = Math.pow(
				(super.getLargeur() / 2 - super.getHauteur() / 2) / (super.getLargeur() / 2 + super.getHauteur() / 2),
				2);
		return (Math.PI * (super.getHauteur() / 2 + super.getLargeur() / 2))
				* (1 + (3 * h / (10 + Math.sqrt(4 - 3 * h))));
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0.0) {
			throw new IllegalArgumentException("Hauteur négative !");
		} else {
			super.setHauteur(hauteur);
		}
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur < 0.0) {
			throw new IllegalArgumentException("Largeur négative!");
		} else {
			super.setLargeur(largeur);
		}
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.estRempli = modeRemplissage;

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
		return "[Ellipse" + remp + "] : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
				+ df.format(this.getPosition().getOrdonnee()) + ") dim " + df.format(super.getLargeur()) + " x "
				+ df.format(super.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire()) + " couleur = R" + this.getCouleur().getRed() + "," + green
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();

	}

}
