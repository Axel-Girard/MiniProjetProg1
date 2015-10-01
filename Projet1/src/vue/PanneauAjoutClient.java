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
import javax.swing.JTextField;

import controller.Client;

@SuppressWarnings("serial")
public class PanneauAjoutClient extends Panneau{

	public PanneauAjoutClient(Fenetre fen){
		super(fen);

		this.setBackground(Color.GREEN);
	}

	/**
	 * Affiche le menu de base
	 */
	public void menu() {
		removeAll();
		System.out.println("Menu AC");
		int largeur = 250;
		int hauteur = 30;

		Font police = new Font("Times New Roman", Font.BOLD, 24);
		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Ajout d'un nouveau client");
		lbl.setPreferredSize(new Dimension(300, 70));

		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblNom.setHorizontalAlignment(JLabel.RIGHT);
		final JTextField jtfNom = new JTextField();
		jtfNom.setPreferredSize(new Dimension((largeur/3)*2, hauteur));
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblPrenom.setHorizontalAlignment(JLabel.RIGHT);
		final JTextField jtfPrenom = new JTextField();
		jtfPrenom.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		JButton btnRtr = new JButton("Retour");
		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.menu();
			}
		});
		JButton btnVldr = new JButton("Creer client");
		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Valider");
				if(jtfNom.getText() != null){
					System.out.println("nom OK");
					if(jtfPrenom.getText() != null){
						System.out.println("prenom OK");
						fen.getClient().add(new Client(jtfNom.getText(), jtfPrenom.getText()));
						fen.menu();
					}
				}
			}
		});

		this.setPreferredSize(new Dimension(340, 490));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	
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
		gbc.gridwidth = 1;
		gbc.insets.top = 3;
		this.add(lblNom, gbc);

		gbc.gridx = 1;
		this.add(jtfNom, gbc);
		//---------------------------------------------
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(lblPrenom, gbc);

		gbc.gridx = 1;
		this.add(jtfPrenom, gbc);
		//---------------------------------------------
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(btnRtr, gbc);

		gbc.gridx = 1;
		this.add(btnVldr, gbc);
	}

	/**
	 * Dessine un objet graphique à chaque fois que le panneau est affiché
	 */
	/*public void paintComponent(Graphics g){
		g.fillOval(20, 20, 75, 75);
	}*/ 
}
