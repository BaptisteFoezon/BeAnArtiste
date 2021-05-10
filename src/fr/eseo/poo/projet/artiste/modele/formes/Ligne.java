package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	public static final double EPSILON = 0.5;
	public Coordonnees c1;
	public Coordonnees c2;
	public double hauteur;
	public double largeur;
	public Coordonnees position;

	public Ligne() {
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);

	}

	public Ligne(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);

	}

	/**
	 * @param position
	 * @param largeur
	 * @param hauteur
	 */
	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		this.hauteur = hauteur;
		this.largeur = largeur;

	}

	/**
	 * @param largeur
	 * @param hauteur
	 */
	public Ligne(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);

	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coord) {
		return Math.abs(this.getC1().distanceVers(coord)) + Math.abs(coord.distanceVers(this.getC2()))
				- Math.abs(this.getC1().distanceVers(this.getC2())) < EPSILON ? true : false;
	}

	public Coordonnees getC1() {
		return super.getPosition();
	}

	public Coordonnees getC2() {
		double c2abs = super.getPosition().getAbscisse() + super.getLargeur();
		double c2ord = super.getPosition().getOrdonnee() + super.getHauteur();
		return new Coordonnees(c2abs, c2ord);

	}

	public double getLongueur() {
		return Math.sqrt(Math.pow(this.getLargeur(), 2) + Math.pow(this.getHauteur(), 2));
	}

	@Override
	public double perimetre() {
		return Math.sqrt(Math.pow(super.getLargeur(), 2) + Math.pow(super.getHauteur(), 2));
	}

	public void setC1(Coordonnees coord) {
		Coordonnees c2 = this.getC2(); // On garde les coordonnees de la position de C2
		super.setPosition(coord);
		super.setLargeur(c2.getAbscisse() - super.getPosition().getAbscisse());
		super.setHauteur(c2.getOrdonnee() - super.getPosition().getOrdonnee());
	}

	public void setC2(Coordonnees coord) {
		super.setLargeur(coord.getAbscisse() - super.getPosition().getAbscisse());
		super.setHauteur(coord.getOrdonnee() - super.getPosition().getOrdonnee());
	}

	@Override
	public String toString() {
		double angleN = (Math.toDegrees(this.getC1().angleVers(getC2())) < 0)
				? 360 + Math.toDegrees(this.getC1().angleVers(getC2()))
				: Math.toDegrees(this.getC1().angleVers(getC2()));

		Locale currentLocale = Locale.getDefault();
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(currentLocale));
		df.setMinimumFractionDigits(1);
		df.setMaximumFractionDigits(2);
		String green = (currentLocale.getLanguage().equals(new Locale("fr").getLanguage())) ? "V" : "G";

		return "[Ligne] c1 : (" + df.format(this.getC1().getAbscisse()) + " , " + df.format(this.getC1().getOrdonnee())
				+ ") c2 : (" + df.format(this.getC2().getAbscisse()) + " , " + df.format(this.getC2().getOrdonnee())
				+ ") longueur : " + df.format(this.getLongueur()) + " angle : " + df.format(angleN) + "° couleur = R"
				+ this.getCouleur().getRed() + "," + green + this.getCouleur().getGreen() + ",B"
				+ this.getCouleur().getBlue();

	}

}
