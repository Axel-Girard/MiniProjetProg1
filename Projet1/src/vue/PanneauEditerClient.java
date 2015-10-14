package vue;

@SuppressWarnings("serial")
public class PanneauEditerClient extends PanneauSelectionUnique{

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

	public void editer(int cpt) {
		fen.editerClient(fen.getClients().get(cpt));
	}
}
