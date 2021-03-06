package modele;

import controller.Article;
import controller.Chargeur;
import controller.Coque;
import controller.Cordon;
import controller.ListeArticles;
import controller.Type;


/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class MagasinConsole {

	/**
	 * Lance le projet en console.
	 * Le projet r�pond � chaque question du sujet les une apr�s les autres.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome in the magasin of the future of demain !");

		ListeArticles liste = new ListeArticles();

		Article a1 = new Coque(001,"coc01",(float)5.4,"Rouge");
		Article a2 = new Chargeur(002,"cha01",(float)2.3,Type.usb);
		Article a3 = new Cordon(003,"cord01",(float)12.5,(float)2);

		liste.ajouter(a1);
		liste.ajouter(a2);
		liste.ajouter(a3);

		System.out.println("Par ref :");
		liste.tousLesArticles_ParRef(true);
		liste.tousLesArticles_ParRef(false);

		System.out.println("\nPar prix :");
		liste.tousLesArticles_ParPrix(true);
		liste.tousLesArticles_ParPrix(false);

		System.out.println("\nPar intitule :");
		liste.tousLesArticles_ParIntitule(true);
		liste.tousLesArticles_ParIntitule(false);

		liste.sauvegarde();
	}
}
