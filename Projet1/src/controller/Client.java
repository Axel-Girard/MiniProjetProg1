package controller;

public class Client {
	private ListeArticles liste;
	private String nom;
	private String prenom;
	private Telephone tel;

	public Client(ListeArticles liste, String nom, Telephone tel, String prenom){
		this.liste = liste;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	public Client(String nom, String prenom, Telephone tel){
		this.liste = new ListeArticles();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
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
	/**
	 * @return the tel
	 */
	public Telephone getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(Telephone tel) {
		this.tel = tel;
	}

	public float getTotalAchat(){
		return liste.totalListe();
	}

	// toString
	public String toString() {
		return nom + ", " + prenom;
	}

}
