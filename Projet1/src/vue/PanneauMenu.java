package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PanneauMenu extends Panneau{

	public PanneauMenu(Fenetre fen){
		super(fen);

		this.setBackground(Color.ORANGE);
	}

	/**
	 * Affiche le menu de base
	 */
	public void menu() {
		removeAll();
		System.out.println("Menu G");
		int largeur = 250;
		int hauteur = 30;

		Font police = new Font("Times New Roman", Font.BOLD, 24);
		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Choisissez une option");
		lbl.setPreferredSize(new Dimension(largeur, 70));

		JButton b1 = new JButton("Ajouter client");
		b1.setPreferredSize(new Dimension(largeur, hauteur));
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.ajoutClient();
			}
		});

		JButton b2 = new JButton("Editer client");
		b2.setPreferredSize(new Dimension(largeur, hauteur));
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.editerClient();
			}
		});
	
		JButton b3 = new JButton("Supprimer client");
		b3.setPreferredSize(new Dimension(largeur, hauteur));
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.supprimerClient();
			}
		});

		JButton b4 = new JButton("Ajouter article");
		b4.setPreferredSize(new Dimension(largeur, hauteur));
		JButton b5 = new JButton("Supprimer article");
		b5.setPreferredSize(new Dimension(largeur, hauteur));
		JButton b6 = new JButton("Sauvegarder et quitter");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				System.out.println("ok");
			}
		});

		b6.setPreferredSize(new Dimension(largeur, hauteur));
		BouttonQuitter b7 = new BouttonQuitter("Quitter sans sauvegarder");
		b7.setPreferredSize(new Dimension(largeur, hauteur));

		if(fen.getClient().isEmpty()){
			b2.setVisible(false);
			b3.setVisible(false);
			b4.setVisible(false);
			b5.setVisible(false);
		}
		else{
			b2.setVisible(true);
			b3.setVisible(true);
			b4.setVisible(true);
			if(fen.isArticle()){
				b5.setVisible(true);
			}else{
				b5.setVisible(false);
			}
		}

		this.setPreferredSize(new Dimension(340, 490));

	    this.setLayout(new GridBagLayout());
		
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
			
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    //La taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    //La marge entre chaque composant (haut, gauche, bas, droit)
	    gbc.insets = new Insets(0, 0, 0, 0);
	    this.add(lbl, gbc);
	    //---------------------------------------------
	    gbc.gridy = 1;
	    gbc.insets.top = 3;
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
