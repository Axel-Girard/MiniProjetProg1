package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				client = true;
			}
		});
	}

	public void menu(){
		if(client){
			super.menu();

			lbl.setText("Choisissez le client à éditer");
			btnVldr.setText("Choisir client");
		}
		else{
			super.menu();

			lbl.setText("Choisissez le produit");
			btnVldr.setText("Suppr. article");
		}
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
		arrayCompo.clear();
		if(client){
			for(Client c : fen.getClients()){
				arrayCompo.add(new JRadioButton(c.getNom() + " " + c.getPrenom()));
			}
		}
		else{
			for(Article a : cli.getListe().getArticles()){
				arrayCompo.add(new JRadioButton(a.getIntitule() + " " + a.getPrix()));
			}
		}
	}

	@Override
	public void interfaceValider(){
		if(client){
			client = false;
			menu();
		}
		else{
			client = true;
			fen.getClients().set(numClient, cli);
			fen.menu();
		}
	}

	// Accesseurs
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
}
