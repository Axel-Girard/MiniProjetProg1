package modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import vue.Fenetre;
import controller.Article;
import controller.Client;
import controller.Telephone;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class Vendeur {

	private ArrayList<Client> clients;
	private Fenetre frame;

	public Vendeur(){
		clients = new ArrayList<Client>();
		
		frame = new Fenetre(clients, this);
		frame.menu();
	}

	// Methodes
	public void ajouterClient(String nom, String prenom, Telephone tel){
		clients.add(new Client(nom, prenom, tel));
	}
	public void sauvegarder(){
		try {
			FileWriter fw = new FileWriter("src/sauvegardeTotal.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(Client c : clients){
				String strNom = c.getNom() + " " + c.getPrenom() + " : ";
				bw.write(strNom , 0, strNom.length());
				for(Article a : c.getListe().getArticles()){
					String strArticle = a.toString() + "\n";
					bw.write(strArticle , 0, strArticle.length());
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Accesseurs
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> client) {
		this.clients = client;
	}
}
