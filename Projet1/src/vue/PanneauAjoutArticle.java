package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Article;


@SuppressWarnings("serial")
public class PanneauAjoutArticle extends PanneauAjout{

	private Article a;

	PanneauAjoutArticle(Fenetre fen) {
		super(fen);

	}

	@Override
	public void actionListener() {
		creer = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Valider");
				
			}
		};
		editer = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Valider Edit");
				//c.setNom(jtfNom.getText());
				//c.setPrenom(jtfPrenom.getText());
				fen.menu();
			}
		};
	}

	@Override
	public void menu() {
		
	}

	@Override
	public void editer() {
		
	}

	// Accesseur
	/**
	 * @param a the a to set
	 */
	public void setA(Article a) {
		this.a = a;
	}

}
