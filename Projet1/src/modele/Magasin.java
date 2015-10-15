package modele;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class Magasin {
	private static Vendeur vendeur;

	// main de l'application
	public static void main(String[] args) {
		vendeur = new Vendeur();
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
