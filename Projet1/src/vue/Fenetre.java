package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4042713508717400450L;

	JPanel panel;
	PanneauMenu panelMenu;

	public Fenetre() {
		panel = new JPanel();
		panelMenu = new PanneauMenu();

		this.setTitle("Magasin du futur de l'espôce !");
		this.setSize(350, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);
		panel.add(panelMenu);
	}

	/**
	 * Affiche le menu
	 */
	public void menu(){
		panelMenu.menu();
	}

	public static void main(String [] args){
		Fenetre frame = new Fenetre();
		frame.menu();
	}
}
