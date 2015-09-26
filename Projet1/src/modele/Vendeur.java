package modele;

import java.util.HashSet;

import vue.Fenetre;
import controller.Client;

public class Vendeur {
	private HashSet<Client> client;

	public Vendeur(){
		client = new HashSet<Client>();
		Fenetre frame = new Fenetre(client);
		frame.menu();
	}

	// Methodes
	public void ajouterClient(String nom, String prenom){
		client.add(new Client(nom, prenom));
	}

	//Accesseurs
	public HashSet<Client> getClient() {
		return client;
	}
	public void setClient(HashSet<Client> client) {
		this.client = client;
	}
}
