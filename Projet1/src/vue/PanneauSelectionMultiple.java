package vue;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public abstract class PanneauSelectionMultiple extends PanneauSelection {

	protected ArrayList<JCheckBox> arrayCompo;

	PanneauSelectionMultiple(Fenetre fen) {
		super(fen);

		arrayCompo = new ArrayList<JCheckBox>();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.insets.top = 3;

		pan.setLayout(new GridBagLayout());

		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int cpt = 0;
				for(JCheckBox cb : arrayCompo){
					if(cb.isSelected()){
						action(cpt);
					}
					cpt++;
				}
				if(cpt > 0){
					miseAJour();
				}
				interfaceValider();
			}
		});
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		super.menu();

		for(JCheckBox cb : arrayCompo){
			cb.setPreferredSize(new Dimension(largeur-30, hauteur));
			gbc.gridy++;
			pan.add(cb, gbc);
		}
	}

	/**
	 * Réaliser une action sur l'élément sélectionné
	 * @param cpt l'élément à modifier
	 */
	public abstract void action(int cpt);
}
