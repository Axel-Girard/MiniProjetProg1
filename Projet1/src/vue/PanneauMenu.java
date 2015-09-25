package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauMenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel lbl;

	public PanneauMenu(){
		this.setBackground(Color.ORANGE);
		this.setLayout(new GridLayout(3, 2));

		this.setVisible(true);

		lbl = new JLabel("Text");
	}

	/**
	 * Affiche le menu de base
	 */
	public void menu() {
		JButton b1 = new JButton("Ajouter client");
		JButton b2 = new JButton("Editer client");
		JButton b3 = new JButton("Supprimer client");
		JButton b4 = new JButton("Ajouter article");
		JButton b5 = new JButton("Supprimer article");
		JButton b6 = new JButton("Sauvegarder et quitter");
		JButton b7 = new JButton("Quitter sans sauvegarder");

		this.setPreferredSize(new Dimension(340, 490));
		this.add(lbl);
		lbl.setText("Choisissez une option");

	    this.setLayout(new GridBagLayout());
		
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
			
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    //La taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    this.add(lbl, gbc);
	    //---------------------------------------------
	    gbc.gridy = 1;
	    this.add(b1, gbc);
	    //---------------------------------------------
	    gbc.gridy = 2;
	    this.add(b2, gbc);
	    //---------------------------------------------
	    gbc.gridy = 3;
	    this.add(b3, gbc);
	    //---------------------------------------------
	    gbc.gridy = 4;
	    this.add(b4, gbc);
	    //---------------------------------------------
	    gbc.gridy = 5;
	    this.add(b5, gbc);
	    //---------------------------------------------
	    gbc.gridy = 6;
	    this.add(b6, gbc);
	    //---------------------------------------------
	    gbc.gridy = 7;
	    this.add(b7, gbc);
	}

	/**
	 * Dessine un objet graphique à chaque fois que le panneau est affiché
	 */
	/*public void paintComponent(Graphics g){
		g.fillOval(20, 20, 75, 75);
	}*/ 
}
