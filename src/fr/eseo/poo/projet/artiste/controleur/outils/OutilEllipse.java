/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * @author bapti
 *
 */
public class OutilEllipse extends OutilForme {
	private Coordonnees debut;

	public OutilEllipse() {
		super();
	}

	@Override
	protected VueForme creerVueForme() {
		double largeur = Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse());
		double hauteur = Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee());
		if (super.getFin().getAbscisse() < super.getDebut().getAbscisse()
				&& super.getFin().getOrdonnee() < super.getDebut().getOrdonnee()) {
			this.debut = getFin();

		} else if (super.getFin().getAbscisse() < super.getDebut().getAbscisse()
				&& super.getFin().getOrdonnee() > super.getDebut().getOrdonnee()) {
			this.debut = new Coordonnees(super.getFin().getAbscisse(), super.getFin().getOrdonnee() - hauteur);
		} else if (super.getFin().getAbscisse() > super.getDebut().getAbscisse()
				&& super.getFin().getOrdonnee() < super.getDebut().getOrdonnee()) {
			this.debut = new Coordonnees(super.getDebut().getAbscisse(), super.getDebut().getOrdonnee() - hauteur);
		} else {
			this.debut = getDebut();
		}
		Ellipse ellipse = new Ellipse(debut, largeur, hauteur);
		ellipse.setCouleur(super.getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		this.getPanneauDessin().ajouterVueForme(vueEllipse);
		return vueEllipse;
	}

}
