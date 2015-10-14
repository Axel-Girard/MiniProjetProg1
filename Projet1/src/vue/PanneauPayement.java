package vue;

import javax.swing.JLabel;

import controller.Client;
import controller.ListeArticles;

@SuppressWarnings("serial")
public class PanneauPayement extends PanneauSelectionUnique{
	private float client;
	private String nom;

	private JLabel lblPrix = new JLabel();

	PanneauPayement(Fenetre fen) {
		super(fen);
	}

	@Override
	public void menu(){
		super.menu();

		lbl.setText("Choisissez le client");
		btnVldr.setText("Get pognon !");

		lblPrix.setVisible(false);

		scroll.add(lblPrix);
	}

	public void payer(Client c){
		c.setListe(new ListeArticles());
	}

	@Override
	public void editer(int cpt) {
		client = fen.getClients().get(cpt).getTotalAchat();
		nom = fen.getClients().get(cpt).getNom() + " ";
		nom += fen.getClients().get(cpt).getPrenom();
		fen.fairePayer(fen.getClients().get(cpt));
	}

	@Override
	public void interfaceValider() {
		lblPrix.setVisible(true);
		lblPrix.setText(nom + " : " +String.valueOf(client));
	}
}
