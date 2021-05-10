package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Coordonnees {

	public final static double ABSCISSE_PAR_DEFAUT = 0.0;
	public final static double ORDONNEE_PAR_DEFAUT = 0.0;

	//
	double abscisse;
	double ordonnee;

	// Constructeurs

	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Coordonnees(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	// methodes

	public double angleVers(Coordonnees coordonnees) {
		double angle = 0;
		if (coordonnees.getOrdonnee() >= this.getOrdonnee()) {
			angle = Math.acos((coordonnees.getAbscisse() - this.getAbscisse()) / this.distanceVers(coordonnees));
		} else {
			angle = -Math.acos((coordonnees.getAbscisse() - this.getAbscisse()) / this.distanceVers(coordonnees));
		}
		return angle;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}

	public void deplacerVers(double abscisse, double ordonnee) {
		setAbscisse(abscisse);
		setOrdonnee(ordonnee);

	}

	public double distanceVers(Coordonnees coord) {
		return Math.sqrt(
				Math.pow(this.abscisse - coord.getAbscisse(), 2) + Math.pow(this.ordonnee - coord.getOrdonnee(), 2));
	}

	public double getAbscisse() {
		return this.abscisse;
	}

	public double getOrdonnee() {
		return this.ordonnee;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

	@Override
	public String toString() {
		Locale currentLocale = Locale.getDefault();
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(currentLocale));
		df.setMinimumFractionDigits(1);
		df.setMaximumFractionDigits(2);
		return "(" + df.format(this.abscisse) + " , " + df.format(this.ordonnee) + ")";
	}

}
