package vue;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Client;
import controller.ListeArticles;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	private JPanel panel;

	private PanneauMenu panelMenu;
	private PanneauAjoutClient panelAjtCl;

	private CardLayout cl;
	private String[] listPanel = {"MenuGeneral", "AjoutClient"};
	private HashMap<Client, ListeArticles> client;

	public Fenetre(HashMap<Client, ListeArticles> client) {
		this.client = client;
		panel = new JPanel();
		panelMenu = new PanneauMenu(this);
		panelAjtCl = new PanneauAjoutClient(this);
		cl = new CardLayout();

		this.setTitle("Magasin du futur de l'espôce !");
		this.setSize(350, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);

		panel.setLayout(cl);
		panel.add(panelMenu, listPanel[0]);
		panel.add(panelAjtCl, listPanel[1]);
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
		panelAjtCl.menu();
		cl.show(panel, listPanel[1]);
	}

	/**
	 * @return the client
	 */
	public HashMap<Client, ListeArticles> getClient() {
		return client;
	}

	/**
	 * @param client le Client à mettre à jour
	 */
	public void setClient(HashMap<Client, ListeArticles> client) {
		this.client = client;
	}
}