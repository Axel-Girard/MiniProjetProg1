package vue;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4042713508717400450L;

	PanneauMenu panel = new PanneauMenu();

	public Fenetre() {
		this.setTitle("Magasin du futur de l'espôce !");
		this.setSize(350, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);
	}

	public static void main(String [] args){
		JFrame frame = new Fenetre();
	}
}
