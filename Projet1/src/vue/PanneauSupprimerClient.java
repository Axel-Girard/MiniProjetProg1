package vue;

import java.awt.Color;

@SuppressWarnings("serial")
public class PanneauSupprimerClient extends PanneauSelectionMultiClient{

	PanneauSupprimerClient(Fenetre fen){
		super(fen);

		this.setBackground(Color.DARK_GRAY);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		System.out.println("Menu SC");
		super.menu();
		lbl.setText("Suppression d'un client");
		btnVldr.setText("Suppr. client");
	}

	@Override
	public void action(int cpt) {
		if(!fen.getClient().isEmpty()){
			fen.getClient().remove(fen.getClient().get(cpt));
		}
	}
}
