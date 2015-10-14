package vue;

import controller.Client;
import controller.ListeArticles;

@SuppressWarnings("serial")
public class PanneauPayement extends PanneauSelectionUnique{

	PanneauPayement(Fenetre fen) {
		super(fen);
	}

	@Override
	public void menu(){
		super.menu();

		lbl.setText("Choisissez le client qui va payer !");
		btnVldr.setText("Get pognon");	
	}

	public void payer(Client c){
		System.out.println(c.getTotalAchat());
		c.setListe(new ListeArticles());
	}

	@Override
	public void editer(int cpt) {
		fen.fairePayer(fen.getClients().get(cpt));
		fen.menu();
	}

	@Override
	public void interfaceValider() {
		fen.menu();
	}
}
