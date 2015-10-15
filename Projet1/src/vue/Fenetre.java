package vue;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Vendeur;
import controller.Client;
import controller.Marque;
import controller.Operateur;
import controller.Telephone;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private JPanel panel;

	private PanneauMenu panelMenu;
	private PanneauAjoutClient panelAjtClnt;
	private PanneauEditerClient panelEdtClnt;
	private PanneauSupprimerClient panelSuppClnt;
	private PanneauAjoutArticle panelAjtArtcl;
	private PanneauPayement panelPayer;
	private PanneauSupprimerArticle panelSupprArtcl;

	private CardLayout cl;
	private String[] listPanel = {"MenuGeneral", "AjoutClient", "EditerClient",
			"SupprimerClient", "AjouterArticle", "FairePayer", "Supprimer"};
	private ArrayList<Client> clients;

	private Vendeur vendeur;

	public Fenetre(ArrayList<Client> client, Vendeur vendeur) {
		this.clients = client;
		this.vendeur = vendeur;

		Telephone tel = new Telephone(12, "Samsung wave 1", (float) 125.50, "0612538967", new Operateur("Bouigue"), new Marque("Samsung"));
		client.add(new Client("Johston", "Waverly", tel));		// A SUPPRIMER !!!!!!!!! (et au dessus aussi)

		panel = new JPanel();
		panelMenu = new PanneauMenu(this);
		panelAjtClnt = new PanneauAjoutClient(this);
		panelEdtClnt = new PanneauEditerClient(this);
		panelSuppClnt = new PanneauSupprimerClient(this);
		panelAjtArtcl = new PanneauAjoutArticle(this);
		panelPayer = new PanneauPayement(this);
		panelSupprArtcl = new PanneauSupprimerArticle(this);

		cl = new CardLayout();

		this.setTitle("Magasin du futur de l'espôce !");
		this.setMinimumSize(new Dimension(350, 500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);

		panel.setLayout(cl);
		panel.add(panelMenu, listPanel[0]);
		panel.add(panelAjtClnt, listPanel[1]);
		panel.add(panelEdtClnt, listPanel[2]);
		panel.add(panelSuppClnt, listPanel[3]);
		panel.add(panelAjtArtcl, listPanel[4]);
		panel.add(panelPayer, listPanel[5]);
		panel.add(panelSupprArtcl, listPanel[6]);
	}

	/**
	 * Affiche le menu
	 */
	public void menu(){
		panelMenu.menu();
		cl.show(panel, listPanel[0]);
	}

	/**
	 * Afficle le formulaire d'ajout d'un client
	 */
	public void ajoutClient(){
		panelAjtClnt.menu();
		cl.show(panel, listPanel[1]);
	}

	/**
	 * Afficle le formulaire d'édition d'un client
	 */
	public void editerClient(){
		panelEdtClnt.menu();
		cl.show(panel, listPanel[2]);
	}

	/**
	 * Edite le client
	 * @param c Client à éditer
	 */
	public void editerClient(Client c){
		panelAjtClnt.setC(c);
		panelAjtClnt.editer();
		cl.show(panel, listPanel[1]);
	}

	/**
	 * Afficle le formulaire de suppression de client
	 */
	public void supprimerClient(){
		panelSuppClnt.menu();
		cl.show(panel, listPanel[3]);
	}

	/**
	 * Afficle le formulaire d'ajout d'un article à un client
	 */
	public void ajouterArticle(){
		panelAjtArtcl.menu();
		cl.show(panel, listPanel[4]);
	}

	/**
	 * Selection un client à faire payer un client
	 */
	public void payer() {
		panelPayer.menu();
		cl.show(panel, listPanel[5]);
	}

	/**
	 * Fait payer un client
	 */
	public void fairePayer(Client c) {
		panelPayer.payer(c);
		cl.show(panel, listPanel[5]);
	}

	/**
	 * Selection un client pour supprimer un de ses articles
	 */
	public void supprimerArticle(){
		panelSupprArtcl.menu();
		cl.show(panel, listPanel[6]);
	}

	/**
	 * @return the client
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * @param client le Client à mettre à jour
	 */
	public void setClients(ArrayList<Client> client) {
		this.clients = client;
	}
	/**
	 * retourn le vendeur qui a instanci� la fenetre
	 * @return Vendeur
	 */
	public Vendeur getVendeur() {
		return vendeur;
	}

	/**
	 * @return true si un des clients à au moins un article dans son panier
	 */
	public boolean isArticle(){
		for(Client c : clients){
			if(!c.getListe().isEmpty()){
				return true;
			}
		}
		return false;
	}
}