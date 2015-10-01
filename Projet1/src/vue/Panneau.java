package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel{
	protected JLabel lbl;
	protected Fenetre fen;

	Panneau(Fenetre fen){
		this.fen = fen;
		lbl = new JLabel();

		this.setVisible(true);
	}
}
