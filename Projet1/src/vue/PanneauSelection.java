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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public abstract class PanneauSelection extends Panneau{
	protected JPanel pan;
	protected JScrollPane scroll;
	protected JButton btnVldr;
	protected JButton btnRtr;
	protected GridBagConstraints gbc;

	PanneauSelection(Fenetre fen) {
		super(fen);

		pan = new JPanel();
		scroll = new JScrollPane(pan);
		btnVldr = new JButton();
		btnRtr = new JButton("Retour");
		gbc = new GridBagConstraints();
	}

	public void menu(){
		removeAll();

		Font police = new Font("Times New Roman", Font.BOLD, 24);
		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setPreferredSize(new Dimension(300, 70));

		btnRtr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				fen.menu();
			}
		});

		btnVldr.setPreferredSize(new Dimension(largeur/2, hauteur));
		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				interfaceValider();
			}
		});

		this.setPreferredSize(new Dimension(340, 490));
		this.setLayout(new GridBagLayout());

		miseAJour();

		scroll.setPreferredSize(new Dimension(largeur + 20, hauteur * 8));

		//On positionne la case de départ du composant et sa taille
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		//La marge entre chaque composant (haut, gauche, bas, droit)
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(lbl, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.insets.top = 3;
		this.add(scroll, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		this.add(btnRtr, gbc);

		gbc.gridx = 1;
		this.add(btnVldr, gbc);
	}

	/**
	 * Met à jour l'interface de selection
	 */
	public abstract void miseAJour();

	/**
	 * Détermine l'interface appellée lors de la validation
	 */
	public abstract void interfaceValider();
}
