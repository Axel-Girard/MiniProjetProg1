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
	private JLabel lblNom;
	private final JTextField jtfNom;
	private JLabel lblPrenom;
	private final JTextField jtfPrenom;

	private JButton btnRtr;
	private JButton btnVldr;

	private Font police;

	private ActionListener creer;
	private ActionListener editer;

	public PanneauAjoutClient(Fenetre fenetre){
		super(fenetre);

		this.setBackground(Color.GREEN);

		lblNom = new JLabel("Nom : ");
		lblNom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblNom.setHorizontalAlignment(JLabel.RIGHT);

		jtfNom = new JTextField();
		jtfNom.setPreferredSize(new Dimension((largeur/3)*2, hauteur));

		lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblPrenom.setHorizontalAlignment(JLabel.RIGHT);

		jtfPrenom = new JTextField();
		jtfPrenom.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		btnRtr = new JButton("Retour");
		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Valider Edit");
				fen.menu();
			}
		});

		btnVldr = new JButton("Creer client");
		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));

		creer = new ActionListener(){
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
		};
		editer = new ActionListener(){
			public void actionPerformed(ActionEvent event){	}
		};
		

		police = new Font("Times New Roman", Font.BOLD, 24);

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
	 * Affiche le menu de base
	 */
	public void menu() {
		System.out.println("Menu AC");

		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Ajout d'un nouveau client");
		lbl.setPreferredSize(new Dimension(300, 70));

		jtfNom.setText("");
		jtfPrenom.setText("");

		btnVldr.setText("Créer client");
		btnVldr.removeActionListener(editer);
		btnVldr.removeActionListener(creer);
		btnVldr.addActionListener(creer);
	}

	public void editer(final Client c){
		System.out.println("Edition C");
		lbl.setText("Modifier client");

		jtfNom.setText(c.getNom());
		jtfPrenom.setText(c.getPrenom());

		btnVldr.setText("Editer Client");
		btnVldr.removeActionListener(creer);
		btnVldr.removeActionListener(editer);
		editer = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Valider Edit");
				c.setNom(jtfNom.getText());
				c.setPrenom(jtfPrenom.getText());
				fen.menu();
			}
		};
		btnVldr.addActionListener(editer);
	}
}
