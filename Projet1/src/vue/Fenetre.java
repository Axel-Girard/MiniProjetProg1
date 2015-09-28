package vue;

import java.awt.CardLayout;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Client;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	private JPanel panel;

	private PanneauMenu panelMenu;
	private PanneauAjoutClient panelAjtClnt;
	private PanneauEditerClient panelEdtClnt;

	private CardLayout cl;
	private String[] listPanel = {"MenuGeneral", "AjoutClient", "EditerClient"};
	private HashSet<Client> client;

	public Fenetre(HashSet<Client> client) {
		this.client = client;
		panel = new JPanel();
		panelMenu = new PanneauMenu(this);
		panelAjtClnt = new PanneauAjoutClient(this);
		panelEdtClnt = new PanneauEditerClient(this);
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
	 * Afficle le formulaire d'ajout d'un client
	 */
	public void editerClient(){
		panelEdtClnt.menu();
		cl.show(panel, listPanel[2]);
	}

	/**
	 * @return the client
	 */
	public HashSet<Client> getClient() {
		return client;
	}

	/**
	 * @param client le Client à mettre à jour
	 */
	public void setClient(HashSet<Client> client) {
		this.client = client;
	}
}