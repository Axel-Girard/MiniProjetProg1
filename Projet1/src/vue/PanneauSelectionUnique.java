package vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import controller.Client;

@SuppressWarnings("serial")
public abstract class PanneauSelectionUnique extends PanneauSelection{
	protected ButtonGroup bg;
	protected ArrayList<JRadioButton> arrayCompo;

	PanneauSelectionUnique(Fenetre fen) {
		super(fen);

		bg = new ButtonGroup();
		arrayCompo = new ArrayList<JRadioButton>();

		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int cpt = 0;
				for(JRadioButton rb : arrayCompo){
					if(rb.isSelected()){
						editer(cpt);
					}
					cpt++;
				}
				interfaceValider();
			}
		});
	}

	public void menu(){
		super.menu();

		for(JRadioButton rb : arrayCompo){
			rb.setPreferredSize(new Dimension(largeur-30, hauteur));
			bg.add(rb);
			pan.add(rb);
		}

		pan.setPreferredSize(new Dimension(largeur-20, hauteur*arrayCompo.size()));
	}

	/**
	 * Permet de mdifier l'élement sélectionné
	 * @param cpt l'élément à modifier
	 */
	public abstract void editer(int cpt);


	/**
	 * Met à jour l'interface de selection des clients
	 */
	public void miseAJour(){
		pan.removeAll();
		arrayCompo.clear();
		for(Client c : fen.getClients()){
			arrayCompo.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
		}
	}
}
