package modele;

import java.util.HashMap;

import controller.Client;
import controller.ListeArticles;

public class MenuVendeur {
	HashMap<Client, ListeArticles> client;

	public MenuVendeur(){
		System.out.println("Veuillez choisir un numéro : ");
		System.out.println("1 - Ajouter un client");
		System.out.println("2 - Editer les informations d'un client");
		System.out.println("3 - Supprimer un client");
		System.out.println("4 - Ajouter un article à la liste d'achat d'un client");
		System.out.println("5 - Supprimer un article de la liste d'achat d'un client");
		System.out.println("x - Sauvegarder et quitter");
		System.out.println("q - Quitter sans sauvegarder");
	}

	public void ajouterClient(String nom, String prenom){
		client.put(new Client(nom, prenom), null);
	}
}
