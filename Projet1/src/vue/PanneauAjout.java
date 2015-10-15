package vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Client;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public abstract class PanneauAjout extends Panneau {

	protected JScrollPane scroll;
	protected JPanel panel;

	protected JButton btnRtr;
	protected JButton btnVldr;

	protected Font police;
	protected ActionListener creer;
	protected ActionListener editer;

	protected GridBagConstraints gbc;

	protected Client c;

	PanneauAjout(final Fenetre fen) {
		super(fen);

		panel = new JPanel();
		scroll = new JScrollPane(panel);

		gbc = new GridBagConstraints();

		actionListener();

		btnRtr = new JButton("Retour");
		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				fen.menu();
			}
		});

		btnVldr = new JButton("Creer client");
		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));

		police = new Font("Times New Roman", Font.BOLD, 24);
	
		this.setPreferredSize(new Dimension(340, 490));
		this.setLayout(new GridBagLayout());

		scroll.setPreferredSize(new Dimension(largeur + 20, hauteur * 10));

		panel.setLayout(new GridBagLayout());
	
		//On positionne la case de départ du composant et sa taille
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		//La marge entre chaque composant (haut, gauche, bas, droit)
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(lbl, gbc);
		//---------------------------------------------
		gbc.gridy = 1;
		gbc.insets.top = 3;
		this.add(scroll, gbc);
		//---------------------------------------------
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(btnRtr, gbc);
	
		gbc.gridx = 1;
		this.add(btnVldr, gbc);
	}

	/**
	 * Initialiser les deux actions ActionListerner
	 */
	public abstract void actionListener();

	/**
	 * Affiche le menu de selection
	 */
	public abstract void menu();

	/**
	 * Edite un client
	 * @param c le Client à éditer
	 */
	public abstract void editer();
	
	/**
	 * Retourne true si str est numérique
	 * @param str chaine à tester
	 * @return true si str est numérique
	 */
	public static boolean isNumeric(String str){
		try{
			Double.parseDouble(str);  
		}
		catch(NumberFormatException nfe){
			return false;  
		}
		return true;  
	}

	// Accesseurs
	public void setC(Client c){
		this.c = c;
	}
}
