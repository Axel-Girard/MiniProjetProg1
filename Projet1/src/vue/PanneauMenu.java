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

		JButton btnEdtrClnt = new JButton("Editer client");
		btnEdtrClnt.setPreferredSize(new Dimension(largeur, hauteur));
		btnEdtrClnt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.editerClient();
			}
		});
	
		JButton btnSupprClnt = new JButton("Supprimer client");
		btnSupprClnt.setPreferredSize(new Dimension(largeur, hauteur));
		btnSupprClnt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.supprimerClient();
			}
		});

		JButton btnAjtArtcl = new JButton("Ajouter article");
		btnAjtArtcl.setPreferredSize(new Dimension(largeur, hauteur));
		btnAjtArtcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.ajouterArticle();
			}
		});

		JButton btnSupprArtcl = new JButton("Supprimer article");
		btnSupprArtcl.setPreferredSize(new Dimension(largeur, hauteur));

		JButton btnSauvergarder = new JButton("Sauvegarder et quitter");
		btnSauvergarder.setPreferredSize(new Dimension(largeur, hauteur));
		btnSauvergarder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				System.out.println("A faire en dernier");
			}
		});

		BouttonQuitter btnQuit = new BouttonQuitter("Quitter sans sauvegarder");
		btnQuit.setPreferredSize(new Dimension(largeur, hauteur));

		if(fen.getClient().isEmpty()){
			btnEdtrClnt.setVisible(false);
			btnSupprClnt.setVisible(false);
			btnAjtArtcl.setVisible(false);
			btnSupprArtcl.setVisible(false);
		}
		else{
			btnEdtrClnt.setVisible(true);
			btnSupprClnt.setVisible(true);
			btnAjtArtcl.setVisible(true);
			if(fen.isArticle()){
				btnSupprArtcl.setVisible(true);
			}else{
				btnSupprArtcl.setVisible(false);
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
	    this.add(btnEdtrClnt, gbc);
	    //---------------------------------------------
	    gbc.gridy = 3;
	    this.add(btnSupprClnt, gbc);
	    //---------------------------------------------
	    gbc.gridy = 4;
	    this.add(btnAjtArtcl, gbc);
	    //---------------------------------------------
	    gbc.gridy = 5;
	    this.add(btnSupprArtcl, gbc);
	    //---------------------------------------------
	    gbc.gridy = 6;
	    this.add(btnSauvergarder, gbc);
	    //---------------------------------------------
	    gbc.gridy = 7;
	    this.add(btnQuit, gbc);

	    
	}

	/**
	 * Dessine un objet graphique à chaque fois que le panneau est affiché
	 */
	/*public void paintComponent(Graphics g){
		g.fillOval(20, 20, 75, 75);
	}*/ 
}
