package vue;

import modele.BaseDeDonnees;


@SuppressWarnings("serial")
public class PanneauAjoutArticle extends PanneauSelectionMultiple{

	private BaseDeDonnees bdd;

	PanneauAjoutArticle(Fenetre fen) {
		super(fen);

		bdd = BaseDeDonnees.getInstance();
	}

	@Override
	public void supprimer(int cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		
	}

	// Accesseur
	/**
	 * @param a the a to set
	 */
	/*public void setA(Article a) {
		this.a = a;
	}*/

}
