package controller;

public class Client {
	private ListeArticles liste;
	private String nom;
	private String prenom;

	public Client(ListeArticles liste, String nom, String prenom){
		this.liste = liste;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client(String nom, String prenom){
		this.liste = new ListeArticles();
		this.nom = nom;
		this.prenom = prenom;
		System.out.println("Client créer " + nom + " " + prenom);
	}

	// methodes
	/**
	 * Permet d'ajouter un article à un client
	 * @param a l'article à ajouter à son panier
	 */
	public void ajouter(Article a){
		liste.ajouter(a);
	}
	/**
	 * Permet de supprimer un article à un client
	 * @param a l'article à supprimer du panier
	 */
	public void supprimer(Article a){
		liste.supprimer(a);
	}

	/**
	 * Renvoie le total de la liste d'articles du client
	 * @return float
	 */
	public float totalListe(){
		return liste.totalListe();
	}
	
	// Accesseurs
	public ListeArticles getListe() {
		return liste;
	}
	public void setListe(ListeArticles liste) {
		this.liste = liste;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
