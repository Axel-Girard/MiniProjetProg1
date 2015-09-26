package modele;

import java.util.HashMap;

import vue.Fenetre;
import controller.Client;
import controller.ListeArticles;

public class Vendeur {
	private HashMap<Client, ListeArticles> client;

	public Vendeur(){
		client = new HashMap<Client, ListeArticles>();
		Fenetre frame = new Fenetre(client);
		frame.menu();
	}

	// Methodes
	public void ajouterClient(String nom, String prenom){
		client.put(new Client(nom, prenom), null);
	}

	//Accesseurs
	public HashMap<Client, ListeArticles> getClient() {
		return client;
	}
	public void setClient(HashMap<Client, ListeArticles> client) {
		this.client = client;
	}
}
