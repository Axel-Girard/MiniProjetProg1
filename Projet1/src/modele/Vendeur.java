package modele;

import java.util.ArrayList;

import vue.Fenetre;
import controller.Client;
import controller.Telephone;

public class Vendeur {
	private ArrayList<Client> client;

	public Vendeur(){
		
		client = new ArrayList<Client>();
		
		Fenetre frame = new Fenetre(client);
		frame.menu();
	}

	// Methodes
	public void ajouterClient(String nom, String prenom, Telephone tel){
		client.add(new Client(nom, prenom, tel));
	}

	//Accesseurs
	public ArrayList<Client> getClient() {
		return client;
	}
	public void setClient(ArrayList<Client> client) {
		this.client = client;
	}
}
