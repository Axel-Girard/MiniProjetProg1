package vue;

@SuppressWarnings("serial")
public class PanneauSupprimerClient extends PanneauSelectionMultiClient{

	PanneauSupprimerClient(Fenetre fen){
		super(fen);
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
		if(!fen.getClients().isEmpty()){
			fen.getClients().remove(fen.getClients().get(cpt));
		}
	}
}
