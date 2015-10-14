package vue;

@SuppressWarnings("serial")
public class PanneauEditerClient extends PanneauSelectionUnique{
	private int cptClient;

	PanneauEditerClient(Fenetre fen){
		super(fen);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		super.menu();

		lbl.setText("Choisissez le client à éditer");
		btnVldr.setText("Editer Client");
	}

	public void editer(int cpt) {
		cptClient = cpt;
		fen.editerClient(fen.getClients().get(cpt));
	}

	@Override
	public void interfaceValider() {
		editer(cptClient);
	}
}
