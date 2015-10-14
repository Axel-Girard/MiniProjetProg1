package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import modele.BaseDeDonnees;
import controller.Accessoire;
import controller.Client;

@SuppressWarnings("serial")
public class PanneauAjoutArticle extends PanneauSelectionMultiClient{
	private BaseDeDonnees bdd;
	private ArrayList<Client> clients;
	private ArrayList<Integer> tableauEdition;

	// vrai s'il faut selectionner un client faux s'il faut selelection un article 
	private boolean client;

	PanneauAjoutArticle(Fenetre fen) {
		super(fen);

		bdd = BaseDeDonnees.getInstance();
		client = true;

		btnRtr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				client = true;
			}
		});
	}

	public void menu(){
		super.menu();
		if(client){
			clients = new ArrayList<Client>();
			tableauEdition = new ArrayList<Integer>();

			clients = fen.getClients();

			lbl.setText("Selection d'un client");
			btnVldr.setText("Selec. client");
		}
		else{
			lbl.setText("Selection d'un article");
			btnVldr.setText("Selec. article");
		}
	}

	@Override
	public void action(int cpt) {
		if(client){
			if(fen.getClients().size() >= cpt + 1){
				tableauEdition.add(cpt);
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

	@Override
	public void interfaceValider(){
		if(client){
			client = false;
			menu();
		}
		else{
			client = true;
			for(Integer i : tableauEdition){
				fen.getClients().get(i).setListe(clients.get(i).getListe());
			}
			fen.menu();
		}
	}
}
