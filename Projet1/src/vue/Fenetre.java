package vue;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Client;
import controller.Marque;
import controller.Operateur;
import controller.Telephone;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	private JPanel panel;

	private PanneauMenu panelMenu;
	private PanneauAjoutClient panelAjtClnt;
	private PanneauEditerClient panelEdtClnt;
	private PanneauSupprimerClient panelSuppClnt;
	private PanneauAjoutArticle panelAjtArtcl;

	private CardLayout cl;
	private String[] listPanel = {"MenuGeneral", "AjoutClient", "EditerClient", "SupprimerClient", "AjouterArticle"};
	private ArrayList<Client> client;

	public Fenetre(ArrayList<Client> client) {
		this.client = client;

		Telephone tel = new Telephone(12, "Samsung wave 1", (float) 125.50, "0612538967", new Operateur("Bouigue"), new Marque("Samsung"));
		client.add(new Client("Johston", "Waverly", tel));		// A SUPPRIMER !!!!!!!!! (et au dessus aussi)

		panel = new JPanel();
		panelMenu = new PanneauMenu(this);
		panelAjtClnt = new PanneauAjoutClient(this);
		panelEdtClnt = new PanneauEditerClient(this);
		panelSuppClnt = new PanneauSupprimerClient(this);
		panelAjtArtcl = new PanneauAjoutArticle(this);

		cl = new CardLayout();

		this.setTitle("Magasin du futur de l'espôce !");
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
		panel.add(panelAjtArtcl, listPanel[4]);
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