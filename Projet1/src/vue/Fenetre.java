package vue;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Client;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	private JPanel panel;

	private PanneauMenu panelMenu;
	private PanneauAjoutClient panelAjtClnt;
	private PanneauEditerClient panelEdtClnt;
	private PanneauSupprimerClient panelSuppClnt;

	private CardLayout cl;
	private String[] listPanel = {"MenuGeneral", "AjoutClient", "EditerClient", "SupprimerClient"};
	private ArrayList<Client> client;

	public Fenetre(ArrayList<Client> client) {
		this.client = client;

		client.add(new Client("NOM", "prenom"));		// A SUPPRIMER !!!!!!!!!

		panel = new JPanel();
		panelMenu = new PanneauMenu(this);
		panelAjtClnt = new PanneauAjoutClient(this);
		panelEdtClnt = new PanneauEditerClient(this);
		panelSuppClnt = new PanneauSupprimerClient(this);
		cl = new CardLayout();

		this.setTitle("Magasin du futur de l'espoce !");
		this.setSize(350, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);

		panel.setLayout(cl);
		panel.add(panelMenu, listPanel[0]);
		panel.add(panelAjtClnt, listPanel[1]);
		panel.add(panelEdtClnt, listPanel[2]);
		panel.add(panelSuppClnt, listPanel[3]);
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
	 * Afficle le formulaire de suppression de client
	 */
	public void supprimerClient(){
		panelSuppClnt.menu();
		cl.show(panel, listPanel[3]);
	}

	/**
	 * @return the client
	 */
	public ArrayList<Client> getClient() {
		return client;
	}

	/**
	 * @param client le Client à mettre à jour
	 */
	public void setClient(ArrayList<Client> client) {
		this.client = client;
	}

	/**
	 * @return true si un des clients à au moins un article dans son panier
	 */
	public boolean isArticle(){
		for(Client c : client){
			if(!c.getListe().isEmpty()){
				return true;
			}
		}
		return false;
	}
}