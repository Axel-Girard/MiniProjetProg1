package vue;

import javax.swing.JRadioButton;

import controller.Client;

@SuppressWarnings("serial")
public class PanneauEditerClient extends PanneauEdition{

	PanneauEditerClient(Fenetre fen){
		super(fen);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		System.out.println("Menu EC");
		super.menu();

		lbl.setText("Choisissez le client à éditer");
		btnVldr.setText("Editer Client");
	}

	/**
	 * Met à jour l'interface de selection des clients
	 */
	public void miseAJour(){
		pan.removeAll();
		jrb.clear();
		for(Client c : fen.getClient()){
			jrb.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
		}
	}

	public void editer(int cpt) {
		Client c = fen.getClient().get(cpt);
		fen.editerClient(c);
	}
}
