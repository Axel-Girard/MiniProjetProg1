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
	protected ArrayList<JRadioButton> jrb;

	PanneauSelectionUnique(Fenetre fen) {
		super(fen);

		bg = new ButtonGroup();
		jrb = new ArrayList<JRadioButton>();
	}

	public void menu(){
		super.menu();

		btnVldr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Edité");
				int cpt = 0;
				for(JRadioButton rb : jrb){
					if(rb.isSelected()){
						editer(cpt);
					}
					cpt++;
				}
			}
		});

		miseAJour();

		for(JRadioButton rb : jrb){
			rb.setPreferredSize(new Dimension(largeur-30, hauteur));
			bg.add(rb);
			pan.add(rb);
		}

		pan.setPreferredSize(new Dimension(largeur-20, hauteur*jrb.size()));
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
		jrb.clear();
		for(Client c : fen.getClients()){
			jrb.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
		}
	}
}
