/**
 *
 */
package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * @author bapti
 *
 */
public class PanneauDessin extends JPanel {
	public static final Color COULEUR_FOND_PAR_DEFAUT = (UIManager.getColor("Panel.foreground") == Color.white)
			? Color.black
			: Color.white;
	public static final int HAUTEUR_PAR_DEFAUT = 300;
	public static final int LARGEUR_PAR_DEFAUT = 500;
	/**
	 *
	 */
	private static final long serialVersionUID = -833291959346928276L;

	private Color couleurCourante = Color.black;
	private Outil outilCourant;
	private boolean remplissage = false;
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();

	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}

	/**
	 * @param largeur
	 * @param hauteur
	 * @param color
	 */
	public PanneauDessin(int largeur, int hauteur, java.awt.Color color) {
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(color);
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.setModeRemplissage(false);

	}

	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}

	/**
	 * @param outil à associé au panneau
	 */
	public void associerOutil(Outil outil) {
		if (outil != null) {
			this.dissocierOutil(); // on ne veux que un outil � la fois
			this.setOutilCourant(outil);
			outil.setPanneauDessin(this);
			this.addMouseListener(this.getOutilCourant());
			this.addMouseMotionListener(this.getOutilCourant());

		}
	}

	private void dissocierOutil() {
		if (this.getOutilCourant() != null) {
			this.removeMouseListener(this.getOutilCourant());
			this.removeMouseMotionListener(this.getOutilCourant());
			this.getOutilCourant().setPanneauDessin(null);
			this.setOutilCourant(null);
		}
	}

	/**
	 * @return couleur courante
	 */
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}

	/**
	 * @return si forme est rempli
	 */
	public boolean getModeRemplissage() {
		return this.remplissage;
	}

	/**
	 * @return outil courant
	 */
	public Outil getOutilCourant() {
		return this.outilCourant;
	}

	/**
	 * @return List<VueForme>
	 */
	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}

	@Override
	protected void paintComponent(Graphics g2d) {
		super.paintComponent(g2d);
		Graphics2D g2D = (Graphics2D) g2d.create();
		for (int i = 0; i < this.vueFormes.size(); i++) {
			this.vueFormes.get(i).affiche(g2D);
		}
		g2D.dispose();
	}

	/**
	 * @param color a mettre en couleur courante
	 */
	public void setCouleurCourante(Color color) {
		this.couleurCourante = color;
	}

	/**
	 * @param modeRemplissage
	 */
	public void setModeRemplissage(boolean modeRemplissage) {
		this.remplissage = modeRemplissage;
	}

	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}
}
