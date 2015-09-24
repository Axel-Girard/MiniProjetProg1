
public abstract class Arcticle {
	protected int ref;
	protected String intitule;
	protected float prix;

	public Arcticle(int ref, String intitule, float prix) {
		this.ref = ref;
		this.intitule = intitule;
		this.prix = prix;
	}

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

}
