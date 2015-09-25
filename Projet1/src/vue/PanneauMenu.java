package vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauMenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanneauMenu(){
		this.setBackground(Color.ORANGE);
	}
	public void paintComponent(Graphics g){
		//Vous verrez cette phrase chaque fois que la méthode sera invoquée
		g.fillOval(20, 20, 75, 75);
	}  
}
