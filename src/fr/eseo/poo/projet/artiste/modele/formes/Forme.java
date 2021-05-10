package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable {

	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	public static final double LARGEUR_PAR_DEFAUT = 150;

	private Color couleur;
	private double hauteur;
	// Variables d'instance
	private double largeur;
	private Coordonnees position;

	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);

	}

	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	// Constructeur(s)
	/**
	 * @param position
	 * @param largeur
	 * @param hauteur
	 */
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.setHauteur(hauteur);
		this.setLargeur(largeur);
		this.position = position;
		this.couleur = Forme.COULEUR_PAR_DEFAUT;

	}

	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);

	}

	/* M�thodes */
	// Accesseurs et mutateurs

	public abstract double aire();

	public abstract boolean contient(Coordonnees coordonnee);

	public void deplacerDe(double deltaX, double deltaY) {
		this.position.deplacerDe(deltaX, deltaY);
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}

	public double getAbscisse() {
		return this.getPosition().getAbscisse();
	}

	public double getCadreMaxX() {
		if (this.getPosition().getAbscisse() > this.getPosition().getAbscisse() + this.getLargeur()) {
			return this.getPosition().getAbscisse();
		} else {
			return this.getPosition().getAbscisse() + this.getLargeur();
		}
	}

	public double getCadreMaxY() {
		if (this.getPosition().getOrdonnee() > this.getPosition().getOrdonnee() + this.getHauteur()) {
			return this.getPosition().getOrdonnee();
		} else {
			return this.getPosition().getOrdonnee() + this.getHauteur();
		}
	}

	public double getCadreMinX() {
		if (this.getPosition().getAbscisse() < this.getPosition().getAbscisse() + this.getLargeur()) {
			return this.getPosition().getAbscisse();
		} else {
			return this.getPosition().getAbscisse() + this.getLargeur();
		}
	}

	/* Autres m�thodes */
	// M�thodes de classe

	public double getCadreMinY() {
		if (this.getPosition().getOrdonnee() < this.getPosition().getOrdonnee() + this.getHauteur()) {
			return this.getPosition().getOrdonnee();
		} else {
			return this.getPosition().getOrdonnee() + this.getHauteur();
		}
	}

	@Override
	public Color getCouleur() {
		return this.couleur;
	}

	public double getHauteur() {
		return this.hauteur;
	}

	public double getLargeur() {
		return this.largeur;
	}

	public double getOrdonnee() {
		return this.getPosition().getOrdonnee();
	}

	public Coordonnees getPosition() {
		return this.position;
	}

	public abstract double perimetre();

	public void setAbscisse(double abscisse) {
		this.getPosition().setAbscisse(abscisse);
	}

	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public void setOrdonnee(double y) {
		this.getPosition().setOrdonnee(y);
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] " + "pos : " + "(" + this.getPosition().getAbscisse() + ","
				+ this.getPosition().getOrdonnee() + ") dim : " + this.getLargeur() + "x" + this.getHauteur() + "\n"
				+ "p�rim�tre : " + this.perimetre() + " aire : " + this.aire();
	}
}
