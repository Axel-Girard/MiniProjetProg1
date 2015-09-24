import java.util.HashSet;

/* commentaire x2 HD Remix of the heart */
public abstract class Accessoire {
	private HashSet<Marque> marque;

	public Accessoire(){
		marque = new HashSet<Marque>();
	}

	public HashSet<Marque> getMarque() {
		return marque;
	}
	public void setMarque(HashSet<Marque> marque) {
		this.marque = marque;
	}
}
