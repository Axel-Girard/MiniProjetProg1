package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public abstract class Panneau extends JPanel{

	protected JLabel lbl;
	protected Fenetre fen;
	protected int largeur = 250;
	protected int hauteur = 30;

	Panneau(Fenetre fen){
		this.fen = fen;
		lbl = new JLabel();

		this.setVisible(true);
	}
}
