package modele;

import java.util.ArrayList;

import vue.Fenetre;
import controller.Client;
import controller.Telephone;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class Vendeur {
	private ArrayList<Client> clients;

	public Vendeur(){
		
		clients = new ArrayList<Client>();
		
		Fenetre frame = new Fenetre(clients);
		frame.menu();
	}

	// Methodes
	public void ajouterClient(String nom, String prenom, Telephone tel){
		clients.add(new Client(nom, prenom, tel));
	}

	//Accesseurs
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> client) {
		this.clients = client;
	}
}
