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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import controller.Client;

@SuppressWarnings("serial")
public class PanneauEditerClient extends Panneau{
	private JPanel pan;
	private ButtonGroup bg;
	private ArrayList<JRadioButton> jrb;
	private JScrollPane scroll;

	PanneauEditerClient(Fenetre fen){
		super(fen);

		this.setBackground(Color.RED);

		pan = new JPanel();
		bg = new ButtonGroup();
		jrb = new ArrayList<JRadioButton>();
		scroll = new JScrollPane(pan);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		removeAll();
		System.out.println("Menu EC");
		int largeur = 250;
		int hauteur = 30;

		Font police = new Font("Times New Roman", Font.BOLD, 24);
		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Edition d'un client");
		lbl.setPreferredSize(new Dimension(300, 70));

		JButton btnRtr = new JButton("Retour");
		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.menu();
			}
		});
		JButton btnVldr = new JButton("Editer client");
		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Client c;
				System.out.println("Edité");
				int cpt = 0;
				for(JRadioButton rb : jrb){
					if(rb.isSelected()){
						c = fen.getClient().get(cpt);
						fen.editerClient(c);
					}
					cpt++;
				}
			}
		});

		this.setPreferredSize(new Dimension(340, 490));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		miseAJourClient();

		for(JRadioButton rb : jrb){
			rb.setPreferredSize(new Dimension(largeur-30, hauteur));
			bg.add(rb);
			pan.add(rb);
		}

		pan.setBackground(Color.CYAN);
		pan.setPreferredSize(new Dimension(largeur-20, hauteur*jrb.size()));

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
		jrb.clear();
		for(Client c : fen.getClient()){
			jrb.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
		}
	}
}
