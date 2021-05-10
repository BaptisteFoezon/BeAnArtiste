package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;

public abstract class VueForme {

	protected final Forme forme;

	public VueForme(Forme forme) {
		this.forme = forme;
	}

	public abstract void affiche(java.awt.Graphics2D g2D);

	public Forme getForme() {
		return this.forme;
	}
}
