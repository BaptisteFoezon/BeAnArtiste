/**
 *
 */
package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;

/**
 * @author bapti
 *
 */
public class PanneauBarreOutils extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PanneauDessin panneauDessin;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		super();
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(panneauDessin, BoxLayout.Y_AXIS));
		this.initComponents();

	}

	public void initComponents() {

		JButton btnEffacer = new JButton(new ActionEffacer(panneauDessin));
		btnEffacer.setName(ActionEffacer.NOM_ACTION);

		JToggleButton btnLigne = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		btnLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		JToggleButton btnCercle = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		btnCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		JToggleButton btnEllipse = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		btnEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);

		JToggleButton btnSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));

		JButton btnCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
		btnCouleur.setName(ActionChoisirCouleur.NOM_ACTION);

		JCheckBox checkRemplissage = new JCheckBox(new ActionChoisirRemplissage(panneauDessin));
		checkRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);

		ButtonGroup buttonsGrp = new ButtonGroup();

		buttonsGrp.add(btnLigne);
		buttonsGrp.add(btnEllipse);
		buttonsGrp.add(btnCercle);
		buttonsGrp.add(btnSelectionner);

		this.setPreferredSize(new Dimension(120, 320));
		this.setLayout(new GridLayout(20, 1));
		this.add(btnEffacer);
		this.add(btnLigne);
		this.add(btnCercle);
		this.add(btnEllipse);
		this.add(btnSelectionner);
		this.add(btnCouleur);
		this.add(checkRemplissage);
	}
}
