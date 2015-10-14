package vue;

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
	}

	/**
	 * Affiche le menu de base
	 */
	public void menu() {
		removeAll();
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

		JButton btnPayer = new JButton("Give me my money !");
		btnPayer.setPreferredSize(new Dimension(largeur, hauteur));
		btnPayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.payer();
			}
		});
		
		JButton btnSupprArtcl = new JButton("Supprimer article");
		btnSupprArtcl.setPreferredSize(new Dimension(largeur, hauteur));
		btnSupprArtcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.supprimerArticle();
			}
		});

		JButton btnSauvergarder = new JButton("Sauvegarder et quitter");
		btnSauvergarder.setPreferredSize(new Dimension(largeur, hauteur));
		btnSauvergarder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				System.out.println("A faire en dernier");
			}
		});

		BouttonQuitter btnQuit = new BouttonQuitter("Quitter sans sauvegarder");
		btnQuit.setPreferredSize(new Dimension(largeur, hauteur));

		if(fen.getClients().isEmpty()){
			btnEdtrClnt.setVisible(false);
			btnSupprClnt.setVisible(false);
			btnAjtArtcl.setVisible(false);
			btnPayer.setVisible(false);
			btnSupprArtcl.setVisible(false);
		}
		else{
			btnEdtrClnt.setVisible(true);
			btnSupprClnt.setVisible(true);
			btnAjtArtcl.setVisible(true);
			if(fen.isArticle()){
				btnPayer.setVisible(true);
				btnSupprArtcl.setVisible(true);
			}else{
				btnPayer.setVisible(false);
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
	    gbc.gridy++;
	    gbc.insets.top = 3;
	    this.add(b1, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnEdtrClnt, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnSupprClnt, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnAjtArtcl, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnPayer, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnSupprArtcl, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnSauvergarder, gbc);
	    //---------------------------------------------
	    gbc.gridy++;
	    this.add(btnQuit, gbc);
	}
}
