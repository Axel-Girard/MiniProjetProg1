package vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public abstract class PanneauSelectionMultiple extends PanneauSelection{
	protected ArrayList<JCheckBox> arrayCompo;

	PanneauSelectionMultiple(Fenetre fen) {
		super(fen);

		arrayCompo = new ArrayList<JCheckBox>();
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		super.menu();

		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Supprimé");
				int cpt = 0;
				for(JCheckBox cb : arrayCompo){
					if(cb.isSelected()){
						supprimer(cpt);
						cpt--;
					}
					cpt++;
				}
				if(cpt > 0){
					miseAJour();
				}
				fen.menu();
			}
		});

		for(JCheckBox cb : arrayCompo){
			cb.setPreferredSize(new Dimension(largeur-30, hauteur));
			pan.add(cb);
		}

		pan.setPreferredSize(new Dimension(largeur-20, hauteur*arrayCompo.size()));
	}

	/**
	 * Supprime l'élément sélectionné
	 * @param cpt l'élément à supprimer
	 */
	public abstract void supprimer(int cpt);
}
