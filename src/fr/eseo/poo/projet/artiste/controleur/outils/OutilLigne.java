/**
 *
 */
package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

/**
 * @author bapti
 *
 */
public class OutilLigne extends OutilForme {
	public OutilLigne() {
		super();
		this.setDebut(new Coordonnees(Coordonnees.ABSCISSE_PAR_DEFAUT, Coordonnees.ORDONNEE_PAR_DEFAUT));
		this.setFin(new Coordonnees(Coordonnees.ABSCISSE_PAR_DEFAUT, Coordonnees.ORDONNEE_PAR_DEFAUT));
	}

	@Override
	protected VueForme creerVueForme() {
		Ligne ligne = new Ligne();
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			ligne.deplacerVers(super.getDebut().getAbscisse(), super.getDebut().getOrdonnee());
			ligne.getC1();
			ligne.getC2();
		} else {
			ligne.setC1(super.getDebut());
			ligne.setC2(super.getFin());
		}
		ligne.setCouleur(super.getPanneauDessin().getCouleurCourante());
		this.getPanneauDessin().ajouterVueForme(new VueLigne(ligne));
		return (new VueLigne(ligne));
	}

}
