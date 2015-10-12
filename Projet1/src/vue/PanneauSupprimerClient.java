package vue;

import java.awt.Color;

import javax.swing.JCheckBox;

import controller.Client;

@SuppressWarnings("serial")
public class PanneauSupprimerClient extends PanneauSupprimer{

	PanneauSupprimerClient(Fenetre fen){
		super(fen);

		this.setBackground(Color.DARK_GRAY);
	}

	/**
	 * Affiche une liste pour selectionner un client
	 */
	public void menu() {
		System.out.println("Menu SC");
		super.menu();
		lbl.setText("Suppression d'un client");
		btnVldr.setText("SupprimerClient");
	}

	/**
	 * Met à jour l'interface de selection des clients
	 */
	public void miseAJour(){
		pan.removeAll();
		pan.repaint();
		arrayCompo.clear();
		for(Client c : fen.getClient()){
			arrayCompo.add(new JCheckBox(c.getNom() + " " + c.getPrenom()));
		}
	}

	@Override
	public void supprimer(int cpt) {
		if(!fen.getClient().isEmpty()){
			fen.getClient().remove(fen.getClient().get(cpt));
		}
	}
}
