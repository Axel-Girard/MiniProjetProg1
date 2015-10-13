package vue;

import java.util.ArrayList;

import javax.swing.JCheckBox;

import modele.BaseDeDonnees;
import controller.Accessoire;
import controller.Client;


@SuppressWarnings("serial")
public class PanneauAjoutArticle extends PanneauSelectionMultiClient{
	private BaseDeDonnees bdd;
	private ArrayList<Client> clients;

	private boolean client;

	PanneauAjoutArticle(Fenetre fen) {
		super(fen);
		clients = new ArrayList<Client>();
		client = true;
	}

	public void menu(){
		if(client){
			System.out.println("Menu SC_AA");
			super.menu();
			lbl.setText("Selection d'un client");
			btnVldr.setText("Selec. client");
			client = false;
		}
		else{
			System.out.println("Menu SA_AA");
			super.menu();
			lbl.setText("Selection d'un article");
			btnVldr.setText("Selec. article");
			client = true;
		}
	}

	@Override
	public void action(int cpt) {
		if(client){
			if(fen.getClient().size() >= cpt + 1){
				clients.add(fen.getClient().get(cpt));
			}
		}
		else{
			for(Client c : clients){
				c.getListe().ajouter(bdd.getAccessoires().get(cpt));
			}
		}
	}

	@Override
	public void miseAJour(){
		if(client){
			super.miseAJour();
		}
		else{
			pan.removeAll();
			pan.repaint();
			arrayCompo.clear();
			for(Accessoire a : bdd.getAccessoires()){
				arrayCompo.add(new JCheckBox(a.getIntitule() + " " + a.getPrix()));
			}
		}
	}
}
