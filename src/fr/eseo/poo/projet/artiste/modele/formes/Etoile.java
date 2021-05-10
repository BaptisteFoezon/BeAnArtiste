package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double TAILLE_PAR_DEFAUT = 150;

	private double anglePremiereBranche;
	private List<Coordonnees> coordonneesList;
	private boolean estRempli;
	private double longueurBranche;
	private int nombreBranches;

	public Etoile() {
		this(new Coordonnees(), TAILLE_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
		System.out.print("Constructeur Etoile");
	}

	public Etoile(Coordonnees coord) {
		this(coord, TAILLE_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
		System.out.print("Constructeur Etoile");
	}

	public Etoile(Coordonnees coord, double taille) {
		this(coord, taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
		System.out.print("Constructeur Etoile");
	}

	public Etoile(Coordonnees coord, double taille, int nombreBranches, double anglePremiereBranche,
			double longueurBranche) {
		this.coordonneesList = new ArrayList<Coordonnees>();
		super.setPosition(coord);
		System.out.print("Constructeur Etoile");
		this.setAnglePremiereBranche(ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT);
		this.setLongueurBranche(LONGUEUR_BRANCHE_PAR_DEFAUT);
		this.setNombreBranches(NOMBRE_BRANCHES_PAR_DEFAUT);
		calculeCoords();
	}

	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
		System.out.print("Constructeur Etoile");
	}

	@Override
	public double aire() {
		double rayon = this.getHauteur();
		double a = rayon - rayon * this.longueurBranche;

		return this.nombreBranches * a * rayon * Math.sin(Math.PI / this.getNombreBranches()) / 4;
	}

	private void calculeCoords() {
		if (!this.getCoordonnees().isEmpty())
			this.getCoordonnees().clear();

		double rayon = this.getHauteur() / 2;
		double a = rayon - rayon * this.longueurBranche;
		Coordonnees coord;
		double angle = this.getAnglePremiereBranche();
		Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur() / 2,
				this.getPosition().getOrdonnee() + this.getHauteur() / 2);

		for (int i = 1; i <= 2 * this.getNombreBranches(); i++) {
			if (i % 2 == 1) {
				coord = new Coordonnees(centre.getAbscisse() + rayon * Math.cos(angle),
						centre.getOrdonnee() + rayon * Math.sin(angle));
				angle += Math.PI / this.getNombreBranches();
			} else {
				coord = new Coordonnees(centre.getAbscisse() + a * Math.cos(angle),
						centre.getOrdonnee() + a * Math.sin(angle));
				angle += Math.PI / this.getNombreBranches();
			}
			this.getCoordonnees().add(coord);
		}

	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		double pointAbs = coordonnees.getAbscisse();
		double pointOrd = coordonnees.getOrdonnee();
		double centreAbs = this.getPosition().getAbscisse() + this.getHauteur() / 2;
		double centreOrd = this.getPosition().getOrdonnee() + this.getHauteur() / 2;
		double a = (pointOrd - centreOrd) / (pointAbs - centreAbs);
		double k = pointOrd - a * pointAbs;

		double x = Math.pow(pointAbs - super.getPosition().getAbscisse() - super.getLargeur() / 2, 2);
		double y = Math.pow(pointOrd - super.getPosition().getOrdonnee() - super.getHauteur() / 2, 2);
		double r = Math.pow(super.getLargeur() / 2, 2);

		while (x * r + y * r <= r * r) {

			Coordonnees point = new Coordonnees(pointAbs, pointOrd);
			for (int i = 0; i < this.getCoordonnees().size() - 2; i++) {
				double hauteur = this.getCoordonnees().get(i + 1).getOrdonnee()
						- this.getCoordonnees().get(i).getOrdonnee();
				double largeur = this.getCoordonnees().get(i + 1).getAbscisse()
						- this.getCoordonnees().get(i).getAbscisse();

				if (new Ligne(this.getCoordonnees().get(i), largeur, hauteur).contient(point)) {
					return true;
				}
			}

			double hauteur = this.getCoordonnees().get(this.getCoordonnees().size() - 1).getOrdonnee()
					- this.getCoordonnees().get(0).getOrdonnee();
			double largeur = this.getCoordonnees().get(this.getCoordonnees().size() - 1).getAbscisse()
					- this.getCoordonnees().get(0).getAbscisse();

			if (new Ligne(this.getCoordonnees().get(0), largeur, hauteur).contient(point)) {
				return true;
			}

			if (pointAbs > centreAbs)
				pointAbs += 0.5;
			else
				pointAbs -= 0.5;
			pointOrd = a * pointAbs + k;
			x = Math.pow(pointAbs - super.getPosition().getAbscisse() - super.getLargeur() / 2, 2);
			y = Math.pow(pointOrd - super.getPosition().getOrdonnee() - super.getHauteur() / 2, 2);

		}

		return false;
	}

	@Override
	public boolean estRempli() {
		return this.estRempli;
	}

	public double getAnglePremiereBranche() {
		return this.anglePremiereBranche;
	}

	public List<Coordonnees> getCoordonnees() {
		return this.coordonneesList;
	}

	public double getLongueurBranche() {
		return this.longueurBranche;
	}

	public int getNombreBranches() {
		return this.nombreBranches;
	}

	@Override
	public double perimetre() {
		double rayon = this.getHauteur() / 2;
		double a = rayon - rayon * this.longueurBranche;

		double b = Math.sqrt(a * a + rayon * rayon - 2 * a * rayon * Math.cos(Math.PI / this.getNombreBranches()));

		return 2 * this.nombreBranches * b;
	}

	public void setAnglePremiereBranche(double angle) {
		if (angle < -Math.PI || angle > Math.PI)
			throw new IllegalArgumentException("L'angle doit etre compris entre -pi et +pi");
		this.anglePremiereBranche = angle;
		calculeCoords();
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("la taille d'une étoile ne peut pas être inférieur à 0.");
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
		calculeCoords();
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur < 0)
			throw new IllegalArgumentException("la taille d'une étoile ne peut pas être inférieur à 0.");
		super.setHauteur(largeur);
		super.setLargeur(largeur);
		calculeCoords();
	}

	public void setLongueurBranche(double longueur) {
		if (longueur < 0 || longueur > 1)
			throw new IllegalArgumentException("La longueur des branches doit etre comprise entre 0 et 1.");
		this.longueurBranche = longueur;
		calculeCoords();
	}

	public void setNombreBranches(int nbBranches) {
		if (nbBranches < 3 || nbBranches > 15)
			throw new IllegalArgumentException("Le nombre de branches doit etre compris entre 3 et 15.");
		this.nombreBranches = nbBranches;
		calculeCoords();

	}

	@Override
	public void setPosition(Coordonnees position) {
		super.setPosition(position);
		calculeCoords();

	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
	}

	@Override
	public String toString() {
		final NumberFormat instance = NumberFormat.getNumberInstance();
		instance.setMinimumFractionDigits(1);
		instance.setMaximumFractionDigits(2);
		instance.setGroupingUsed(false);
		String str = "[Etoile";
		if (this.estRempli)
			str += "-Rempli";
		str += "] : ";
		str += "pos " + super.getPosition().toString();
		str += " dim " + instance.format(super.getLargeur()) + " x " + instance.format(super.getHauteur());
		str += " périmètre : " + instance.format(this.perimetre());
		str += " aire : " + instance.format(this.aire());
		str += " couleur = ";
		if (Locale.getDefault().getLanguage().equals("en"))
			str += "R" + super.getCouleur().getRed() + ",G" + super.getCouleur().getGreen() + ",B"
					+ super.getCouleur().getBlue();
		else if (Locale.getDefault().getLanguage().equals("fr"))
			str += "R" + super.getCouleur().getRed() + ",V" + super.getCouleur().getGreen() + ",B"
					+ super.getCouleur().getBlue();
		else
			str += "R" + super.getCouleur().getRed() + ",V" + super.getCouleur().getGreen() + ",B"
					+ super.getCouleur().getBlue();

		return str;
	}

}
