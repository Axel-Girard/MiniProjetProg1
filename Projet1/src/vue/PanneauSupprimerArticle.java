package vue;

import javax.swing.JRadioButton;

import controller.Article;
import controller.Client;

@SuppressWarnings("serial")
public class PanneauSupprimerArticle extends PanneauSelectionUnique{
	private Client cli;
	private int numClient; 

	private boolean client;

	PanneauSupprimerArticle(Fenetre fen) {
		super(fen);

		client = true;
		numClient = 0;
	}

	@Override
	public void editer(int cpt) {
		if(client){
			cli = fen.getClients().get(cpt);
			numClient = cpt;
		}
		else{
			cli.getListe().supprimer(cli.getListe().getArticles().get(cpt));
		}
	}

	@Override
	public void miseAJour(){
		pan.removeAll();
		pan.repaint();
		jrb.clear();
		if(client){
			lbl.setText("Choisissez le client à éditer");
			btnVldr.setText("Choisir client");

			for(Client c : fen.getClients()){
				jrb.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
			}
			client = false;
		}
		else{
			lbl.setText("Choisissez le produit");
			btnVldr.setText("Suppr. article");

			for(Article a : cli.getListe().getArticles()){
				jrb.add(new JRadioButton(a.getIntitule() + " " + a.getPrix()));
			}
			client = true;
		}
	}

	@Override
	public void interfaceValider(){
		if(!client){
			menu();
		}
		else{
			fen.getClients().set(numClient, cli);
			fen.menu();
		}
	}

	public void supprimer() {
		lbl.setText("Choisissez le produit");
		btnVldr.setText("Suppr. article");

		super.menu();
	}

	// Accesseurs
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
}
