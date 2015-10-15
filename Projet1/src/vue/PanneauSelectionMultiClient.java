package vue;

import javax.swing.JCheckBox;

import controller.Client;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public abstract class PanneauSelectionMultiClient extends PanneauSelectionMultiple {

	PanneauSelectionMultiClient(Fenetre fen) {
		super(fen);
	}

	public void menu(){
		super.menu();
	}

	@Override
	public void action(int cpt) {
	}

	@Override
	public void miseAJour() {
		pan.removeAll();
		pan.repaint();
		arrayCompo.clear();
		for(Client c : fen.getClients()){
			arrayCompo.add(new JCheckBox(c.getNom() + " " + c.getPrenom()));
		}
	}

}
