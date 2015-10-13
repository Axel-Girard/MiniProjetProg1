package modele;

import controller.Article;
import controller.Chargeur;
import controller.Coque;
import controller.Cordon;
import controller.ListeArticles;
import controller.Type;

public class Magasin {
	private static Vendeur vendeur;

	// main de l'application
	public static void main(String[] args) {
		System.out.println("Welcome in the magasin of the future of demain !");
		vendeur = new Vendeur();
	}

	// methodes
	public static void testBasique(){
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

	// Accesseurs
	/**
	 * @return the vendeur
	 */
	public static Vendeur getVendeur() {
		return vendeur;
	}
	/**
	 * @param vendeur the vendeur to set
	 */
	public static void setVendeur(Vendeur vendeur) {
		Magasin.vendeur = vendeur;
	}
}
