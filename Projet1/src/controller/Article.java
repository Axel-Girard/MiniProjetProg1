package controller;

public abstract class Article {
	protected int ref;
	protected String intitule;
	protected float prix;

	Article(int ref, String intitule, float prix) {
		this.ref = ref;
		this.intitule = intitule;
		this.prix = prix;
	}

	// Getter Setter
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return this.ref + " " + this.intitule + " " + this.prix;
	}
}
