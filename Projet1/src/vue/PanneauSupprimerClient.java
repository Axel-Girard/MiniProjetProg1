package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Client;

@SuppressWarnings("serial")
public class PanneauSupprimerClient extends Panneau{
	private JPanel pan;
	private ArrayList<JCheckBox> jcb;
	private JScrollPane scroll;

	PanneauSupprimerClient(Fenetre fen){
		super(fen);

		this.setBackground(Color.DARK_GRAY);

		pan = new JPanel();
		jcb = new ArrayList<JCheckBox>();
		scroll = new JScrollPane(pan);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		removeAll();
		System.out.println("Menu SC");
		int largeur = 250;
		int hauteur = 30;

		Font police = new Font("Times New Roman", Font.BOLD, 24);
		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Suppression d'un client");
		lbl.setPreferredSize(new Dimension(300, 70));

		JButton btnRtr = new JButton("Retour");
		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.menu();
			}
		});

		JButton btnVldr = new JButton("Supprimer client(s)");
		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Supprimé");
				int cpt = 0;
				for(JCheckBox rb : jcb){
					if(rb.isSelected()){
						fen.getClient().remove(fen.getClient().get(cpt));
						cpt--;
					}
					cpt++;
				}
				fen.menu();
			}
		});

		this.setPreferredSize(new Dimension(340, 490));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		miseAJourClient();

		for(JCheckBox rb : jcb){
			rb.setPreferredSize(new Dimension(largeur-30, hauteur));
			pan.add(rb);
		}

		pan.setBackground(Color.CYAN);
		pan.setPreferredSize(new Dimension(largeur-20, hauteur*jcb.size()));

		scroll.setBackground(Color.GRAY);
		scroll.setPreferredSize(new Dimension(largeur, hauteur*5));

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
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		this.add(btnRtr, gbc);

		gbc.gridx = 1;
		this.add(btnVldr, gbc);
	}

	/**
	 * Met à jour l'interface de selection des clients
	 */
	public void miseAJourClient(){
		pan.removeAll();
		jcb.clear();
		for(Client c : fen.getClient()){
			jcb.add(new JCheckBox(c.getNom() + " " + c.getPrenom()));
		}
	}
}
